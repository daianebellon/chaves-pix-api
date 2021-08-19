package com.daiane.pix.jpa;

import com.daiane.pix.gateway.database.entity.conta.TipoPessoa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TipoPessoaJpaConverter implements AttributeConverter<TipoPessoa, String> {

    @Override
    public String convertToDatabaseColumn(TipoPessoa tipoPessoa) {
        if (tipoPessoa == null) {
            return null;
        }
        return tipoPessoa.getLabel();
    }

    @Override
    public TipoPessoa convertToEntityAttribute(String string) {
        if (string == null) {
            return null;
        }
        return TipoPessoa.valueOfLabel(string);
    }
}
