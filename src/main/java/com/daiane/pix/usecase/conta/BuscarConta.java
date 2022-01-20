package com.daiane.pix.usecase.conta;

import com.daiane.pix.converter.conta.ContaConverter;
import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import com.daiane.pix.validation.IdValidator;
import com.daiane.pix.validation.Mensagens;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BuscarConta {

    private final ContaRepository contaRepository;
    private final IdValidator idValidator;

    @Transactional
    public ContaOutput executar(Integer id) {
        idValidator.validar(id);
        var conta = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO));
        return ContaConverter.converte(conta);
    }
}
