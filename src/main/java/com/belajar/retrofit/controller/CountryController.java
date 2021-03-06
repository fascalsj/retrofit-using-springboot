/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.retrofit.controller;

import com.google.gson.Gson;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.belajar.retrofit.client.CountryClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author fascal
 */
@Slf4j
@RestController
public class CountryController {

    @Autowired
    CountryClient resp;
    
    @GetMapping(value = "/all_country")
    public ResponseEntity allCountry() throws IOException {
        Gson gson = new Gson();
        String jsonInString;
        jsonInString = gson.toJson(resp.listAll().execute().body());
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonInString);
    }
   
    @GetMapping(value = "/all_country_by_name/{name}")
    public ResponseEntity allCountryByName(@PathVariable("name") String name) throws IOException {
        Gson gson = new Gson();
        String jsonInString;
        jsonInString = gson.toJson(resp.listAllCountryName(name).execute().body());
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonInString);
    }
    
    @GetMapping(value = "/all_country_custom")
    public ResponseEntity allCountryCustom() throws IOException {
        Gson gson = new Gson();
        String jsonInString;
        jsonInString = gson.toJson(resp.listAllCustom().execute().body());
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonInString);
    }
}
