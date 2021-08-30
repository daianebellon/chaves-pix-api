package com.daiane.pix.validation;

import com.daiane.pix.converter.conta.ContaConverter;
import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.entity.conta.TipoPessoa;
import com.daiane.pix.gateway.database.repository.ChavePixRepository;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChavePixInputValidatorTest {

    private final ContaRepository contaRepository = Mockito.mock(ContaRepository.class);
    private final ChavePixRepository chavePixRepository = Mockito.mock(ChavePixRepository.class);

    @Test
    void validarSeIdContaEhNull() {
        ChavePixInput chavePixInput = new ChavePixInput();
        chavePixInput.setIdConta(null);
        chavePixInput.setTipoChave(TipoChave.CPF);
        chavePixInput.setValorChave("10833519905");

        ChavePixInputValidator chavePixInputValidator = new ChavePixInputValidator(contaRepository, chavePixRepository);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            chavePixInputValidator.validar(chavePixInput);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO, exception.getMessage());
    }

    @Test
    void validarSeTipoDeChaveEhNull() {
        ChavePixInput chavePixInput = new ChavePixInput();
        chavePixInput.setIdConta(1);
        chavePixInput.setTipoChave(null);
        chavePixInput.setValorChave("10833519905");

        ChavePixInputValidator chavePixInputValidator = new ChavePixInputValidator(contaRepository, chavePixRepository);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            chavePixInputValidator.validar(chavePixInput);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_TIPO_DE_CHAVE_INVALIDA, exception.getMessage());
    }

    @Test
    void validarSeContaNaoExiste() {
        ChavePixInput chavePixInput = new ChavePixInput();
        chavePixInput.setIdConta(1);
        chavePixInput.setTipoChave(TipoChave.CPF);
        chavePixInput.setValorChave(null);

        Mockito.when(contaRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        ChavePixInputValidator chavePixInputValidator = new ChavePixInputValidator(contaRepository, chavePixRepository);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            chavePixInputValidator.validar(chavePixInput);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO, exception.getMessage());
    }

    @Test
    void validarQuantidadesDeChaves() {
        //mocks
        Conta conta = new Conta();
        conta.setId(1);
        conta.setTipoPessoa(TipoPessoa.PHYSICAL_PERSON);
        conta.setChavePixList(List.of(new ChavePix(), new ChavePix(),  new ChavePix(), new ChavePix(),  new ChavePix(),  new ChavePix()));
        Mockito.when(contaRepository.findById(Mockito.any())).thenReturn(Optional.of(conta));

        //executar
        ChavePixInput chavePixInput = new ChavePixInput();
        chavePixInput.setIdConta(1);
        chavePixInput.setTipoChave(TipoChave.CPF);
        chavePixInput.setValorChave("10833519905");

        ChavePixInputValidator chavePixInputValidator = new ChavePixInputValidator(contaRepository, chavePixRepository);

        //Assertivas
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            chavePixInputValidator.validar(chavePixInput);
        });

        Assertions.assertEquals(Mensagens.MENSAGEM_QUANTIDADE_DE_CHAVE_PIX_ATINGIDA, exception.getMessage());

    }
}