package com.daiane.pix.gateway.database.entity.conta;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contas")
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;

    @Column(name = "nr_conta", nullable = false)
    private Long numeroConta;

    @Column(name = "nr_agencia", nullable = false)
    private Integer numeroAgencia;

    @Column(name = "documento_titular", nullable = false, length = 14)
    private String documentoTitular;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_pessoa", nullable = false)
    private TipoPessoa tipoPessoa;
}
