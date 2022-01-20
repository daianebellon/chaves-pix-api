package com.daiane.pix.constantes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constantes {

    public static final String EMAIL_EXPRESSAO =  "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    public static final String PHONE_EXPRESSAO = "^[+]?[0-9]{13}$";
    public static final int MULTIPLICADOR_PARA_CODIGO_COM_SEIS_DIGITOS = 999_999;

}
