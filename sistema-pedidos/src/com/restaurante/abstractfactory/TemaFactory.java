package com.restaurante.abstractfactory;

import com.restaurante.tema.Botao;
import com.restaurante.tema.Cor;
import com.restaurante.tema.Icone;

public abstract class TemaFactory {
    public abstract Botao criarBotao();

    public abstract Cor criarCor();

    public abstract Icone criarIcone();

    public abstract String getNomeTema();
}