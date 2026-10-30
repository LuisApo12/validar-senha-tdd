package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    static final int TAMANHO_MINIMO = 8;
    static final int DIGITOS_MINIMOS = 2;

    static final String ERRO_TAMANHO = "A senha deve ter pelo menos 8 caracteres";
    static final String ERRO_DIGITOS = "A senha deve conter pelo menos 2 dígitos";
    static final String ERRO_MAIUSCULA = "A senha deve conter pelo menos uma letra maiuscula";
    static final String ERRO_ESPECIAL = "A senha deve conter pelo menos um caractere especial";

    public ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();

        if (senha.length() < TAMANHO_MINIMO) {
            erros.add(ERRO_TAMANHO);
        }
        if (senha.chars().filter(Character::isDigit).count() < DIGITOS_MINIMOS) {
            erros.add(ERRO_DIGITOS);
        }
        if (senha.chars().noneMatch(Character::isUpperCase)) {
            erros.add(ERRO_MAIUSCULA);
        }
        if (senha.chars().allMatch(Character::isLetterOrDigit)) {
            erros.add(ERRO_ESPECIAL);
        }

        return new ResultadoValidacao(erros);
    }
}
