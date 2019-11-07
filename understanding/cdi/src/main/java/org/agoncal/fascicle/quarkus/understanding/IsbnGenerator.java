package org.agoncal.fascicle.quarkus.understanding;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 */
@ApplicationScoped
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Inject
    @ThirteenDigits
    String prefix;

    @Inject
    @ThirteenDigits
    int postfix;

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @PostConstruct
    private void init() {
        System.out.println("\n=> IsbnGenerator PostConstruct");
        System.out.println("================");
    }

    @PreDestroy
    private void release() {
        System.out.println("================");
        System.out.println("=> IsbnGenerator PreDestroy");
    }

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public String generateNumber() {
        return prefix + "-" + Math.abs(new Random().nextInt()) + "-" + postfix;
    }
}
