package com.livebreathecode.examples.clamcard;

import java.math.BigDecimal;

public class Zone {
    private final BigDecimal visitCost;

    public static Zone visitCost(BigDecimal visitCost) {
        return new Zone(visitCost);
    }

    private Zone(BigDecimal visitCost) {
        this.visitCost = visitCost;
    }

    public static Zone zoneA() {
        return visitCost(new BigDecimal("2.50"));
    }

    public static Zone zoneB() {
        return visitCost(new BigDecimal("3.00"));
    }

    public Station station() {
        return new Station(visitCost);
    }

    public BigDecimal singlePrice() {
        return visitCost;
    }

    public BigDecimal capPrice() {
        return new BigDecimal("8.00");
    }
}
