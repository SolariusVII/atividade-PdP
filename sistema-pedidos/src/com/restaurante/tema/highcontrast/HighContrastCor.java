package com.restaurante.tema.highcontrast;

import com.restaurante.tema.Cor;

public class HighContrastCor implements Cor {
    
    @Override
    public String getCorPrimaria() {
        return "#000000";
    }
    
    @Override
    public String getCorSecundaria() {
        return "#ffffff";
    }
    
    @Override
    public String getCorFundo() {
        return "#000000";
    }
    
    @Override
    public String getCorTexto() {
        return "#ffffff";
    }
}