package com.daiane.pix.validation;

import com.daiane.pix.domain.conta.ContaInput;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContaInputValidator {

    public void validar(ContaInput contaInput) {
        Objects.requireNonNull(contaInput.getDocumentoTitular(), Mensagens.MENSAGEM_DOCUMENTO_DO_TITULAR_INVALIDO);
        Objects.requireNonNull(contaInput.getNumeroConta(), Mensagens.MENSAGEM_NUMERO_DA_CONTA_INVALIDO);
        Objects.requireNonNull(contaInput.getNumeroAgencia(), Mensagens.MENSAGEM_NUMERO_DA_AGENCIA_INVALIDO);
        Objects.requireNonNull(contaInput.getTipoPessoa(), Mensagens.MENSAGEM_TIPO_DE_PESSOA_INVALIDA);

    }
}
