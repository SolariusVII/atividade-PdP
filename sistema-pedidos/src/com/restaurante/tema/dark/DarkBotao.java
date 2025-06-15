package com.restaurante.tema.dark;

import com.restaurante.tema.Botao;

public class DarkBotao implements Botao {
    
    @Override
    public String getEstilo() {
        return "background-color: #28a745; color: white; border: 1px solid #28a745;";
    }
    
    @Override
    public String getClasse() {
        return "btn btn-success btn-dark-theme";
    }
    
    @Override
    public String getTexto() {
        return "Botão Dark Theme";
    }
}