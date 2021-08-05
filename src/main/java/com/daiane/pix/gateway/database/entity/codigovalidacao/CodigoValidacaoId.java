package com.daiane.pix.gateway.database.entity.codigovalidacao;

import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class CodigoValidacaoId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    @Enumerated(EnumType.STRING)
    @Column( name = "tipo_chave", length = 2, nullable = false)
    private TipoChave tipoChave;

    @Column(name = "valor_chave", length = 77, nullable = false)
    private String valorChave;
}
