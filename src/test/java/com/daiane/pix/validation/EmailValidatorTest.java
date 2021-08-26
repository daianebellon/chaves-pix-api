package com.daiane.pix.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    void emailEhNUll() {
        boolean emailValido = EmailValidator.validar(null);
        Assertions.assertFalse(emailValido);
    }

    @Test
    void emailEhValido() {
        boolean emailValido = EmailValidator.validar("daianebellon@hotmail.com");
        Assertions.assertTrue(emailValido);
    }

    @Test
    void emailEhValido2() {
        boolean emailValido = EmailValidator.validar("daiane.bellon@gmail.com");
        Assertions.assertTrue(emailValido);
    }

    @Test
    void emailEhValido3() {
        boolean emailValido = EmailValidator.validar("daiane@db1.com.br");
        Assertions.assertTrue(emailValido);
    }

    @Test
    void emailInvalido() {
        boolean emailValido = EmailValidator.validar("fuhsdfjihdfuisdhfsuisdfsdfsdf");
        Assertions.assertFalse(emailValido);
    }

    @Test
    void emailEhInvalido2() {
        boolean emailValido = EmailValidator.validar("daiane_bellon@hotmail");
        Assertions.assertFalse(emailValido);
    }

    @Test
    void emailInvalido3() {
        boolean emailValido = EmailValidator.validar("daiane bellon@hotmail.com");
        Assertions.assertFalse(emailValido);
    }


    @Test
    void emailInvalido4() {
        boolean emailValido = EmailValidator.validar("@@@");
        Assertions.assertFalse(emailValido);
    }

    @Test
    void emailEhVazio() {
        boolean emailValido = EmailValidator.validar("         ");
        Assertions.assertFalse(emailValido);
    }

    @Test
    void emailEhVazio2() {
        boolean emailValido = EmailValidator.validar("         ");
        Assertions.assertFalse(emailValido);
    }
}