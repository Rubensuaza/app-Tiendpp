package co.edu.tiendpp.administrador.creditos.menu;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.adapter.CreditoActivoAdapter;

public class CreditosActivosActivity extends AppCompatActivity {

    @BindView(R.id.lstViewCreditosActivos)
    ListView creditosActivos;
    private CreditoActivoAdapter creditoActivoAdapter;

    String[] credito1={"12546","Diego Suaza","6152619","Carrera 60A # 52-33","rubesuaza1983@gmail.com","320.000$","31/03/2021"};
    String[] credito2={"15646","Yohana Bedoya","6151876","Carrera 62A # 54-55","tobiasbedoya2002@gmail.com","50.000$","21/02/2021"};
    private List<String[]> creditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos_activos);
        ButterKnife.bind(this);
        creditos=new ArrayList<>();
        creditos.add(credito1);
        creditos.add(credito2);

        loadInformation();
    }

    private void loadInformation(){
        creditoActivoAdapter=new CreditoActivoAdapter(this,creditos);
        creditosActivos.setAdapter(creditoActivoAdapter);
    }
}