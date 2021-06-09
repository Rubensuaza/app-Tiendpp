package co.edu.tiendpp.service.credito;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import co.edu.tiendpp.adapter.SolicitudCreditoAdapter;
import co.edu.tiendpp.model.Credito;
import co.edu.tiendpp.util.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreditoServiceImpl extends RetrofitFactory {
    public CreditoServiceImpl(Context context) {
        super(context);
    }

    public void getCreditoPendienteAprob(ListView listViewCreditos, int idAdmin){
        Retrofit retrofit =getTokenInstance();
        CreditoClient client=retrofit.create(CreditoClient.class);
        Call<List<Credito>> response=client.findByidAdmiPendientes(idAdmin);
        response.enqueue(new Callback<List<Credito>>() {
            @Override
            public void onResponse(Call<List<Credito>> call, Response<List<Credito>> response) {
                List<Credito> listCreditos=response.body();
                if(listCreditos!=null){
                    SolicitudCreditoAdapter solicitudCreditoAdapter=new SolicitudCreditoAdapter(getContext(),listCreditos);
                    listViewCreditos.setAdapter(solicitudCreditoAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Credito>> call, Throwable t) {

            }
        });

    }
}
