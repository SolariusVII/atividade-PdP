package com.restaurante.factory;

import com.restaurante.relatorio.Relatorio;
import com.restaurante.relatorio.HtmlRelatorio;

public class HtmlRelatorioFactory extends RelatorioFactory {

    @Override
    public Relatorio criarRelatorio() {
        return new HtmlRelatorio();
    }
}