package com.livebreathecode.examples.clamcard;

import java.math.BigDecimal;
import org.junit.Test;

import static com.livebreathecode.examples.clamcard.Zone.zoneA;
import static com.livebreathecode.examples.clamcard.Zone.zoneB;
import static org.assertj.core.api.Assertions.assertThat;

public class ClamCardScenarios {

    @Test
    public void travel_within_zone_a_should_charged_at_zone_a_rate() {
        Journey journey = Journey.travellingBetween(zoneA().station(), zoneA().station());
        ClamCard card = aCard().swipedFor(journey);

        assertThat(journey.charge()).isEqualTo(zoneA().singlePrice());

        assertThat(card.totalCharge()).isEqualTo(zoneA().singlePrice());
    }

    @Test
    public void travel_involving_two_zones_at_different_rates_is_charged_at_higher_rate() {
        ClamCard card = aCard();
        Journey involvingZonesAAndB = Journey.travellingBetween(zoneA().station(), zoneB().station());
        Journey involvingZoneBOnly = Journey.travellingBetween(zoneB().station(), zoneB().station());
        card.swipedFor(involvingZonesAAndB).swipedFor(involvingZoneBOnly);

        assertThat(involvingZonesAAndB.charge()).isEqualTo(zoneB().singlePrice());

        assertThat(involvingZoneBOnly.charge()).isEqualTo(zoneB().singlePrice());

        assertThat(card.totalCharge()).isEqualTo(twoTimes(zoneB().singlePrice()));
    }

    @Test
    public void charges_are_capped_at_the_max_charge_for_zone_a() {
        ClamCard card = aCard();
        Journey involvingZoneAOnly = Journey.travellingBetween(zoneA().station(), zoneA().station());

        card.swipedFor(involvingZoneAOnly)
                .swipedFor(involvingZoneAOnly)
                .swipedFor(involvingZoneAOnly);

        assertThat(card.totalCharge()).isEqualTo(zoneA().capPrice());
    }

    @Test
    public void charges_are_capped_at_the_max_charge_for_zone_b() {
        ClamCard card = aCard();
        Journey involvingZonesAAndB = Journey.travellingBetween(zoneA().station(), zoneB().station());
        Journey involvingZoneBOnly = Journey.travellingBetween(zoneB().station(), zoneB().station());
        Journey involvingZoneBOnlyAgain = Journey.travellingBetween(zoneB().station(), zoneB().station());

        card.swipedFor(involvingZonesAAndB)
                .swipedFor(involvingZoneBOnly)
                .swipedFor(involvingZoneBOnlyAgain);

        assertThat(card.totalCharge()).isEqualTo(zoneB().capPrice());
    }

    private ClamCard aCard() {
        return new ClamCard();
    }

    private BigDecimal twoTimes(BigDecimal price) {
        return price.multiply(new BigDecimal("2"));
    }
}