package com.daiane.pix.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EvpValidator {

    public static String validar() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0,6);
    }
}
