package co.edu.tiendpp.administrador.creditos.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.dto.CreditoDTO;
import co.edu.tiendpp.util.ActionBarUtil;

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
    @BindView(R.id.txtFechaSolicitud)
    TextView fechaSolicitud;
    private CreditoDTO solicitud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_solicitud);
        ButterKnife.bind(this);
        solicitud= (CreditoDTO) getIntent().getSerializableExtra("solicitud");
        idCredito.setText(solicitud.getIdCredito());
        nombre.setText(solicitud.getNombreUsuario()+" "+solicitud.getApellidoUsuaro());
        telefono.setText(solicitud.getTelefono());
        correo.setText(solicitud.getCorreo());
        direccion.setText(solicitud.getDireccion());
        fechaSolicitud.setText(solicitud.getFechaSolcitud().toString());
        ActionBarUtil.getInstance(this, true).setToolBar("Solicitudes de crédito", "Datos del solicitante");


    }

    public void aceptarCredito(View view) {
        Toast.makeText(getApplicationContext(),"Credito aprobado",Toast.LENGTH_LONG).show();
    }

    public void rechazarCredito(View view) {
        Toast.makeText(getApplicationContext(),"Credito rechazado",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}