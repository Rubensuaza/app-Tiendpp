package co.edu.tiendpp.administrador.creditos.menu;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.adapter.SolicitudCreditoAdapter;
import co.edu.tiendpp.util.ActionBarUtil;

public class SolicitudesCredito extends AppCompatActivity {

    @BindView(R.id.lstViewSolicitudesCredito)
    ListView solicitudesCredito;
    private SolicitudCreditoAdapter solicitudCreditoAdapter;

    String[] solicitud1={"123","Ruben Suaza","21/03/2021","Carrera 60A # 52-33","rubesuaza1983@gmail.com","Rioengro","Antioquia","3158703013"};
    String[] solicitud2={"124","Tobias Bedoya","18/03/2021","Carrera 62A # 54-55","tobiasbedoya2002@gmail.com","Rioengro","Antioquia","3218617925"};
    private List<String[]> solicitudes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes_credito);
        ButterKnife.bind(this);
        solicitudes=new ArrayList<>();
        solicitudes.add(solicitud1);
        solicitudes.add(solicitud2);

        loadInformation();
        ActionBarUtil.getInstance(this, true).setToolBar("Menu Créditos", "Solicitudes de crédito");
    }

    private void loadInformation(){
        solicitudCreditoAdapter=new SolicitudCreditoAdapter(this,solicitudes);
        solicitudesCredito.setAdapter(solicitudCreditoAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}