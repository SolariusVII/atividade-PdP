package com.restaurante.relatorio;

import com.restaurante.model.Pedido;
import java.util.List;

public interface Relatorio {
    String gerar(List<Pedido> pedidos);

    String getTipo();
}