package com.daiane.pix.gateway.database.entity.conta;

import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.jpa.TipoPessoaJpaConverter;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "contas")
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer id;

    @Column(name = "nr_conta")
    @NotNull(message = "Numero da conta não pode ser nulo")
    @Positive(message = "O numero da conta deve ser positivo!")
    private BigInteger numeroConta;

    @Column(name = "nr_agencia")
    @NotNull(message = "Numero da agencia não pode ser nulo")
    @Positive(message = "O numero da agencia deve ser positivo!")
    private Integer numeroAgencia;

    @Column(name = "documento_titular", length = 14)
    @NotEmpty(message = "Documento do titular não pode ser nulo ou vazio")
    private String documentoTitular;

    @Convert(converter = TipoPessoaJpaConverter.class)
    @Column(name = "tp_pessoa", columnDefinition = "char")
    @NotNull(message = "Tipo de pessoa não pode ser nulo")
    private TipoPessoa tipoPessoa;

    @OneToMany(mappedBy = "conta")
    private List<ChavePix> chavePixList;

}
