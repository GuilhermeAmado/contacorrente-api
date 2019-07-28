package com.db1.contacorrente;

import com.db1.contacorrente.infra.Verificadora;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

    private String agencia;
    private String numero;
    private String cliente;
    private Double saldo;
    private List<String> historico;

    public ContaCorrente(String agencia, String numero, String cliente) {
        Verificadora.verificaStringValida(agencia, "Deve ser informada uma agência válida");
        Verificadora.verificaStringValida(numero, "Deve ser informado um número de conta válido");
        Verificadora.verificaStringValida(cliente, "Deve ser informado um cliente válido");
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.historico = new ArrayList<String>();
    }

    public void depositar(Double valor) {
        Verificadora.valorMaiorQueZero(valor, "Valor a ser depositado deve ser maior que zero");
        this.saldo += valor;
        this.historico.add("Depositado: R$ " + valor);
    }

    public void sacar(Double valor) {
        Verificadora.valorMaiorQueZero(valor, "Valor a ser sacado deve ser maior que zero");
        Verificadora.valorMaiorQueZero((this.saldo - valor), "Valor a ser sacado é maior do que disponível em conta");
        this.saldo -= valor;
        this.historico.add("Sacado: R$ " + valor);
    }

    public String getAgencia() {
        return agencia;
    }

    public String getCliente() { return cliente; }

    public String getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<String> getHistorico() {
        return historico;
    }
}
