package org.agoncal.fascicle.quarkus.core.cdi.producers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 */
// tag::adocSnippet[]
@ApplicationScoped
@EightDigits
public class IssnGenerator implements NumberGenerator {

    // tag::adocProducer[]
    @Inject
    @EightDigits
    String prefix;

    @Inject
    @EightDigits
    int postfix;

    // end::adocProducer[]
    // tag::adocLifecycle[]
    @PostConstruct
    void init() {
        System.out.println("\n=> IssnGenerator PostConstruct");
        System.out.println("================");
    }

    @PreDestroy
    void release() {
        System.out.println("================");
        System.out.println("=> IssnGenerator PreDestroy");
    }

    // end::adocLifecycle[]
    public String generateNumber() {
        return prefix + "-" + Math.abs(new Random().nextInt()) + "-" + postfix;
    }
}
// end::adocSnippet[]
