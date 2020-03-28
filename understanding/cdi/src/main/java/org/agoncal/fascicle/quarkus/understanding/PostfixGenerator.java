package org.agoncal.fascicle.quarkus.understanding;

import javax.enterprise.inject.Produces;

// tag::adocSnippet[]
public class PostfixGenerator {

    @Produces
    @ThirteenDigits
    public int getIsbnPostfix() {
        return 13;
    }

    @Produces
    @EightDigits
    public int getIssnPostfix() {
        return 8;
    }
}
// end::adocSnippet[]
