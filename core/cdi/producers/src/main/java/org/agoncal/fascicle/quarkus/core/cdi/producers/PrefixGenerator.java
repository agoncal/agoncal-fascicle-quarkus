package org.agoncal.fascicle.quarkus.core.cdi.producers;

import javax.enterprise.inject.Produces;

public class PrefixGenerator {

    @Produces
    @ThirteenDigits
    public String getIsbnPrefix() {
        return "13-84356";
    }

    @Produces
    @EightDigits
    public String getIssnPrefix() {
        return "8";
    }
}
