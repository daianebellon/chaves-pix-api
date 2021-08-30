package com.daiane.pix.usecase.chavepix;

import com.daiane.pix.gateway.database.repository.ChavePixRepository;
import com.daiane.pix.validation.IdValidator;
import com.daiane.pix.validation.Mensagens;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExcluirChavePix {

    private final ChavePixRepository chavePixRepository;
    private final IdValidator idValidator;

    @Transactional
    public void executar(Integer id) {
        idValidator.validar(id);
        chavePixRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO));
        chavePixRepository.deleteById(id);
    }
}
