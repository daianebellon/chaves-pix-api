package com.daiane.pix.usecase.chavepix;

import com.daiane.pix.converter.chavepix.ChavePixConverter;
import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.domain.codigovalidacao.CodigoValidacaoInput;
import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.repository.ChavePixRepository;
import com.daiane.pix.usecase.codigovalidacao.AtualizarStatusParaValidado;
import com.daiane.pix.usecase.codigovalidacao.ValidarCodigoValidacao;
import com.daiane.pix.validation.ChavePixInputValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastrarChavePix {

    private final ChavePixRepository chavePixRepository;
    private final ChavePixInputValidator chavePixInputValidator;
    private final ValidarCodigoValidacao validarCodigoValidacao;
    private final AtualizarStatusParaValidado atualizarStatusParaValidado;


    @Transactional
    public ChavePixOutput executar(ChavePixInput chavePixInput) {
        chavePixInputValidator.validar(chavePixInput);

        if (chavePixInput.getTipoChave().equals(TipoChave.EMAIL) || chavePixInput.getTipoChave().equals(TipoChave.PHONE)) {
            var codigoValidacaoInput = new CodigoValidacaoInput();
            codigoValidacaoInput.setCodigoValidacao(chavePixInput.getCodigoValidacao());
            codigoValidacaoInput.setValorChave(chavePixInput.getValorChave());
            codigoValidacaoInput.setTipoChave(chavePixInput.getTipoChave());
            codigoValidacaoInput.setContaId(chavePixInput.getIdConta());

            validarCodigoValidacao.executar(codigoValidacaoInput);

            atualizarStatusParaValidado.executar(codigoValidacaoInput);
        }

        var chavePix = ChavePixConverter.converter(chavePixInput);

        chavePix = chavePixRepository.save(chavePix);

        return ChavePixConverter.converter(chavePix);
    }
}
