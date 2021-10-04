package com.daiane.pix.gateway.database.entity.chavepix;

import com.daiane.pix.gateway.database.entity.conta.Conta;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "chave_pix")
@Data
public class ChavePix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chave")
    private Integer idChave;

    @ManyToOne
    @JoinColumn(name = "id_conta")
    @NotNull(message = "Conta não pode ser nula!")
    private Conta conta;

    @Column(name = "valor_chave", length = 77)
    @NotNull(message = "Valor da chave não pode ser nula!")
    private String valorChave;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_chave")
    @NotNull(message = "Tipo de chave não pode ser nulo!")
    private TipoChave tipoChave;

    @Column(name = "dt_cadastro")
    @NotNull(message = "Data de cadastro não pode ser nula")
    private LocalDateTime dataCadastro;

}
