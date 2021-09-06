package com.daiane.pix.usecase.codigovalidacao;

import com.daiane.pix.domain.codigovalidacao.CodigoValidacaoInput;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.entity.codigovalidacao.TipoStatus;
import com.daiane.pix.gateway.database.repository.CodigoValidacaoRepository;
import com.daiane.pix.validation.Mensagens;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ValidarCodigoValidacao {

    private final CodigoValidacaoRepository codigoValidacaoRepository;

    @Transactional
    public String executar(Integer codigoOtp) {
        var codigoValidacao = codigoValidacaoRepository
                .findByCodigoOtpAndTipoStatus(codigoOtp, TipoStatus.NAO_UTILIZADO)
                .orElseThrow(() -> new NullPointerException(Mensagens.MENSAGENS_CODIGO_VALIDACAO_INVALIDO));

        if (codigoValidacao.getTipoStatus().equals(TipoStatus.NAO_UTILIZADO)) {
            codigoValidacao.setTipoStatus(TipoStatus.VALIDADO);
        }

        codigoValidacaoRepository.save(codigoValidacao);

        return Mensagens.MENSAGEM_CODIGO_OTP_VALIDO;
    }
}