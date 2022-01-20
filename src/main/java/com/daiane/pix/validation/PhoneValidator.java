package com.daiane.pix.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.daiane.pix.constantes.Constantes.PHONE_EXPRESSAO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PhoneValidator {

    public static boolean validar(String numeroPhone) {
        if (numeroPhone == null) {
            throw new NullPointerException(Mensagens.MENSAGEM_PHONE_INVALIDO);
        }
        return numeroPhone.matches(PHONE_EXPRESSAO);
    }
}
