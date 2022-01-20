package com.daiane.pix.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdValidatorTest {

    @Test
    void validarSeIdEhNull() {
        IdValidator idValidator = new IdValidator();

        NullPointerException e = assertThrows(NullPointerException.class, () -> {
            idValidator.validar(null);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO, e.getMessage());
    }

    @Test
    void validarSeIdEhInvalido() {
        IdValidator idValidator = new IdValidator();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            idValidator.validar(-121);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO, e.getMessage());
    }

    @Test
    void validarSeIdEhZero() {
        IdValidator idValidator = new IdValidator();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            idValidator.validar(0);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO, e.getMessage());
    }
}