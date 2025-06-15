package com.restaurante.factory;

import com.restaurante.relatorio.Relatorio;
import com.restaurante.relatorio.PdfRelatorio;

public class PdfRelatorioFactory extends RelatorioFactory {

    @Override
    public Relatorio criarRelatorio() {
        return new PdfRelatorio();
    }
}