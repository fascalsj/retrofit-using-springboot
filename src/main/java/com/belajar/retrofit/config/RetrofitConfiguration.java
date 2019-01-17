/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.retrofit.config;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.belajar.retrofit.client.CountryClient;

/**
 *
 * @author fascal
 */
@Configuration
@Component
public class RetrofitConfiguration {
     @Bean
    public CountryClient countriesApiClientConfig() {
        String baseUrl = "https://restcountries.eu/rest/";
        final Logger logger = LoggerFactory.getLogger(CountryClient.class);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.MINUTES)
                .addInterceptor(chain -> {
                    Request request = chain.request().newBuilder().build();
                    long startTime = System.currentTimeMillis();
                    logger.info("Sending request to url: {}", request.url());
                    Response response = chain.proceed(request);
                    long endTime = System.currentTimeMillis() - startTime;
                    logger.info("Received response for call with duration "+endTime+":  {}", request.url());
                    return response;
                })
                .build();

        return new Retrofit.Builder()
                .client(okHttpClient)
                 .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(CountryClient.class);
    }
}
