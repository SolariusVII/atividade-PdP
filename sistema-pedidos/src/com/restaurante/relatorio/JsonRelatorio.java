package com.restaurante.relatorio;

import com.restaurante.model.Pedido;
import java.util.List;

public class JsonRelatorio implements Relatorio {

    @Override
    public String gerar(List<Pedido> pedidos) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"relatorio\": {\n");
        json.append("    \"tipo\": \"JSON\",\n");
        json.append("    \"total\": ").append(pedidos.size()).append(",\n");
        json.append("    \"pedidos\": [\n");

        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            json.append("      {\n");
            json.append("        \"id\": ").append(pedido.getId()).append(",\n");
            json.append("        \"cliente\": \"").append(pedido.getCliente()).append("\",\n");
            json.append("        \"item\": \"").append(pedido.getItem()).append("\",\n");
            json.append("        \"valor\": ").append(pedido.getValor()).append(",\n");
            json.append("        \"status\": \"").append(pedido.getStatus()).append("\"\n");
            json.append("      }");

            if (i < pedidos.size() - 1) {
                json.append(",");
            }
            json.append("\n");
        }

        json.append("    ]\n");
        json.append("  }\n");
        json.append("}");

        return json.toString();
    }

    @Override
    public String getTipo() {
        return "JSON";
    }
}