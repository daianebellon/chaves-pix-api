package com.daiane.pix.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mensagens {

    public static final String MENSAGEM_TIPO_DE_PESSOA_INVALIDA = "O tipo de pessoa é obrigatório! Por favor informe um tipo válido!" ;
    public static final String MENSAGEM_DOCUMENTO_DO_TITULAR_INVALIDO = "Por favor, insira um documento válido!";
    public static final String MENSAGEM_NUMERO_DA_CONTA_INVALIDO = "Por favor, insira um numero de conta válido!";
    public static final String MENSAGEM_NUMERO_DA_AGENCIA_INVALIDO = "Por favor, insira um numero de agencia válido!";

    public static final String MENSAGEM_CONTA_INVALIDA = "Conta inválida!";

    public static final String MENSAGEM_ID_OBRIGATORIO_E_DEVE_SER_VALIDO = "Id não poder ser nulo e deve ser válido!";
    public static final String MENSAGEM_EXCLUSAO = "Excluído com sucesso!!";
    public static final String MENSAGEM_NUMERO_DA_CONTA_DEVE_SER_IGUAL_A_20 = "O numero da conta deve estar entre 0 e 20 digitos!";
    public static final String MENSAGEM_NUMERO_DA_AGENCIA_DEVE_SER_IGUAL_A_4 = "O numero da agencia deve possuir apenas 4 digitos!";

    public static final String MENSAGEM_TIPO_DE_CHAVE_INVALIDA = "Tipo de chave inválida! Por favor, verifique-a!";
    public static final String MENSAGEM_VALOR_CHAVE_INVALIDA = "Tipo de chave inválida! Por favor, verifique-a!";
}
