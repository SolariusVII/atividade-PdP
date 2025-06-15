package com.restaurante.tema.light;

import com.restaurante.tema.Botao;

public class LightBotao implements Botao {
    
    @Override
    public String getEstilo() {
        return "background-color: #007bff; color: white; border: 1px solid #007bff;";
    }
    
    @Override
    public String getClasse() {
        return "btn btn-primary btn-light-theme";
    }
    
    @Override
    public String getTexto() {
        return "Botão Light Theme";
    }
}