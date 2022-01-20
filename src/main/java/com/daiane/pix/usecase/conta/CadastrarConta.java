package com.daiane.pix.usecase.conta;

import com.daiane.pix.converter.conta.ContaConverter;
import com.daiane.pix.domain.conta.ContaInput;
import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import com.daiane.pix.validation.ContaInputValidator;
import com.daiane.pix.validation.Mensagens;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CadastrarConta {

    private final ContaRepository contaRepository;
    private final ContaInputValidator contaInputValidator;

    @Transactional
    public ContaOutput executar(ContaInput contaInput) {
        contaInputValidator.validar(contaInput);

        Optional<Conta> existeConta = contaRepository
                .findByNumeroAgenciaAndNumeroConta(contaInput.getNumeroAgencia(), contaInput.getNumeroConta());

        if (existeConta.isPresent()) {
            throw new IllegalArgumentException(Mensagens.MENSAGEM_CONTA_INVALIDA);
        }

        var conta = ContaConverter.converte(contaInput);

        conta = contaRepository.save(conta);

        return ContaConverter.converte(conta);
    }
}