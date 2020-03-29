package org.agoncal.fascicle.quarkus.core.cdi.injection;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 */
// tag::adocSnippet[]
@ApplicationScoped
public class IsbnGenerator {

    public String generateNumber() {
        return "13-" + Math.abs(new Random().nextInt()) + "-875";
    }
}
// end::adocSnippet[]
