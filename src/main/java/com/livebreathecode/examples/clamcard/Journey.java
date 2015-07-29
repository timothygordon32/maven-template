package com.livebreathecode.examples.clamcard;

import java.math.BigDecimal;

public class Journey {
    private final Station start;
    private final Station destination;

    public Journey(Station start, Station destination) {
        this.start = start;
        this.destination = destination;
    }

    public static Journey travellingBetween(Station start, Station destination) {
        return new Journey(start, destination);
    }

    public BigDecimal charge() {
        BigDecimal costToVisitStart = start.costToVisit();
        BigDecimal costToVisitDestination = destination.costToVisit();
        return costToVisitStart.max(costToVisitDestination);
    }
}
