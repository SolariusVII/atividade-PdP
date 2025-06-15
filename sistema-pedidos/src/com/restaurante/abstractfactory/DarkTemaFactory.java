package com.restaurante.abstractfactory;

import com.restaurante.tema.Botao;
import com.restaurante.tema.Cor;
import com.restaurante.tema.Icone;
import com.restaurante.tema.dark.DarkBotao;
import com.restaurante.tema.dark.DarkCor;
import com.restaurante.tema.dark.DarkIcone;

public class DarkTemaFactory extends TemaFactory {
    
    @Override
    public Botao criarBotao() {
        return new DarkBotao();
    }
    
    @Override
    public Cor criarCor() {
        return new DarkCor();
    }
    
    @Override
    public Icone criarIcone() {
        return new DarkIcone();
    }
    
    @Override
    public String getNomeTema() {
        return "Dark Theme";
    }
}