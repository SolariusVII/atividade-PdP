package com.restaurante.relatorio;

import com.restaurante.model.Pedido;
import java.util.List;

public class PdfRelatorio implements Relatorio {

    @Override
    public String gerar(List<Pedido> pedidos) {
        StringBuilder pdf = new StringBuilder();
        pdf.append("=== RELATÓRIO PDF ===\n");
        pdf.append("Formato: PDF\n");
        pdf.append("Total de pedidos: ").append(pedidos.size()).append("\n\n");

        for (Pedido pedido : pedidos) {
            pdf.append("ID: ").append(pedido.getId()).append("\n");
            pdf.append("Cliente: ").append(pedido.getCliente()).append("\n");
            pdf.append("Item: ").append(pedido.getItem()).append("\n");
            pdf.append("Valor: R$ ").append(String.format("%.2f", pedido.getValor())).append("\n");
            pdf.append("Status: ").append(pedido.getStatus()).append("\n");
            pdf.append("-------------------\n");
        }

        return pdf.toString();
    }

    @Override
    public String getTipo() {
        return "PDF";
    }
}