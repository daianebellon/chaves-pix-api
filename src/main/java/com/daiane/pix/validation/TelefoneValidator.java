package com.daiane.pix.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TelefoneValidator {

    public static boolean validar(String numeroTelefone) {

        if (numeroTelefone == null) {
            throw new NullPointerException(Mensagens.MENSAGEM_PHONE_INVALIDO);
        }

        return numeroTelefone.matches("^[+]?[0-9]{13}$");
    }
}
