package br.ufg.ecommerce.controller;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.ref.WeakReference;

import br.ufg.ecommerce.CatalogActivity;
import br.ufg.ecommerce.MainActivity;
import br.ufg.ecommerce.api.LoginApi;
import br.ufg.ecommerce.entity.UserReturn;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginController implements Callback<UserReturn> {

    private String URLS = "http://private-2bb041-sandromoreira.apiary-mock.com/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLS)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        LoginApi loginApi = retrofit.create(LoginApi.class);

        Call<UserReturn> call = loginApi.logar();
        call.enqueue(this);

    }

    WeakReference<Context> mContextReference;

    public LoginController(Context context) {
        mContextReference = new WeakReference<Context>(context);
    }

    @Override
    public void onResponse(Call<UserReturn> call, Response<UserReturn> response) {
        Context context = mContextReference.get();
        if(response.isSuccessful()) {
            UserReturn user = response.body();
            System.out.println(user.getName());
            System.out.println(user.getToken());
            System.out.println(user.getPhoto_url());
            Gson gson = new Gson();
            String json = gson.toJson(user);
            Intent second = new Intent(context,CatalogActivity.class);
            // second.putExtra(MainActivity.USERRETURN, json);
            context.startActivity(second);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<UserReturn> call, Throwable t) {
        t.printStackTrace();
    }
}
