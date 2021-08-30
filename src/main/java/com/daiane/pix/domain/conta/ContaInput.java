package com.daiane.pix.domain.conta;

import com.daiane.pix.gateway.database.entity.conta.TipoPessoa;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigInteger;

@Data
public class ContaInput {

    @NotNull(message = "Numero da conta não pode ser nulo")
    @Positive(message = "O numero da conta deve ser positivo!")
    private BigInteger numeroConta;

    @NotNull(message = "Numero da agencia não pode ser nulo")
    @Positive(message = "O numero da agencia deve ser positivo!")
    private Integer numeroAgencia;

    @NotEmpty(message = "Documento do titular não pode ser nulo ou vazio")
    private String documentoTitular;

    @NotNull(message = "Tipo de pessoa não pode ser nulo")
    private TipoPessoa tipoPessoa;

}
