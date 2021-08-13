package com.daiane.pix.validation;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ChavePixInputValidation {

    private final ContaRepository contaRepository;

    public void validar(ChavePixInput chavePixInput) {
        Objects.requireNonNull(chavePixInput.getIdConta(), Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO);
        Objects.requireNonNull(chavePixInput.getTipoChave(), Mensagens.MENSAGEM_TIPO_DE_CHAVE_INVALIDA);

        if (chavePixInput.getTipoChave().equals(TipoChave.EVP)) {
            validarEvp(chavePixInput);
        } else {
            Objects.requireNonNull(chavePixInput.getValorChave(), Mensagens.MENSAGEM_VALOR_CHAVE_INVALIDA);
        }

        var conta = validarConta(chavePixInput);

        if (chavePixInput.getTipoChave().equals(TipoChave.CPF)) {
            validarCPF(chavePixInput, conta);
        }

        if (chavePixInput.getTipoChave().equals(TipoChave.CNPJ)) {
           validarCNPJ(chavePixInput, conta);
        }

        if (chavePixInput.getTipoChave().equals(TipoChave.EMAIL)) {
            validarEmail(chavePixInput);
        }

        if (chavePixInput.getTipoChave().equals(TipoChave.PHONE)) {
            validarTelefone(chavePixInput);
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

    private void validarTelefone(ChavePixInput chavePixInput) {
        if (!TelefoneValidator.validar(chavePixInput.getValorChave())) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_PHONE_INVALIDO);
        }
    }

    private void validarEvp(ChavePixInput chavePixInput) {
        if (chavePixInput.getValorChave() != null && !chavePixInput.getValorChave().isEmpty()) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_EVP_INVALIDO);
        }

        String evp = EvpValidator.validar();

        chavePixInput.setValorChave(evp);
    }

}
