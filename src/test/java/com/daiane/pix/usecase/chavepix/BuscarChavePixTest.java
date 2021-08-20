package com.daiane.pix.usecase.chavepix;

import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import com.daiane.pix.gateway.database.repository.ChavePixRepository;
import com.daiane.pix.validation.IdValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BuscarChavePixTest {

    private final ChavePixRepository chavePixRepository = Mockito.mock(ChavePixRepository.class);
    private final IdValidator idValidator = new IdValidator();

    @Test
    void buscar() {
    }
}