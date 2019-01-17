/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.retrofit.client;

import com.belajar.retrofit.response.CountryResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * @author fascal
 */
public interface CountryClient {
    @GET("v2")
    Call<List> listAll();
    
    @GET("v2")
    Call<List<CountryResponse>> listAllCustom();
    
    @GET("v2/name/{name}")
    Call<List> listAllCountryName(@Path("name") String name);
}
