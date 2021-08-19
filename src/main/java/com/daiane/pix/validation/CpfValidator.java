package com.daiane.pix.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.InputMismatchException;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CpfValidator {

    public static boolean validar(String cpf) {
        Objects.requireNonNull(Mensagens.MENSAGEM_CPF_INVALIDO);

        if (validarCpfInformado(cpf)) {return false;}

        try {
            char digitoVerificador10 = validarPrimeiroDigitoVerificador(cpf);
            char digitoVerificador11 = validarSegundoDigitoVerificador(cpf);
            return validarDigitosInformados(cpf, digitoVerificador10, digitoVerificador11);
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    private static boolean validarDigitosInformados(String cpf, char dig10, char dig11) {
        return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
    }

    private static char validarSegundoDigitoVerificador(String cpf) {
        int soma = 0;
        int peso = 11;
        int i;
        int num;

        for (i = 0; i < 10; i++) {
            num = ((int) cpf.charAt(i)) - 48;
            soma = soma + (num * peso);
            peso = peso - 1;
        }

        return validarDigitos(soma);
    }

    private static char validarPrimeiroDigitoVerificador(String cpf) {
        int soma = 0;
        int peso = 10;
        int i;
        int num;

        for (i=0; i<9; i++) {
            num = ((int) cpf.charAt(i)) - 48;
            soma = soma + (num * peso);
            peso = peso - 1;
        }

        return validarDigitos(soma);
    }

    private static char validarDigitos(int soma) {
        int resto = 11 - (soma % 11);
        char dig;

        if ((resto == 10) || (resto == 11)) {
            dig = '0';
        } else {
            dig = (char)(resto + 48);
        }
        return dig;
    }

    private static boolean validarCpfInformado(String cpf) {
        return cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11);
    }
}

