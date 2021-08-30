package com.daiane.pix.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

import static com.daiane.pix.constantes.ConstantesRegex.EMAIL_EXPRESSAO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailValidator {

    public static boolean validar(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        var pattern = Pattern.compile(EMAIL_EXPRESSAO, Pattern.CASE_INSENSITIVE);
        var matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
