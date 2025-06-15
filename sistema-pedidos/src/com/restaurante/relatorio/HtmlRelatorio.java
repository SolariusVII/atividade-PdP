package com.restaurante.relatorio;

import com.restaurante.model.Pedido;
import java.util.List;

public class HtmlRelatorio implements Relatorio {

    @Override
    public String gerar(List<Pedido> pedidos) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n<head>\n");
        html.append("<title>Relatório de Pedidos</title>\n");
        html.append("<style>\n");
        html.append("body { font-family: Arial, sans-serif; margin: 20px; }\n");
        html.append("table { border-collapse: collapse; width: 100%; }\n");
        html.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }\n");
        html.append("th { background-color: #f2f2f2; }\n");
        html.append("</style>\n</head>\n<body>\n");

        html.append("<h1>Relatório de Pedidos</h1>\n");
        html.append("<p>Formato: HTML | Total: ").append(pedidos.size()).append(" pedidos</p>\n");

        html.append("<table>\n");
        html.append("<tr><th>ID</th><th>Cliente</th><th>Item</th><th>Valor</th><th>Status</th></tr>\n");

        for (Pedido pedido : pedidos) {
            html.append("<tr>");
            html.append("<td>").append(pedido.getId()).append("</td>");
            html.append("<td>").append(pedido.getCliente()).append("</td>");
            html.append("<td>").append(pedido.getItem()).append("</td>");
            html.append("<td>R$ ").append(String.format("%.2f", pedido.getValor())).append("</td>");
            html.append("<td>").append(pedido.getStatus()).append("</td>");
            html.append("</tr>\n");
        }

        html.append("</table>\n</body>\n</html>");

        return html.toString();
    }

    @Override
    public String getTipo() {
        return "HTML";
    }
}