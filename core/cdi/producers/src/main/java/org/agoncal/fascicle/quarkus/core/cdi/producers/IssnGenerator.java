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

    @Inject
    @EightDigits
    String prefix;

    @Inject
    @EightDigits
    int postfix;

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

    public String generateNumber() {
        return prefix + "-" + Math.abs(new Random().nextInt()) + "-" + postfix;
    }
}
// end::adocSnippet[]
