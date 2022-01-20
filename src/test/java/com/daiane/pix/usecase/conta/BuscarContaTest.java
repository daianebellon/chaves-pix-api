package com.daiane.pix.usecase.conta;

import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.entity.conta.TipoPessoa;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import com.daiane.pix.validation.IdValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.Optional;

class BuscarContaTest {

    private final ContaRepository contaRepository = Mockito.mock(ContaRepository.class);
    private final IdValidator idValidator = new IdValidator();

    @Test
    void buscar() {
        //mocks
        ContaOutput contaOutput = new ContaOutput();
        contaOutput.setId(1);
        contaOutput.setNumeroConta(new BigInteger("1234"));
        contaOutput.setNumeroAgencia(1234);
        contaOutput.setTipoPessoa(TipoPessoa.PHYSICAL_PERSON);
        contaOutput.setDocumentoTitular("10833519905");
        contaOutput.setNumeroAgencia(1234);

        Conta conta = new Conta();
        conta.setId(1);
        conta.setNumeroConta(new BigInteger("1234"));
        conta.setNumeroAgencia(1234);
        conta.setTipoPessoa(TipoPessoa.PHYSICAL_PERSON);
        conta.setDocumentoTitular("10833519905");
        conta.setNumeroAgencia(1234);

        Mockito.when(contaRepository.findById(Mockito.any())).thenReturn(Optional.of(conta));

        //executar
        BuscarConta buscarConta = new BuscarConta(contaRepository, idValidator);
        ContaOutput resultado = buscarConta.executar(1);

        //Assertivas
        Assertions.assertEquals(contaOutput, resultado);
    }
}