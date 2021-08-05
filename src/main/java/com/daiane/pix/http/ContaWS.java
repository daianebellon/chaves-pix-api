package com.daiane.pix.http;

import com.daiane.pix.domain.conta.ContaInput;
import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.usecase.conta.CadastrarConta;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaWS {

    private final CadastrarConta cadastrarConta;

    @PostMapping
    public ContaOutput cadastrar(@RequestBody ContaInput contaInput) {
        return cadastrarConta.executar(contaInput);
    }
}