package com.livebreathecode.examples.cart;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ItemTest {
    @Test
    public void canBeInitialisedWithAName() {
        assertThat(new Item("Something").getName()).isPresent().contains("Something");
    }

    @Test
    public void mustHaveAName() {
        assertThatThrownBy(() -> new Item(null).getMandatoryName())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifyEqualsAndHashCode() {
        EqualsVerifier.forClass(Item.class).verify();
    }
}