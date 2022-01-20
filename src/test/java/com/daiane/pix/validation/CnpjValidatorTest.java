package com.daiane.pix.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CnpjValidatorTest {

    @Test
    void cnpjEhNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CnpjValidator.validar(null);
        });
        Assertions.assertEquals(Mensagens.MENSAGEM_CNPJ_INVALIDO, exception.getMessage());
    }

    @Test
    void cnpjEhValido() {
        boolean cnpj = CnpjValidator.validar("04204018000166");
        Assertions.assertTrue(cnpj);
    }

    @Test
    void cnpjEhInvalido() {
        boolean cnpj = CnpjValidator.validar("1019905");
        Assertions.assertFalse(cnpj);
    }

    @Test
    void cnpjEhInvalido2() {
        boolean cnpj = CnpjValidator.validar("108.335.199-05");
        Assertions.assertFalse(cnpj);
    }

    @Test
    void cnpjEhVazio() {
        boolean cnpj = CnpjValidator.validar("");
        Assertions.assertFalse(cnpj);
    }

    @Test
    void cnpjEhVazio2() {
        boolean cnpj = CnpjValidator.validar("                ");
        Assertions.assertFalse(cnpj);
    }
}