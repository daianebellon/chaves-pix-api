package com.daiane.pix.gateway.database.entity.conta;

import lombok.Getter;

public enum TipoPessoa {
    PHYSICAL_PERSON("F"),
    LEGAL_PERSON("J");

    @Getter
    private final String label;

    TipoPessoa(String label) {
        this.label = label;
    }

    public static TipoPessoa valueOfLabel(String label) {
        for (TipoPessoa e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }

}
