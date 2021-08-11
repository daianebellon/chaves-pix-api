package com.daiane.pix.usecase.chavepix;

import com.daiane.pix.converter.chavepix.ChavePixConverter;
import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.gateway.database.repository.ChavePixRepository;
import com.daiane.pix.validation.ChavePixInputValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastrarChavePix {

    private final ChavePixRepository chavePixRepository;
    private final ChavePixInputValidation chavePixInputValidation;

    @Transactional
    public ChavePixOutput executar(ChavePixInput chavePixInput) {
        chavePixInputValidation.validar(chavePixInput);

        var chavePix = ChavePixConverter.converter(chavePixInput);

        chavePix = chavePixRepository.save(chavePix);

        return ChavePixConverter.converter(chavePix);
    }
}