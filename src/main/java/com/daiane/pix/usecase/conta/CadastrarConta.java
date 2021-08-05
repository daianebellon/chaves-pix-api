package com.daiane.pix.usecase.conta;

import com.daiane.pix.domain.conta.ContaInput;
import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.gateway.database.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarConta {

    private final ContaRepository contaRepository;

    public ContaOutput executar(ContaInput contaInput) {

    }

}
