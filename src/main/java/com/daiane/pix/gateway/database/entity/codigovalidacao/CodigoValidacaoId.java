package com.daiane.pix.gateway.database.entity.codigovalidacao;

import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.conta.Conta;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
public class CodigoValidacaoId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_conta")
    @NotNull(message = "Conta não pode ser nula!")
    private Conta conta;

    @Enumerated(EnumType.STRING)
    @Column( name = "tipo_chave", length = 2)
    @NotNull(message = "Tipo de chave não pode ser nula!")
    private TipoChave tipoChave;

    @Column(name = "valor_chave", length = 77)
    @NotNull(message = "Valor da chave não pode ser nula!")
    private String valorChave;
}
