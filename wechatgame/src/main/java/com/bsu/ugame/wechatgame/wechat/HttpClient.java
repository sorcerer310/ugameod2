package com.bsu.ugame.wechatgame.wechat;

import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class HttpClient {
    public String client(String url, HttpMethod method, MultiValueMap<String, String> params){

        RestTemplate client = new RestTemplate();
        ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse){
                try{
                    System.out.println("has error"+clientHttpResponse.getStatusCode());
                }catch(Exception e){
                    e.printStackTrace();
                }
                return true;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse){
                try{
                    System.out.println("handler error"+clientHttpResponse.getStatusCode());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        client.setErrorHandler(responseErrorHandler);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }
}