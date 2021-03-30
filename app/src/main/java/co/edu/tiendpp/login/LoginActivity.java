package co.edu.tiendpp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.AdministradorActivity;
import co.edu.tiendpp.administrador.MantenimientoActivity;
import co.edu.tiendpp.util.ActionBarUtil;

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
        ActionBarUtil.getInstance(this, true).setToolBar("Login");


    }

    public void inToMenu(View view){
        String rol=spinner.getSelectedItem().toString();
        if(rol==roles[0]) {
            Intent intent = new Intent(LoginActivity.this, AdministradorActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(LoginActivity.this, MantenimientoActivity.class);
            startActivity(intent);
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}