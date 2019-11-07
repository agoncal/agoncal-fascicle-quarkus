package org.agoncal.fascicle.quarkus.understanding;

import javax.enterprise.inject.Produces;

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
