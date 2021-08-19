package com.daiane.pix.validation;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ChavePixInputValidation {

    private final ContaRepository contaRepository;

    public void validar(ChavePixInput chavePixInput) {
        Objects.requireNonNull(chavePixInput.getIdConta(), Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO);
        Objects.requireNonNull(chavePixInput.getTipoChave(), Mensagens.MENSAGEM_TIPO_DE_CHAVE_INVALIDA);

        var conta = validarConta(chavePixInput);

        TipoChave tipoChave = chavePixInput.getTipoChave();
        switch (tipoChave) {
            case EVP:
                if (chavePixInput.getValorChave() != null && !chavePixInput.getValorChave().isEmpty()) {
                    throw new IllegalArgumentException(Mensagens.MENSAGEM_EVP_INVALIDO);
                }
                chavePixInput.setValorChave(UUID.randomUUID().toString());
                break;
            case CPF:
                validarCPF(chavePixInput, conta);
                break;
            case CNPJ:
                validarCNPJ(chavePixInput, conta);
                break;
            case EMAIL:
                validarEmail(chavePixInput);
                break;
            case PHONE:
                validarPhone(chavePixInput);
                break;
        }
    }

    private Conta validarConta(ChavePixInput chavePixInput) {
        Optional<Conta> existeConta = contaRepository.findById(chavePixInput.getIdConta());
        if (existeConta.isEmpty()) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO);
        }
        return existeConta.get();
    }

    private void validarCPF(ChavePixInput chavePixInput, Conta conta) {
        if (!conta.getDocumentoTitular().equals(chavePixInput.getValorChave())) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_CPF_INVALIDO);
        }
    }

    private void validarCNPJ(ChavePixInput chavePixInput, Conta conta) {
        if (!conta.getDocumentoTitular().equals(chavePixInput.getValorChave())) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_CNPJ_INVALIDO);
        }
    }

    private void validarEmail(ChavePixInput chavePixInput) {
        if (!EmailValidator.validar(chavePixInput.getValorChave())) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_EMAIL_INVALIDO);
        }
    }

    private void validarPhone(ChavePixInput chavePixInput) {
        if (!PhoneValidator.validar(chavePixInput.getValorChave())) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_PHONE_INVALIDO);
        }
    }

}
