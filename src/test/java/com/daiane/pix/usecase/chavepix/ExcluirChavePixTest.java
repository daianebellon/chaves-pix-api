package com.daiane.pix.usecase.chavepix;

import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.repository.ChavePixRepository;
import com.daiane.pix.validation.IdValidator;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExcluirChavePixTest {

    private final ChavePixRepository chavePixRepository = Mockito.mock(ChavePixRepository.class);
    private final IdValidator idValidator = new IdValidator();

    @Test
    void executar() {
        ChavePix chavePix = new ChavePix();
        chavePix.setIdChave(1);

        Mockito.when(chavePixRepository.findById(Mockito.any())).thenReturn(Optional.of(chavePix));
        Mockito.doNothing().when(chavePixRepository).deleteById(Mockito.any());

        ExcluirChavePix excluirChavePix = new ExcluirChavePix(chavePixRepository, idValidator);
        excluirChavePix.excluir(chavePix.getIdChave());

        Mockito.verify(chavePixRepository).deleteById(1);
    }
}