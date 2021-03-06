package com.daiane.pix.domain.conta;

import com.daiane.pix.gateway.database.entity.conta.TipoPessoa;
import lombok.Data;

import java.math.BigInteger;

@Data
public class ContaOutput {

    private Integer id;
    private BigInteger numeroConta;
    private Integer numeroAgencia;
    private String documentoTitular;
    private TipoPessoa tipoPessoa;

}
