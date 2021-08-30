package com.daiane.pix.domain.chavepix;

import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import lombok.Data;

@Data
public class ChavePixInput {

    private Integer idConta;
    private String valorChave;
    private TipoChave tipoChave;

}
