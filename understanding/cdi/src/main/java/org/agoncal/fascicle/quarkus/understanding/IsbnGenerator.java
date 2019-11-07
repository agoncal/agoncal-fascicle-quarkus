package org.agoncal.fascicle.quarkus.understanding;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 */
// tag::adocSnippet[]
@ApplicationScoped
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    @Inject
    @ThirteenDigits
    String prefix;

    @Inject
    @ThirteenDigits
    int postfix;

    @Override
    public String generateNumber() {
        return prefix + "-" + Math.abs(new Random().nextInt()) + "-" + postfix;
    }
}
// end::adocSnippet[]
