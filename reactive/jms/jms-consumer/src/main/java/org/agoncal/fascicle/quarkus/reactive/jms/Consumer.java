package org.agoncal.fascicle.quarkus.reactive.jms;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@ApplicationScoped
public class Consumer implements Runnable {

  @Inject
  ConnectionFactory connectionFactory;

  // tag::adocSkip[]

  private final ExecutorService scheduler = Executors.newSingleThreadExecutor();

  private volatile String lastPrice;

  public String getLastPrice() {
    return lastPrice;
  }

  void onStart(@Observes StartupEvent ev) {
    scheduler.submit(this);
  }

  void onStop(@Observes ShutdownEvent ev) {
    scheduler.shutdown();
  }

  @Override
  public void run() {
    try (JMSContext context = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
      JMSConsumer consumer = context.createConsumer(context.createQueue("prices"));
      while (true) {
        Message message = consumer.receive();
        if (message == null) return;
        lastPrice = message.getBody(String.class);
        System.out.println("Price received:" + lastPrice);
      }
    } catch (JMSException e) {
      throw new RuntimeException(e);
    }
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
