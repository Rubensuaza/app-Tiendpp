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
import co.edu.tiendpp.service.credito.CreditoServiceImpl;
import co.edu.tiendpp.util.ActionBarUtil;
import co.edu.tiendpp.util.GlobalState;

public class SolicitudesCredito extends AppCompatActivity {

    @BindView(R.id.lstViewSolicitudesCredito)
    ListView solicitudesCredito;
    int idAdmin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes_credito);
        ButterKnife.bind(this);
        ActionBarUtil.getInstance(this, true).setToolBar("Menu Créditos", "Solicitudes de crédito");
        GlobalState globalState = (GlobalState) getApplicationContext();
        idAdmin=globalState.getUsuarioTiendapp().getIdUsuarioTienda();
        loadInformation();

    }

    private void loadInformation(){
        CreditoServiceImpl creditoService=new CreditoServiceImpl(this);
        creditoService.getCreditoPendienteAprob(solicitudesCredito,idAdmin);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}