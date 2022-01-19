package com.daiane.pix.usecase.codigovalidacao;

import com.daiane.pix.domain.codigovalidacao.CodigoValidacaoInput;
import com.daiane.pix.gateway.database.entity.codigovalidacao.TipoStatus;
import com.daiane.pix.gateway.database.repository.CodigoValidacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizarStatusParaValidado {

    private final CodigoValidacaoRepository codigoValidacaoRepository;

    @Transactional
    public void executar(CodigoValidacaoInput codigoValidacaoInput) {
        codigoValidacaoRepository.updateStatusCodigoValidacao(codigoValidacaoInput.getCodigoValidacao(),
                codigoValidacaoInput.getContaId(), codigoValidacaoInput.getTipoChave(), codigoValidacaoInput.getValorChave(), TipoStatus.VALIDADO);
    }
    //valorchave, codigo validacao, conta, tipo chave
}
