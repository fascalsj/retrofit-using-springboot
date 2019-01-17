/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.retrofit.response;

/**
 *
 * @author fascal
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryResponse {
    public String name;
    public String capital;
    public String region;
    public String subregion;
    public String nativeName;
}
