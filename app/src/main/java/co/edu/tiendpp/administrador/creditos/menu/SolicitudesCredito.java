package co.edu.tiendpp.administrador.creditos.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.adapter.SolicitudCreditoAdapter;

public class SolicitudesCredito extends AppCompatActivity {

    @BindView(R.id.lstViewSolicitudesCredito)
    ListView solicitudesCredito;
    private SolicitudCreditoAdapter solicitudCreditoAdapter;

    String[] solicitud1={"123","Ruben Suaza","21/03/2021"};
    String[] solicitud2={"124","Tobias Bedoya","18/03/2021"};
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
    }

    private void loadInformation(){
        solicitudCreditoAdapter=new SolicitudCreditoAdapter(this,solicitudes);
        solicitudesCredito.setAdapter(solicitudCreditoAdapter);
    }

}