package com.daiane.pix.converter.codigoValidacao;

import com.daiane.pix.domain.codigovalidacao.CodigoValidacaoInput;
import com.daiane.pix.domain.codigovalidacao.CodigoValidacaoOutput;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacaoId;
import com.daiane.pix.gateway.database.entity.conta.Conta;

public class CodigoValidacaoConverter {

    public static CodigoValidacaoOutput converter(CodigoValidacaoInput codigoValidacaoInput) {
        var codigoValidacaoOutput = new CodigoValidacaoOutput();
        codigoValidacaoOutput.setCodigo(codigoValidacaoInput.getCodigoValidacao());
        return codigoValidacaoOutput;
    }

}
