package com.db1.contacorrente;

import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteTest {

    @Test
    public void deveRetornarErroQuandoInformadoAgenciaInvalida() {
        String mensagem = null;

        try {
            ContaCorrente contaCorrente = new ContaCorrente(null, "00009876", "Guilherme Amado");
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }

        Assert.assertNotNull(mensagem);
        Assert.assertEquals("Deve ser informada uma agência válida", mensagem);
    }

    @Test
    public void deveRetornarErroQuandoInformadoNumeroInvalido() {
        String mensagem = null;

        try {
            ContaCorrente contaCorrente = new ContaCorrente("0465", null, "Guilherme Amado");
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }

        Assert.assertNotNull(mensagem);
        Assert.assertEquals("Deve ser informado um número de conta válido", mensagem);
    }

    @Test
    public void deveRetornarErroQuandoInformadoClienteInvalido() {
        String mensagem = null;

        try {
            ContaCorrente contaCorrente = new ContaCorrente("0465", "0135293", null);
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }

        Assert.assertNotNull(mensagem);
        Assert.assertEquals("Deve ser informado um cliente válido", mensagem);
    }

    @Test
    public void deveCriarContaCorrenteComValoresValidos() {
        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Guilherme Amado");

        Assert.assertEquals("0465", contaCorrente.getAgencia());
        Assert.assertEquals("02487532", contaCorrente.getNumero());
        Assert.assertEquals("Guilherme Amado", contaCorrente.getCliente());
        Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
        Assert.assertEquals(0, contaCorrente.getHistorico().size());
    }

    @Test
    public void deveRetornarErroQuandoValorDepositadoInvalido() {
        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Guilherme Amado");
        String mensagem = null;

        try {
            contaCorrente.depositar(-0.01);
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
        Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
        Assert.assertEquals(0, contaCorrente.getHistorico().size());
    }

    @Test
    public void deveRetornarErroQuandoValorDepositadoForZero() {
        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Guilherme Amado");
        String mensagem = null;

        try {
            contaCorrente.depositar(0.0);
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
        Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
        Assert.assertEquals(0, contaCorrente.getHistorico().size());
    }

    @Test
    public void deveRetornarErroQuandoValorDepositadoForNull() {
        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Guilherme Amado");
        String mensagem = null;

        try {
            contaCorrente.depositar(null);
        } catch (RuntimeException e) {
            mensagem = e.getMessage();
        }

        Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
        Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
        Assert.assertEquals(0, contaCorrente.getHistorico().size());
    }

    @Test
    public void deveDepositarValor() {
        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Guilherme Amado");
        contaCorrente.depositar(100.0);

        Assert.assertEquals(100.0, contaCorrente.getSaldo(), 0.001);
        Assert.assertEquals("Depositado: R$ 100.0", contaCorrente.getHistorico().get(0));
    }

}