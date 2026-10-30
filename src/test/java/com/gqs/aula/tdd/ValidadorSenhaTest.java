package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidadorSenhaTest {

    @Test
    void deveReprovarSenhaComMenosDe8Caracteres() {
        ValidadorSenha validador = new ValidadorSenha();
        ResultadoValidacao r = validador.validar("Ab1!");
        assertFalse(r.isValido());
        assertTrue(r.getErros().contains("A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    void deveAprovarSenhaValida() {
        ValidadorSenha validador = new ValidadorSenha();
        ResultadoValidacao r = validador.validar("Abcde12!");
        assertTrue(r.isValido());
        assertTrue(r.getErros().isEmpty());
    }

    @Test
    void deveReprovarSenhaComMenosDe2Digitos() {
        ValidadorSenha validador = new ValidadorSenha();
        ResultadoValidacao r = validador.validar("Abcdefg1!");
        assertFalse(r.isValido());
        assertTrue(r.getErros().contains("A senha deve conter pelo menos 2 dígitos"));
    }

    @Test
    void deveReprovarSenhaSemLetraMaiuscula() {
        ValidadorSenha validador = new ValidadorSenha();
        ResultadoValidacao r = validador.validar("abcde12!");
        assertFalse(r.isValido());
        assertTrue(r.getErros().contains("A senha deve conter pelo menos uma letra maiuscula"));
    }

    @Test
    void deveReprovarSenhaSemCaractereEspecial() {
        ValidadorSenha validador = new ValidadorSenha();
        ResultadoValidacao r = validador.validar("Abcdef12");
        assertFalse(r.isValido());
        assertTrue(r.getErros().contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    void deveRetornarTodosOsErrosParaMypass() {
        ValidadorSenha validador = new ValidadorSenha();
        ResultadoValidacao r = validador.validar("mypass");
        assertFalse(r.isValido());
        assertEquals(4, r.getErros().size());
        assertTrue(r.getErros().contains("A senha deve ter pelo menos 8 caracteres"));
        assertTrue(r.getErros().contains("A senha deve conter pelo menos 2 dígitos"));
        assertTrue(r.getErros().contains("A senha deve conter pelo menos uma letra maiuscula"));
        assertTrue(r.getErros().contains("A senha deve conter pelo menos um caractere especial"));
    }
}
