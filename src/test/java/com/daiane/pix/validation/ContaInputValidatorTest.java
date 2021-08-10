package com.daiane.pix.validation;

import com.daiane.pix.domain.conta.ContaInput;
import com.daiane.pix.gateway.database.entity.conta.TipoPessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class ContaInputValidatorTest {

    @Test
    void validarSeDocumentoTitularEhNull() {
        ContaInputValidator contaInputValidator = new ContaInputValidator();

        ContaInput contaInput = new ContaInput();
        contaInput.setDocumentoTitular(null);
        contaInput.setNumeroConta(new BigInteger("12345678910"));
        contaInput.setNumeroAgencia(1234);
        contaInput.setTipoPessoa(TipoPessoa.PHYSICAL_PERSON);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            contaInputValidator.validar(contaInput);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_DOCUMENTO_DO_TITULAR_INVALIDO, exception.getMessage());
    }

    @Test
    void validarSeDocumentoTitularEhInvalido() {
        ContaInputValidator contaInputValidator = new ContaInputValidator();

        ContaInput contaInput = new ContaInput();
        contaInput.setDocumentoTitular("-55454528182");
        contaInput.setNumeroConta(new BigInteger("12345678910"));
        contaInput.setNumeroAgencia(1234);
        contaInput.setTipoPessoa(TipoPessoa.PHYSICAL_PERSON);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contaInputValidator.validar(contaInput);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_DOCUMENTO_DO_TITULAR_INVALIDO, exception.getMessage());
    }
}