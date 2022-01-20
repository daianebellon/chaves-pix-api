package com.daiane.pix.domain.chavepix;

import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ChavePixInput {

    @NotNull(message = "Numero do Id da Conta não pode ser nulo")
    @Positive(message = "O numero da conta deve ser positivo!")
    private Integer idConta;

    @NotBlank(message = "Valor da chave não pode ser nulo ou vazio")
    private String valorChave;

    @NotNull(message = "Tipo da chave não pode ser nulo")
    private TipoChave tipoChave;

    private Integer codigoValidacao;

}
