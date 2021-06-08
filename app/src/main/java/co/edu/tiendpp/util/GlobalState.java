package co.edu.tiendpp.util;

import android.app.Application;

import co.edu.tiendpp.model.UsuarioTiendapp;
import lombok.Data;

@Data
public class GlobalState extends Application {
    private String accessToken;
    private UsuarioTiendapp usuarioTiendapp;
}
