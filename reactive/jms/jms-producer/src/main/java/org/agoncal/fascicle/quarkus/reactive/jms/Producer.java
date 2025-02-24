package org.agoncal.fascicle.quarkus.reactive.jms;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@ApplicationScoped
public class Producer implements Runnable {

  @Inject
  ConnectionFactory connectionFactory;

  // tag::adocSkip[]

  private final Random random = new Random();
  private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

  void onStart(@Observes StartupEvent ev) {
    scheduler.scheduleWithFixedDelay(this, 0L, 5L, TimeUnit.SECONDS);
  }

  void onStop(@Observes ShutdownEvent ev) {
    scheduler.shutdown();
  }

  @Override
  public void run() {
    try (JMSContext context = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
      String price = Integer.toString(random.nextInt(100));
      System.out.println("Sending Price:" + price);
      context.createProducer().send(context.createQueue("prices"), price);
    }
  }  // end::adocSkip[]
}
// end::adocSnippet[]
