package com.daiane.pix.usecase.codigovalidacao;

import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.gateway.database.repository.CodigoValidacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Cadastrar {

    private final CodigoValidacaoRepository codigoValidacaoRepository;

    public void executar(ChavePix chavePix) {
//        CodigoValidacao codigoValidacao = new CodigoValidacao();
//        CodigoValidacaoId codigoValidacaoId = new CodigoValidacaoId();
//        codigoValidacaoId.setConta(chavePix.getConta());
//        codigoValidacaoId.setTipoChave(chavePix.getTipoChave());
//        codigoValidacaoId.setValorChave(chavePix.getValorChave());
//        codigoValidacao.setCodigoValidacaoId(codigoValidacaoId);
//        codigoValidacao.setCodigoOtp((int) (Math.random() * 999_999)); //fazer constante
    }
}
