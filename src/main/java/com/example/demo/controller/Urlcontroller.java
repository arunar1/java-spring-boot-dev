package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class Urlcontroller {

    private final String IS_SITE_UP="Site is up";
    private final String IS_SITE_DOWN="Site is down";
    private final String INCORRECT_URL="URL is incorrect";


    @GetMapping("/check")
    public String getUrlstatus(@RequestParam String url) {
        String returnMessage="";
        try {
            URL urlObj =new URL(returnMessage);
            try {
                HttpURLConnection conn =(HttpURLConnection) urlObj.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                int responseCategory= conn.getResponseCode()/100;
                if(responseCategory!=2 || responseCategory!=3){
                    returnMessage=IS_SITE_DOWN;
                }
                else{
                    returnMessage=IS_SITE_UP;
                }
            } catch (IOException e) {
                returnMessage=IS_SITE_DOWN;
            }
        } catch (MalformedURLException e) {
            returnMessage=INCORRECT_URL;
        }

        return returnMessage;
    }
    

}
