package co.edu.tiendpp.administrador.creditos.menu;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;

public class AbonosActivity extends AppCompatActivity {

    @BindView(R.id.txtNumeroCreditoAprobado)
    TextView idCredito;
    @BindView(R.id.txtNombreDeudorAprobado)
    TextView nombre;
    @BindView(R.id.txtTelefonoAprobado)
    TextView telefono;
    @BindView(R.id.txtCorreoAprobado)
    TextView correo;
    @BindView(R.id.txtDireccionAprobado)
    TextView direccion;
    @BindView(R.id.txtSaldoCreditoAprobado)
    TextView valorDeuda;
    @BindView(R.id.txtFechaUltimoPagoAprobado)
    TextView fechaPago;


    private String[] credito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abonos);
        ButterKnife.bind(this);
        credito=getIntent().getStringArrayExtra("creditos");
        idCredito.setText(credito[0]);
        nombre.setText(credito[1]);
        telefono.setText(credito[2]);
        correo.setText(credito[4]);
        direccion.setText(credito[3]);
        valorDeuda.setText(credito[5]);
        fechaPago.setText(credito[6]);

    }
}