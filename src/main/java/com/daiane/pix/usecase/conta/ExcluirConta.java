package com.daiane.pix.usecase.conta;

import com.daiane.pix.gateway.database.repository.ContaRepository;
import com.daiane.pix.validation.IdValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExcluirConta {

    private final ContaRepository contaRepository;
    private final IdValidator idValidator;

    @Transactional
    public void executar(Integer id) {
        idValidator.validar(id);
        contaRepository.deleteById(id);
    }
}
