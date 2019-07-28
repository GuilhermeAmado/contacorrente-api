package com.db1.contacorrente.infra;

import org.junit.Test;
import org.junit.Assert;

public class VerificadoraTest {

    @Test
    public void deveRetornarExceptionQuandoValorNull() {
        String mensagem = null;
        try {
            Verificadora.verificaStringValida(null, "Valor não pode ser nulo");
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }
        Assert.assertEquals("Valor não pode ser nulo", mensagem);
    }

    @Test
    public void deveRetornarExceptionQuandoValorVazio() {
        String mensagem = null;
        try {
            Verificadora.verificaStringValida("   ", "Valor não pode ser vazio");
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }
        Assert.assertEquals("Valor não pode ser vazio", mensagem);
    }

    @Test
    public void naoDeveRetornarExceptionQuandoValorValido() {
        String mensagem = null;
        try {
            Verificadora.verificaStringValida("DB1 Start", "Valor não pode ser vazio");
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }
        Assert.assertNull(mensagem);
    }

}