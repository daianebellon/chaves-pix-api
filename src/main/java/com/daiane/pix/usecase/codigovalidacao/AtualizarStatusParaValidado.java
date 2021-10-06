package com.daiane.pix.usecase.codigovalidacao;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.domain.codigovalidacao.CodigoValidacaoInput;
import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.repository.CodigoValidacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UtilizarCodigoValidacao {

    private final CodigoValidacaoRepository codigoValidacaoRepository;

    @Transactional
    public boolean executar(CodigoValidacaoInput codigoValidacaoInput) {
        codigoValidacaoRepository.updateStatusCodigoValidacao();
    }

    //valorchave, codigo validacao, conta, tipo chave
}
