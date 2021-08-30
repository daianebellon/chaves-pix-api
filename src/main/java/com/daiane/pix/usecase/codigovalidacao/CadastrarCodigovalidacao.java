package com.daiane.pix.usecase.codigovalidacao;

import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacaoId;
import com.daiane.pix.gateway.database.repository.CodigoValidacaoRepository;
import com.daiane.pix.validation.ChavePixInputValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.daiane.pix.constantes.Constantes.MULTIPLICADOR_PARA_CODIGO_COM_SEIS_DIGITOS;

@Service
@RequiredArgsConstructor
public class CadastrarCodigovalidacao {

    private final CodigoValidacaoRepository codigoValidacaoRepository;
    private final ChavePixInputValidator chavePixInputValidator;

    @Transactional
    public void executar(ChavePix chavePix) {
        gerarCodigoValidacao(chavePix);

    }

    private void gerarCodigoValidacao(ChavePix chavePix) {
        var codigoValidacaoId = new CodigoValidacaoId();
        codigoValidacaoId.setConta(chavePix.getConta());
        codigoValidacaoId.setTipoChave(chavePix.getTipoChave());
        codigoValidacaoId.setValorChave(chavePix.getValorChave());

        var codigoValidacao = new CodigoValidacao();
        codigoValidacao.setCodigoValidacaoId(codigoValidacaoId);
        codigoValidacao.setCodigoOtp((int) (Math.random() * MULTIPLICADOR_PARA_CODIGO_COM_SEIS_DIGITOS));
    }

}
