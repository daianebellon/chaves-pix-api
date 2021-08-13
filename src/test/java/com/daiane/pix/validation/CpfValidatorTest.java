package com.daiane.pix.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfValidatorTest {

    @Test
    void cpfEhNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CpfValidator.validar(null);
        });
        Assertions.assertEquals(Mensagens.MENSAGEM_CPF_INVALIDO, exception.getMessage());
    }

    @Test
    void cpfEhValido() {
        boolean cpf = CpfValidator.validar("10833519905");
        Assertions.assertTrue(cpf);
    }

    @Test
    void cpfEhInvalido() {
        boolean cpf = CpfValidator.validar("1019905");
        Assertions.assertFalse(cpf);
    }

    @Test
    void cpfEhInvalido2() {
        boolean cpf = CpfValidator.validar("108.335.199-05");
        Assertions.assertFalse(cpf);
    }

    @Test
    void cpfEhVazio() {
        boolean cpf = CpfValidator.validar("");
        Assertions.assertFalse(cpf);
    }

    @Test
    void cpfEhVazio2() {
        boolean cpf = CpfValidator.validar("                ");
        Assertions.assertFalse(cpf);
    }
}