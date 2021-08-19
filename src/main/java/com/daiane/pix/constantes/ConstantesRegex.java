package com.daiane.pix.constantes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class  ConstantesRegex {

    public static final String EMAIL_EXPRESSAO =  "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    public static final String PHONE_EXPRESSAO = "^[+]?[0-9]{13}$";

}
