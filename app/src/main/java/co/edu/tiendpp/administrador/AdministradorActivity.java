package co.edu.tiendpp.administrador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.creditos.CreditosActivity;
import co.edu.tiendpp.util.ActionBarUtil;
import co.edu.tiendpp.util.GlobalState;

public class AdministradorActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView usuario;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        ActionBarUtil.getInstance(this, true).setToolBar("Administrador");
        ButterKnife.bind(this);
        GlobalState globalState = (GlobalState) getApplicationContext();
        usuario.setText(globalState.getUsuarioTiendapp().getNombre()+" "+globalState.getUsuarioTiendapp().getApellido());


    }

    public void goPedidos(View view) {
        Intent intent=new Intent(AdministradorActivity.this,MantenimientoActivity.class);
        startActivity(intent);
    }

    public void goCredits(View view) {
        Intent intent=new Intent(AdministradorActivity.this, CreditosActivity.class);
        startActivity(intent);
    }

    public void goInventory(View view) {
        Intent intent=new Intent(AdministradorActivity.this,MantenimientoActivity.class);
        startActivity(intent);
    }

    public void goClients(View view) {
        Intent intent=new Intent(AdministradorActivity.this,MantenimientoActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }




}