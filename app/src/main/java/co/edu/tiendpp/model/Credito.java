package co.edu.tiendpp.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Credito {
    private int idCredito;
    private String nombreUsuario;
    private String apellidoUsuaro;
    private String telefono;
    private String correo;
    private String direccion;
    private Date fechaSolcitud;
    private double cupo;
    private char activo;

}
