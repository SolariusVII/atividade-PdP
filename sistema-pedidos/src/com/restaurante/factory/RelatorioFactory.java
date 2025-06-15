package com.restaurante.factory;

import com.restaurante.relatorio.Relatorio;

public abstract class RelatorioFactory {
    public abstract Relatorio criarRelatorio();

    public String gerarRelatorio(java.util.List<com.restaurante.model.Pedido> pedidos) {
        Relatorio relatorio = criarRelatorio();
        return relatorio.gerar(pedidos);
    }
}