package co.edu.tiendpp.administrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.creditos.CreditosActivity;

public class AdministradorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
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
}