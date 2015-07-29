package com.livebreathecode.examples.clamcard;

import java.math.BigDecimal;

public class ClamCard {
    private static BigDecimal CAP = new BigDecimal("8.00");
    private BigDecimal totalCharge = new BigDecimal("0.00");

    public BigDecimal totalCharge() {
        return CAP.min(totalCharge);
    }

    public ClamCard swipedFor(Journey journey) {
        totalCharge = totalCharge.add(journey.charge());
        return this;
    }

    public BigDecimal capPrice() {
        return null;
    }
}
