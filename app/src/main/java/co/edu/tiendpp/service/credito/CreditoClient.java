package co.edu.tiendpp.service.credito;

import java.util.List;

import co.edu.tiendpp.model.Credito;
import co.edu.tiendpp.model.UsuarioTiendapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CreditoClient {

    @GET("aprobados/{idAdmin}")
    Call<List<Credito>> findByidAdmiActivos(@Path("idAdmin") int idAdmin);

    @GET("aprobar/{idAdmin}")
    Call<List<Credito>> findByidAdmiPendientes(@Path("idAdmin") int idAdmin);
}
