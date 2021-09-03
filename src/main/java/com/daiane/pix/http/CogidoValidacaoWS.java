package com.daiane.pix.http;

import com.daiane.pix.domain.codigovalidacao.CodigoValidacaoInput;
import com.daiane.pix.usecase.codigovalidacao.VerificarCodigoValidacao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigovalidacao")
@RequiredArgsConstructor
public class CogidoValidacaoWS {

    private final VerificarCodigoValidacao verificarCodigoValidacao;

    @PostMapping
    public String validarCodigoValidacao(@RequestBody CodigoValidacaoInput codigoValidacaoInput) {
        return verificarCodigoValidacao.validarCodigoRecebidoTela(codigoValidacaoInput);
    }

}
