package com.livebreathecode.examples.clamcard;

import org.junit.Ignore;
import org.junit.Test;

import static com.livebreathecode.examples.clamcard.Zone.zoneA;
import static org.assertj.core.api.Assertions.assertThat;

public class ClamCardTest {
    @Ignore
    @Test
    public void hasCapForZoneA() {
        assertThat(new ClamCard()
                        .swipedFor(Journey.travellingBetween(zoneA().station(), zoneA().station()))
                        .capPrice()
        ).isEqualTo(zoneA().capPrice());
    }
}