package com.restaurante.abstractfactory;

import com.restaurante.tema.Botao;
import com.restaurante.tema.Cor;
import com.restaurante.tema.Icone;
import com.restaurante.tema.light.LightBotao;
import com.restaurante.tema.light.LightCor;
import com.restaurante.tema.light.LightIcone;

public class LightTemaFactory extends TemaFactory {
    
    @Override
    public Botao criarBotao() {
        return new LightBotao();
    }
    
    @Override
    public Cor criarCor() {
        return new LightCor();
    }
    
    @Override
    public Icone criarIcone() {
        return new LightIcone();
    }
    
    @Override
    public String getNomeTema() {
        return "Light Theme";
    }
}