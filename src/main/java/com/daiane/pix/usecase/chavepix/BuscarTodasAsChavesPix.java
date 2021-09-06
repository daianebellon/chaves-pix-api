package com.daiane.pix.usecase.chavepix;

import com.daiane.pix.converter.chavepix.ChavePixConverter;
import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.gateway.database.repository.ChavePixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BuscarTodasAsChavesPix {

    private final ChavePixRepository chavePixRepository;

    @Transactional
    public Page<ChavePixOutput> executar(int pagina, int quantidade) {
        Pageable paginacao =  PageRequest.of(pagina, quantidade);
        var chavePix = chavePixRepository.findAll(paginacao);
        return ChavePixConverter.converterPage(chavePix);
    }
}
