package com.livebreathecode.examples.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cart {
    private final List<Item> items;

    public Cart(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } if (!(obj instanceof Cart)) {
            return false;
        }

        final Cart that = (Cart) obj;
        return Objects.deepEquals(this.items, that.items);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(items);
    }
}
