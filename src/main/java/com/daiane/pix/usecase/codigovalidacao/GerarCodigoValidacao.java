package com.daiane.pix.usecase.codigovalidacao;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacaoId;
import com.daiane.pix.gateway.database.repository.CodigoValidacaoRepository;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import com.daiane.pix.validation.Mensagens;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.daiane.pix.constantes.Constantes.MULTIPLICADOR_PARA_CODIGO_COM_SEIS_DIGITOS;

@Service
@RequiredArgsConstructor
public class GerarCodigoValidacao {

    private final CodigoValidacaoRepository codigoValidacaoRepository;
    private final ContaRepository contaRepository;

    @Transactional
    public String executar(ChavePixInput chavePixInput) {
        var codigoValidacao = gerarCodigoValidacao(chavePixInput);
        codigoValidacaoRepository.save(codigoValidacao);
        return "Tudo ok!";
    }

    private CodigoValidacao gerarCodigoValidacao(ChavePixInput chavePix) {
        var conta = contaRepository.findById(chavePix.getIdConta())
                .orElseThrow(() -> new NullPointerException(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO));

        var codigoValidacaoId = new CodigoValidacaoId();
        codigoValidacaoId.setConta(conta);
        codigoValidacaoId.setTipoChave(chavePix.getTipoChave());
        codigoValidacaoId.setValorChave(chavePix.getValorChave());

        var codigoValidacao = new CodigoValidacao();
        codigoValidacao.setCodigoValidacaoId(codigoValidacaoId);
        codigoValidacao.setCodigoOtp(getCodigoOtp());

        return codigoValidacao;
    }

    private int getCodigoOtp() {
        return (int) (Math.random() * MULTIPLICADOR_PARA_CODIGO_COM_SEIS_DIGITOS);
    }
}

