package com.daiane.pix.validation;

import com.daiane.pix.domain.chavepix.ChavePixInput;
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
        Objects.requireNonNull(chavePixInput.getValorChave(), Mensagens.MENSAGEM_VALOR_CHAVE_INVALIDA);
        Objects.requireNonNull(chavePixInput.getTipoChave(), Mensagens.MENSAGEM_TIPO_DE_CHAVE_INVALIDA);

        Optional<Conta> existeConta = contaRepository.findById(chavePixInput.getIdConta());
        if (existeConta.isEmpty()) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO);
        }

    }
}
