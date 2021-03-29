package co.edu.tiendpp.administrador.creditos.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;

public class FormularioSolicitudActivity extends AppCompatActivity {

    @BindView(R.id.txtNumeroSolicitud)
    TextView idCredito;
    @BindView(R.id.txtNombreSolicitante)
    TextView nombre;
    @BindView(R.id.txtTelefono)
    TextView telefono;
    @BindView(R.id.txtCorreo)
    TextView correo;
    @BindView(R.id.txtDireccion)
    TextView direccion;
    @BindView(R.id.txtCiudad)
    TextView ciudad;
    @BindView(R.id.txtDepartamento)
    TextView departamento;
    @BindView(R.id.txtFechaSolicitud)
    TextView fechaSolicitud;

    private String[] solicitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_solicitud);
        ButterKnife.bind(this);
        solicitud=getIntent().getStringArrayExtra("solicitud");
        idCredito.setText(solicitud[0]);
        nombre.setText(solicitud[1]);
        telefono.setText(solicitud[7]);
        correo.setText(solicitud[4]);
        direccion.setText(solicitud[3]);
        ciudad.setText(solicitud[5]);
        departamento.setText(solicitud[6]);
        fechaSolicitud.setText(solicitud[2]);


    }

    public void aceptarCredito(View view) {
        Toast.makeText(getApplicationContext(),"Credito aprobado",Toast.LENGTH_LONG).show();
    }

    public void rechazarCredito(View view) {
        Toast.makeText(getApplicationContext(),"Credito rechazado",Toast.LENGTH_LONG).show();
    }
}