package com.daiane.pix.converter.conta;

import com.daiane.pix.domain.conta.ContaInput;
import com.daiane.pix.domain.conta.ContaOutput;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContaConverter {

    public static Conta converte(ContaInput contaInput) {
        var conta = new Conta();
        conta.setNumeroConta(contaInput.getNumeroConta());
        conta.setNumeroAgencia(contaInput.getNumeroAgencia());
        conta.setDocumentoTitular(contaInput.getDocumentoTitular());
        conta.setTipoPessoa(contaInput.getTipoPessoa());
        return conta;
    }

    public static ContaOutput converte(Conta conta) {
        var contaOutput = new ContaOutput();
        contaOutput.setId(conta.getId());
        contaOutput.setNumeroConta(conta.getNumeroConta());
        contaOutput.setNumeroAgencia(conta.getNumeroAgencia());
        contaOutput.setDocumentoTitular(conta.getDocumentoTitular());
        contaOutput.setTipoPessoa(conta.getTipoPessoa());
        return contaOutput;
    }
}
