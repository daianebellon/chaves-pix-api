package com.daiane.pix.gateway.database.entity.conta;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "contas")
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer id;

    @Column(name = "nr_conta", nullable = false)
    private BigInteger numeroConta;

    @Column(name = "nr_agencia", nullable = false)
    private Integer numeroAgencia;

    @Column(name = "documento_titular", nullable = false, length = 14)
    private String documentoTitular;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_pessoa", nullable = false, columnDefinition = "char")
    private TipoPessoa tipoPessoa;
}
