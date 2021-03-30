package co.edu.tiendpp.administrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.creditos.CreditosActivity;
import co.edu.tiendpp.util.ActionBarUtil;

public class AdministradorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        ActionBarUtil.getInstance(this, true).setToolBar("Administrador");
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