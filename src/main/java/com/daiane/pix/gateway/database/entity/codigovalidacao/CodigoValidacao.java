package com.daiane.pix.gateway.database.entity.codigovalidacao;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "codigo_validacao")
@Data
public class CodigoValidacao {

    @EmbeddedId
    private CodigoValidacaoId codigoValidacaoId;

    @Column(name = "codigo_otp")
    @NotNull(message = "Codigo não pode ser null")
    @Positive(message = "Codigo deve conter apenas valores inteiros e positivos")
    private Integer codigoOtp ;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_status", nullable = false)
    private TipoStatus tipoStatus = TipoStatus.NAO_UTILIZADO;

}
