package br.ufg.ecommerce.api;

import br.ufg.ecommerce.entity.UserReturn;
import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("login")
    Call<UserReturn> logar();

}
