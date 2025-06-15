package com.restaurante.tema.dark;

import com.restaurante.tema.Cor;

public class DarkCor implements Cor {
    
    @Override
    public String getCorPrimaria() {
        return "#28a745";
    }
    
    @Override
    public String getCorSecundaria() {
        return "#6c757d";
    }
    
    @Override
    public String getCorFundo() {
        return "#343a40";
    }
    
    @Override
    public String getCorTexto() {
        return "#ffffff";
    }
}