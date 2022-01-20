package com.daiane.pix.usecase.conta;

import com.daiane.pix.gateway.database.repository.ContaRepository;
import com.daiane.pix.validation.IdValidator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExcluirContaTest {

    private final ContaRepository contaRepository = Mockito.mock(ContaRepository.class);
    private final IdValidator idValidator = new IdValidator();

    @Test
    void executar() {
        Mockito.doNothing().when(contaRepository).deleteById(1);

        var excluirConta = new ExcluirConta(contaRepository, idValidator);
        excluirConta.executar(1);

        Mockito.verify(contaRepository).deleteById(1);
    }
}