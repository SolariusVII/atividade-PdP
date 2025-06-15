package com.restaurante.tema.dark;

import com.restaurante.tema.Icone;

public class DarkIcone implements Icone {
    
    @Override
    public String getIconeHome() {
        return "bx bxs-home";
    }
    
    @Override
    public String getIconeUsuario() {
        return "bx bxs-user";
    }
    
    @Override
    public String getIconeConfig() {
        return "bx bxs-cog";
    }
    
    @Override
    public String getIconeRelatorio() {
        return "bx bxs-file";
    }
}