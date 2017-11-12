package com.brcities.city;

import java.util.Optional;
import java.util.function.Function;

public interface EntityFacade {

    Optional<Function> getPropertyAsFunction(String property);
}
