package com.daiane.pix.validation;

import com.daiane.pix.domain.conta.ContaInput;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Objects;

@Component
public class ContaInputValidator {

    public void validar(ContaInput contaInput) {
        Objects.requireNonNull(contaInput.getDocumentoTitular(), Mensagens.MENSAGEM_DOCUMENTO_DO_TITULAR_INVALIDO);
        Objects.requireNonNull(contaInput.getNumeroConta(), Mensagens.MENSAGEM_NUMERO_DA_CONTA_INVALIDO);
        Objects.requireNonNull(contaInput.getNumeroAgencia(), Mensagens.MENSAGEM_NUMERO_DA_AGENCIA_INVALIDO);
        Objects.requireNonNull(contaInput.getTipoPessoa(), Mensagens.MENSAGEM_TIPO_DE_PESSOA_INVALIDA);

        if (contaInput.getNumeroConta().toString().length() > 20 || contaInput.getNumeroConta().compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_NUMERO_DA_CONTA_DEVE_SER_IGUAL_A_20);
        }

        if (contaInput.getNumeroAgencia().toString().length() > 4 || contaInput.getNumeroAgencia() < 0) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_NUMERO_DA_AGENCIA_DEVE_SER_IGUAL_A_4);
        }

        if (!CpfValidator.validar(contaInput.getDocumentoTitular()) && !CnpjValidator.validar(contaInput.getDocumentoTitular())) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_DOCUMENTO_DO_TITULAR_INVALIDO);
        }

    }
}
