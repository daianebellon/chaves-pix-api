package com.daiane.pix.http;

import com.daiane.pix.domain.conta.ContaInput;
import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.usecase.conta.CadastrarConta;
import com.daiane.pix.usecase.conta.ExcluirConta;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaWS {

    private final CadastrarConta cadastrarConta;
    private final ExcluirConta excluirConta;

    @PostMapping
    public ContaOutput cadastrar(@RequestBody ContaInput contaInput) {
        return cadastrarConta.executar(contaInput);
    }

    @DeleteMapping("excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        return excluirConta.executar(id);
    }


}
