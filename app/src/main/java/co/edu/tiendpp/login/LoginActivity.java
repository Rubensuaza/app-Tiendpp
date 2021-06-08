package co.edu.tiendpp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.AdministradorActivity;
import co.edu.tiendpp.administrador.MantenimientoActivity;
import co.edu.tiendpp.service.login.LoginServiceImpl;
import co.edu.tiendpp.util.ActionBarUtil;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.spnRol)
    Spinner spinner;

    @BindView(R.id.etxtUserName)
    EditText username;

    @BindView(R.id.etxtPassword)
    EditText password;

    String[] roles ={"Administrador","Cliente"};

    LoginServiceImpl loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, roles);
        spinner.setAdapter(arrayAdapter);
        ActionBarUtil.getInstance(this, true).setToolBar("Login");
        loginService=new LoginServiceImpl(this);


    }

    public void inToMenu(View view){
        loginService.login(username.getText().toString(),password.getText().toString(),spinner.getSelectedItem().toString());



    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void redirectAdmin(){
            Intent intent = new Intent(LoginActivity.this, AdministradorActivity.class);
            startActivity(intent);

    }

    private void redirectCliente(){
        Intent intent = new Intent(LoginActivity.this, MantenimientoActivity.class);
        startActivity(intent);
    }

    public void inUser(String rol){
        if(rol.equals("Administrador")){
            redirectAdmin();
        }else{
            redirectCliente();
        }
    }



}