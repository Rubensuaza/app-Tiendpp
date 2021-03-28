package co.edu.tiendpp.administrador.creditos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.creditos.menu.SolicitudesCredito;

public class CreditosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
    }
    public void goToSolicitudesCredito(View view){
        Intent intent=new Intent(CreditosActivity.this, SolicitudesCredito.class);
        startActivity(intent);
    }
}