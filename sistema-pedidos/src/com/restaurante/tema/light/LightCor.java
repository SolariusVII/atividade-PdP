package com.restaurante.tema.light;

import com.restaurante.tema.Cor;

public class LightCor implements Cor {
    
    @Override
    public String getCorPrimaria() {
        return "#007bff";
    }
    
    @Override
    public String getCorSecundaria() {
        return "#6c757d";
    }
    
    @Override
    public String getCorFundo() {
        return "#ffffff";
    }
    
    @Override
    public String getCorTexto() {
        return "#212529";
    }
}