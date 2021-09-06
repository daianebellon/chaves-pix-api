package com.daiane.pix.usecase.conta;

import com.daiane.pix.domain.conta.ContaInput;
import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.entity.conta.TipoPessoa;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import com.daiane.pix.validation.ContaInputValidator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GerarCodigoValidacaoContaTest {

    private final ContaRepository contaRepository = Mockito.mock(ContaRepository.class);
    private final ContaInputValidator contaInputValidator = new ContaInputValidator();

    @Test
    void executar() {
        //mocks
        var contaInput = new ContaInput();
        contaInput.setDocumentoTitular("10833519905");
        contaInput.setNumeroAgencia(1234);
        contaInput.setNumeroConta(new BigInteger("12345678910"));
        contaInput.setTipoPessoa(TipoPessoa.PHYSICAL_PERSON);

        var conta =  new Conta();
        conta.setId(1);
        conta.setDocumentoTitular("10833519905");
        conta.setNumeroConta(new BigInteger("12345678910"));
        conta.setNumeroAgencia(1234);
        conta.setTipoPessoa(TipoPessoa.PHYSICAL_PERSON);

        Mockito.when(contaRepository.findByNumeroAgenciaAndNumeroConta(contaInput.getNumeroAgencia(), contaInput.getNumeroConta())).thenReturn(Optional.empty());
        Mockito.when(contaRepository.save(Mockito.any())).thenReturn(conta);

        //executar
        CadastrarConta cadastrarConta = new CadastrarConta(contaRepository, contaInputValidator);
        ContaOutput contaOutput = cadastrarConta.executar(contaInput);

        //Assertivas
        assertEquals(1, contaOutput.getId());
        assertEquals(new BigInteger("12345678910"), contaOutput.getNumeroConta());
        assertEquals(1234, contaOutput.getNumeroAgencia());
        assertEquals(TipoPessoa.PHYSICAL_PERSON, contaOutput.getTipoPessoa());
    }
}