package com.livebreathecode.examples.clamcard;

import java.math.BigDecimal;

public class Station {
    private final BigDecimal costToVisit;

    public Station(BigDecimal costToVisit) {
        this.costToVisit = costToVisit;
    }

    public BigDecimal costToVisit() {
        return costToVisit;
    }
}
