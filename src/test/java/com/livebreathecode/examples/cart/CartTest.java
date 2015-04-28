package com.livebreathecode.examples.cart;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static java.util.Collections.singletonList;

public class CartTest {
    @Test
    public void hasItem() {
        Assertions.assertThat(new Cart(singletonList(new Item("Ball"))).getItems()).contains(new Item("Ball"));
    }

    @Test
    public void verifyEqualsAndHashCode() {
        EqualsVerifier.forClass(Cart.class).verify();
    }
}
