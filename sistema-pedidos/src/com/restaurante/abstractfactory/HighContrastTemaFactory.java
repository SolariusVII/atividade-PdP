package com.restaurante.abstractfactory;

import com.restaurante.tema.Botao;
import com.restaurante.tema.Cor;
import com.restaurante.tema.Icone;
import com.restaurante.tema.highcontrast.HighContrastBotao;
import com.restaurante.tema.highcontrast.HighContrastCor;
import com.restaurante.tema.highcontrast.HighContrastIcone;

public class HighContrastTemaFactory extends TemaFactory {
    
    @Override
    public Botao criarBotao() {
        return new HighContrastBotao();
    }
    
    @Override
    public Cor criarCor() {
        return new HighContrastCor();
    }
    
    @Override
    public Icone criarIcone() {
        return new HighContrastIcone();
    }
    
    @Override
    public String getNomeTema() {
        return "High Contrast Theme";
    }
}