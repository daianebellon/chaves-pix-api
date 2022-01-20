package com.daiane.pix.usecase.chavepix;

import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.repository.ChavePixRepository;
import com.daiane.pix.validation.IdValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class BuscarChavePixPeloIdTest {

    private final ChavePixRepository chavePixRepository = Mockito.mock(ChavePixRepository.class);
    private final IdValidator idValidator = new IdValidator();

    @Test
    void buscar() {
        //mocks
        ChavePixOutput chavePixOutput = new ChavePixOutput();
        chavePixOutput.setIdChave(1);
        chavePixOutput.setIdConta(1);
        chavePixOutput.setTipoChave(TipoChave.CPF);
        chavePixOutput.setValorChave("10833519905");

        ChavePix chavePix = new ChavePix();
        chavePix.setIdChave(1);
        chavePix.setTipoChave(TipoChave.CPF);
        chavePix.setValorChave("10833519905");
        Conta conta = new Conta();
        conta.setId(1);
        chavePix.setConta(conta);

        Mockito.when(chavePixRepository.findById(Mockito.any())).thenReturn(Optional.of(chavePix));

        //executar
        BuscarChavePixPeloId buscarChavePixPeloId = new BuscarChavePixPeloId(chavePixRepository, idValidator);
        ChavePixOutput resultado = buscarChavePixPeloId.executar(1);

        //Assertivas
        Assertions.assertEquals(chavePixOutput, resultado);
    }
}