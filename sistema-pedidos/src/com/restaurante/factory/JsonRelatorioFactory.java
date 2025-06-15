package com.restaurante.factory;

import com.restaurante.relatorio.Relatorio;
import com.restaurante.relatorio.JsonRelatorio;

public class JsonRelatorioFactory extends RelatorioFactory {

    @Override
    public Relatorio criarRelatorio() {
        return new JsonRelatorio();
    }
}