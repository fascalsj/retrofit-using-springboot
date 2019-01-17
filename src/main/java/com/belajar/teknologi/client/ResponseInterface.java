/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.teknologi.client;

import com.belajar.teknologi.response.CountryResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author fascal
 */
public interface ResponseInterface {
    @GET("v2/all")
    Call<List> listAll();
    
    @GET("v2/all")
    Call<List<CountryResponse>> listAllCustom();

    
}
