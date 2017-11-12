package com.brcities.expression.addOn;

import java.util.stream.Stream;

public interface AddOn {
    Stream filter(Stream stream);

    Stream map(Stream stream);
}
