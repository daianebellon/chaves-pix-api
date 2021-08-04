package com.daiane.pix.gateway.database.entity.chavepix;

import com.daiane.pix.gateway.database.entity.conta.Conta;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "chave_pix")
@Data
public class ChavePix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chave")
    private Long idChave;

    @ManyToOne
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    @Column(name = "valor_chave", length = 77, nullable = false)
    private String valorChave;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_chave", nullable = false)
    private TipoChave tipoChave;

    @Column(name = "dt_cadastro", nullable = false)
    private LocalDate dataCadastro = LocalDate.now();

}
