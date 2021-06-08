package co.edu.tiendpp.service.login;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Type;


import co.edu.tiendpp.login.LoginActivity;
import co.edu.tiendpp.model.UsuarioTiendapp;
import co.edu.tiendpp.service.usuario.UsuarioClient;
import co.edu.tiendpp.util.GlobalState;
import co.edu.tiendpp.util.RetrofitFactory;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginServiceImpl extends RetrofitFactory {

    String credentials =  "tienda" + ":" + "123*";


    final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

    public LoginServiceImpl(Context context) {
        super(context);
    }

    public void login(String username, String password,String rol){
        Retrofit retrofit = getAuthInstance();
        LoginClient loginClient = retrofit.create(LoginClient.class);
        Call<ResponseBody> response = loginClient.login(basic,username,password,"password");
        response.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody responseBody = response.body();
                if(responseBody != null){
                    Gson gson = new Gson();
                    try {
                        LoginResponse loginResponse = gson.fromJson(responseBody.string(),(Type) LoginResponse.class);
                        setToken(loginResponse);
                        setUsuario(username,rol);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setToken(LoginResponse loginResponse) {
        GlobalState globalState = (GlobalState) getContext().getApplicationContext();
        globalState.setAccessToken(loginResponse.getAccess_token());
    }
    private void setUsuario(String userName,String rol){
        Retrofit retrofit=getTokenInstance();
        UsuarioClient client=retrofit.create(UsuarioClient.class);
        Call<UsuarioTiendapp> response=client.findByUserName(userName);
        response.enqueue(new Callback<UsuarioTiendapp>() {
            @Override
            public void onResponse(Call<UsuarioTiendapp> call, Response<UsuarioTiendapp> response) {
                UsuarioTiendapp usuario=response.body();
                GlobalState globalState = (GlobalState) getContext().getApplicationContext();
                globalState.setUsuarioTiendapp(usuario);
                if(usuario.getRoles().size()==2){
                    ((LoginActivity) getContext()).inUser(rol);
                    Toast.makeText(getContext(), rol, Toast.LENGTH_SHORT).show();

                }else{
                    if(rol.equals(usuario.getRoles().get(0))){
                        ((LoginActivity) getContext()).inUser(usuario.getRoles().get(0));
                        Toast.makeText(getContext(),usuario.getRoles().get(0), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getContext(), "credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }



            }

            @Override
            public void onFailure(Call<UsuarioTiendapp> call, Throwable t) {

            }
        });



    }






}
