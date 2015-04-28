package com.livebreathecode.examples.cart;

import java.util.Objects;
import java.util.Optional;

public class Item {
    private final Optional<String> name;

    public Item(String name) {
        this.name = Optional.ofNullable(name);
    }

    public Optional<String> getName() {
        return name;
    }

    public String getMandatoryName() {
        return name.orElseThrow(IllegalStateException::new);
    }

    @Override
    public final boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!(o instanceof Item)) {
            return false;
        }

        final Item that = (Item) o;

        return Objects.equals(this.name, that.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }
}
