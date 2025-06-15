package com.restaurante.tema.light;

import com.restaurante.tema.Icone;

public class LightIcone implements Icone {
    
    @Override
    public String getIconeHome() {
        return "bx bx-home";
    }
    
    @Override
    public String getIconeUsuario() {
        return "bx bx-user";
    }
    
    @Override
    public String getIconeConfig() {
        return "bx bx-cog";
    }
    
    @Override
    public String getIconeRelatorio() {
        return "bx bx-file";
    }
}