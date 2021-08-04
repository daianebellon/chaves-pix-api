package com.daiane.pix.gateway.database.entity.codigovalidacao;

import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "codigo_validacao")
@Data
public class CodigoValidacao {

    @ManyToOne
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    @Enumerated(EnumType.STRING)
    @Column( name = "tipo_chave", length = 2, nullable = false)
    private TipoChave tipoChave;

    @Column(name = "valor_chave", length = 77, nullable = false)
    private String valorChave;

    @Column(name = "codigo_otp", nullable = false)
    private int codigoOtp ;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "tp_status", nullable = false)
    private TipoStatus tipoStatus;

}
