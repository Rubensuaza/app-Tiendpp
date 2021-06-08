package co.edu.tiendpp.model;


import java.util.List;

import lombok.Data;

@Data
public class UsuarioTiendapp {private Integer idUsuarioTienda;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private String numeroTelefono;
    private String correo;
    private List<String> roles;

}
