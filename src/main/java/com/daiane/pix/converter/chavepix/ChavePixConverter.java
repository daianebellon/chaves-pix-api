package com.daiane.pix.converter.chavepix;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.gateway.database.entity.conta.Conta;

import java.time.LocalDateTime;

public class ChavePixConverter {

    public static ChavePix converter(ChavePixInput chavePixInput) {
        ChavePix chavePix = new ChavePix();
        chavePix.setConta(new Conta());
        chavePix.getConta().setId(chavePixInput.getIdConta());
        chavePix.setTipoChave(chavePixInput.getTipoChave());
        chavePix.setValorChave(chavePixInput.getValorChave());
        chavePix.setDataCadastro(LocalDateTime.now());
        return chavePix;
    }

    public static ChavePixOutput converter(ChavePix chavePix) {
        ChavePixOutput chavePixOutput = new ChavePixOutput();
        chavePixOutput.setIdChave(chavePix.getIdChave());
        chavePixOutput.setIdConta(chavePix.getConta().getId());
        chavePixOutput.setTipoChave(chavePix.getTipoChave());
        chavePixOutput.setValorChave(chavePix.getValorChave());
        chavePixOutput.setDataCadastro(chavePix.getDataCadastro());
        return chavePixOutput;
    }
}
