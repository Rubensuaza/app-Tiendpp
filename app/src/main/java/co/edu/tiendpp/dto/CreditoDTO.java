package co.edu.tiendpp.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditoDTO implements Serializable {
    private int idCredito;
    private String nombreUsuario;
    private String apellidoUsuaro;
    private String telefono;
    private String correo;
    private String direccion;
    private Date fechaSolcitud;
    private double cupo;
}
