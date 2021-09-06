package com.daiane.pix.http;

import com.daiane.pix.usecase.codigovalidacao.GerarCodigoValidacao;
import com.daiane.pix.usecase.codigovalidacao.ValidarCodigoValidacao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codigovalidacao")
@RequiredArgsConstructor
public class CogidoValidacaoWS {

    private final ValidarCodigoValidacao validarCodigoValidacao;
    private final GerarCodigoValidacao gerarCodigoValidacao;

    @GetMapping("gerar/{id}")
    public String gerarCodigoValidacao(@PathVariable("id") Integer idChavePix) {
        return gerarCodigoValidacao.executar(idChavePix);
    }

    @RequestMapping(method = RequestMethod.HEAD)
    public String validarCodigoValidacao(@RequestHeader("Codigo-Otp") Integer codigoOtp) {
        return validarCodigoValidacao.executar(codigoOtp);
    }



}
