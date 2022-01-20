package com.daiane.pix.domain.chavepix;

import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChavePixOutput {

    private Integer idChave;
    private Integer idConta;
    private String valorChave;
    private TipoChave tipoChave;
    private LocalDateTime dataCadastro;
}
