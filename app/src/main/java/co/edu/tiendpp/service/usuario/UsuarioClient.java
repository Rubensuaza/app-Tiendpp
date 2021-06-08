package co.edu.tiendpp.service.usuario;


import co.edu.tiendpp.model.UsuarioTiendapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsuarioClient {

    @GET("/usuario-tiendapp/{userName}")
    Call<UsuarioTiendapp> findByUserName(@Path ("userName") String userName);

}
