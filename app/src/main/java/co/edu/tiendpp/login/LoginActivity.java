package co.edu.tiendpp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.AdministradorActivity;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.spnRol)
    Spinner spinner;

    String[] roles ={"Administrador","Cliente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, roles);
        spinner.setAdapter(arrayAdapter);

    }

    public void inToMenu(View view){
        Intent intent=new Intent(LoginActivity.this, AdministradorActivity.class);
        startActivity(intent);
    }


}