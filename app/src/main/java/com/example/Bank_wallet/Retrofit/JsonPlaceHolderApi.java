package com.example.Bank_wallet.Retrofit;

import com.example.Bank_wallet.Datas.AuthenticationDTO;
import com.example.Bank_wallet.Datas.AuthenticationTokenDTO;
import com.example.Bank_wallet.Datas.Client;
import com.example.Bank_wallet.Datas.MultiTransfer;

import com.example.Bank_wallet.Spinner.SpinnerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    public String token = null;

    @GET("login")
    Call<List<AuthenticationTokenDTO>> getToken();

    @POST("login")
    Call<AuthenticationTokenDTO> postemail(@Body AuthenticationDTO body);


    @GET("me")
    Call<Client> getclient(@Header("Authorization") String token,
                           @Header("id") Integer id);


    @GET("beneficiaires")
    Call<List<SpinnerModel>> getlistbenef(@Header("Authorization") String token,
                                          @Header("id") Integer id);


    @POST("beneficiaire")
    Call<SpinnerModel> postbenef(@Header("Authorization") String token,
                                 @Header("id") Integer id ,@Body SpinnerModel body);


    @GET("client")
    Call<List<MultiTransfer>> getMultitransfers(@Header("Authorization") String token,
                                                @Header("id") Integer id);
    @POST("createTransfer")
    Call<MultiTransfer> postTransfer(@Header("Authorization") String token,
                                     @Header("id") Integer id,@Body MultiTransfer body);

    @GET("UniqueTransfer/{reference}")
    Call<MultiTransfer> getTransfer(@Header("Authorization") String token,
                                    @Header("id") Integer id, @Path("reference") String reference);
    @POST("https://ensa-api-transfer.herokuapp.com/api_client/UniqueTransfer/return/{reference}")
    Call<MultiTransfer> putTransfer(@Header("Authorization") String token,
                                    @Header("id") Integer id, @Path("reference") String reference,@Query("motif") String motif);
}
