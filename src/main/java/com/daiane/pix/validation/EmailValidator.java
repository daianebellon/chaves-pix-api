package com.daiane.pix.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailValidator {

    public static boolean validar(String email) {

        if (email == null) {
            throw new NullPointerException(Mensagens.MENSAGEM_EMAIL_INVALIDO);
        }

        var isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            var expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            var pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            var matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
}
