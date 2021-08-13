package com.daiane.pix.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneValidatorTest {

    @Test
    void telefoneEhNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            TelefoneValidator.validar(null);
        });
        Assertions.assertEquals(Mensagens.MENSAGEM_PHONE_INVALIDO, exception.getMessage());
    }

    @Test
    void telefoneEhValido() {
        boolean telefone = TelefoneValidator.validar("+5546991105711");
        Assertions.assertTrue(telefone);
    }

    @Test
    void telefoneEhValido2() {
        boolean telefone = TelefoneValidator.validar("5546991105711");
        Assertions.assertTrue(telefone);
    }

    @Test
    void telefoneEhValido3() {
        boolean telefone = TelefoneValidator.validar("1146991105711");
        Assertions.assertTrue(telefone);
    }

    @Test
    void telefoneEhInvalido() {
        boolean telefone = TelefoneValidator.validar("10197895478945789435905");
        Assertions.assertFalse(telefone);
    }

    @Test
    void telefoneEhInvalido2() {
        boolean telefone = TelefoneValidator.validar("823h2892he89sn2389sh");
        Assertions.assertFalse(telefone);
    }

    @Test
    void telefoneEhInvalido3() {
        boolean telefone = TelefoneValidator.validar("+554699y105711");
        Assertions.assertFalse(telefone);
    }

    @Test
    void telefoneEhVazio() {
        boolean telefone = TelefoneValidator.validar("");
        Assertions.assertFalse(telefone);
    }

    @Test
    void telefoneEhVazio2() {
        boolean telefone = TelefoneValidator.validar("                ");
        Assertions.assertFalse(telefone);
    }

}