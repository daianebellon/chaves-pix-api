package com.daiane.pix.http;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.usecase.chavepix.CadastrarChavePix;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chavepix")
@RequiredArgsConstructor
public class ChavePixWS {

    private final CadastrarChavePix cadastrarChavePix;

    @PostMapping
    public ChavePixOutput cadastrar(@RequestBody ChavePixInput chavePixInput) {
        return cadastrarChavePix.executar(chavePixInput);
    }

}
