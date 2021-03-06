package com.brcities.facades;

import java.util.Optional;
import java.util.function.Function;

public interface EntityFacade {

    Optional<Function> getPropertyAsFunction(String property);
}
