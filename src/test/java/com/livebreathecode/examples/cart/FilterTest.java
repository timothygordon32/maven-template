package com.livebreathecode.examples.cart;

import org.junit.Test;

import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest {
    @Test
    public void filteringAboveAValue() {
        final Filter filter = new Filter();
        assertThat(asList(1, 2, 3, 4, 5, 6)
                .stream().filter(filter::lessThanOrEqualToThree).collect(Collectors.toList()))
                .containsOnly(1, 2, 3);
    }
}
