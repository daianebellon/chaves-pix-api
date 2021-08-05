package com.daiane.pix.gateway.database.entity.codigovalidacao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "codigo_validacao")
@Data
public class CodigoValidacao {

    @EmbeddedId
    private CodigoValidacaoId codigoValidacaoId;

    @Column(name = "codigo_otp", nullable = false)
    private Integer codigoOtp ;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_status", nullable = false)
    private TipoStatus tipoStatus;

}
