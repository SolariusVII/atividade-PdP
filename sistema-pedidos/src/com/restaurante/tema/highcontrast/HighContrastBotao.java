package com.restaurante.tema.highcontrast;

import com.restaurante.tema.Botao;

public class HighContrastBotao implements Botao {
    
    @Override
    public String getEstilo() {
        return "background-color: #000000; color: #ffffff; border: 3px solid #ffffff;";
    }
    
    @Override
    public String getClasse() {
        return "btn btn-outline-light btn-highcontrast-theme";
    }
    
    @Override
    public String getTexto() {
        return "Botão High Contrast";
    }
}