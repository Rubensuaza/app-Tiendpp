package co.edu.tiendpp.administrador;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.tiendpp.R;
import co.edu.tiendpp.util.ActionBarUtil;

public class MantenimientoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);
        ActionBarUtil.getInstance(this, true).setToolBar("Modulo en mantenimiento");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}