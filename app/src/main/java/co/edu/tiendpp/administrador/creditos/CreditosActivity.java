package co.edu.tiendpp.administrador.creditos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.creditos.menu.CreditosActivosActivity;
import co.edu.tiendpp.administrador.creditos.menu.SolicitudesCredito;
import co.edu.tiendpp.util.ActionBarUtil;

public class CreditosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
        ActionBarUtil.getInstance(this, true).setToolBar("Administrador", "Menu Créditos");
    }
    public void goToSolicitudesCredito(View view){
        Intent intent=new Intent(CreditosActivity.this, SolicitudesCredito.class);
        startActivity(intent);
    }

    public void goToCreditosActivos(View view) {
        Intent intent=new Intent(CreditosActivity.this, CreditosActivosActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}