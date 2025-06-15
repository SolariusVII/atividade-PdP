package com.restaurante.tema.highcontrast;

import com.restaurante.tema.Icone;

public class HighContrastIcone implements Icone {
    
    @Override
    public String getIconeHome() {
        return "bx bx-home-alt";
    }
    
    @Override
    public String getIconeUsuario() {
        return "bx bx-user-circle";
    }
    
    @Override
    public String getIconeConfig() {
        return "bx bx-wrench";
    }
    
    @Override
    public String getIconeRelatorio() {
        return "bx bx-file-blank";
    }
}