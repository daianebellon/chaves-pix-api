package com.daiane.pix.validation;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class IdValidator {

    public void validar(Integer id) {
        Objects.requireNonNull(id, Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO);

        if (id <= 0) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO);
        }
    }
}
