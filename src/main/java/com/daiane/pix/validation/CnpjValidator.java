package com.daiane.pix.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.InputMismatchException;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CnpjValidator {

    public static boolean validar(String cnpj) {
        Objects.requireNonNull(cnpj, Mensagens.MENSAGEM_CNPJ_INVALIDO);

        if (validarSeCnpjEhFormadoPorSequenciaDeNumerosIguais(cnpj)) {
            return false;
        }

        try {
            char digitoVerificador10 = validarPrimeiroDigitoVerificador(cnpj);
            char digitoVerificador11 = validarSegundoDigitoVerificador(cnpj);
            return validarSeDigitosCalculadosSaoIguaisDigitosInformados(cnpj, digitoVerificador10, digitoVerificador11);
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    private static boolean validarSeDigitosCalculadosSaoIguaisDigitosInformados(String cnpj, char dig13, char dig14) {
        return dig13 == cnpj.charAt(12) && dig14 == cnpj.charAt(13);
    }

    private static char validarSegundoDigitoVerificador(String cnpj) {
        var soma = 0;
        var peso = 2;

        for (var i = 12; i >= 0; i--) {
            var num = ((int) cnpj.charAt(i)) - 48;
            soma = soma + (num * peso);
            peso++;

            if (peso == 10) {
                peso = 2;
            }
        }

        return validarDigitos(soma);
    }

    private static char validarDigitos(int soma) {
        var resto = soma % 11;
        char dig;

        if (resto == 0 || resto == 1) {
            dig = '0';
        } else {
            dig = (char) ((11 - resto) + 48);
        }
        return dig;
    }

    private static char validarPrimeiroDigitoVerificador(String cnpj) {
        var soma = 0;
        var peso = 2;

        for (var i = 11; i >= 0; i--) {
            var num = ((int) cnpj.charAt(i)) - 48;
            soma = soma + (num * peso);
            peso++;

            if (peso == 10) {
                peso = 2;
            }
        }
        return validarDigitos(soma);
    }

    private static boolean validarSeCnpjEhFormadoPorSequenciaDeNumerosIguais(String cnpj) {
        return cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
                (cnpj.length() != 14);
    }
}


