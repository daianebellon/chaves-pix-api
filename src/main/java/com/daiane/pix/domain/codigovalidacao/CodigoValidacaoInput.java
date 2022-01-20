package com.daiane.pix.domain.codigovalidacao;

import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import lombok.Data;

@Data
public class CodigoValidacaoInput {

    private Integer codigoValidacao;
    private Integer contaId;
    private TipoChave tipoChave;
    private String valorChave;

}
