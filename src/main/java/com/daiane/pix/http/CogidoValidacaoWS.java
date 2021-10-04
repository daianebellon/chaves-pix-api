package com.daiane.pix.http;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
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

    @PostMapping("/gerar")
    public String gerarCodigoValidacao(@RequestBody ChavePixInput chavePixInput) {
        return gerarCodigoValidacao.executar(chavePixInput);
    }

    @PutMapping("/validar")
    public String validarCodigoValidacao(@RequestBody CodigoValidacao codigoValidacao) {
        return validarCodigoValidacao.executar(codigoValidacao);
    }

}
