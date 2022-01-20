package com.daiane.pix.usecase.codigovalidacao;

import com.daiane.pix.domain.codigovalidacao.CodigoValidacaoInput;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.entity.codigovalidacao.TipoStatus;
import com.daiane.pix.gateway.database.repository.CodigoValidacaoRepository;
import com.daiane.pix.validation.Mensagens;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidarCodigoValidacao {

    private final CodigoValidacaoRepository codigoValidacaoRepository;

    @Transactional
    public void executar(CodigoValidacaoInput codigoValidacaoInput) {
        Optional<CodigoValidacao> codigoValidacao = codigoValidacaoRepository
                .findByCodigoOtpAndCodigoValidacaoIdContaIdAndCodigoValidacaoIdTipoChaveAndCodigoValidacaoIdValorChaveAndTipoStatus(
                        codigoValidacaoInput.getCodigoValidacao(),
                        codigoValidacaoInput.getContaId(),
                        codigoValidacaoInput.getTipoChave(),
                        codigoValidacaoInput.getValorChave(),
                        TipoStatus.NAO_UTILIZADO);

        if (codigoValidacao.isEmpty()) {
            throw new IllegalArgumentException(Mensagens.MENSAGENS_CODIGO_VALIDACAO_INVALIDO);
        }
    }
}