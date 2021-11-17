/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.services;

import com.dapp.entities.EpConfiguration;
import com.dapp.repositorys.EpConfigurationRepository;
import com.google.gson.Gson;
import java.util.Optional;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Geomar Salas
 */
@Service
public class ProcessServices {
	@Autowired
    public EpConfigurationRepository EpConfigurationRepository;
    
    public String Process1() {
    	
    	// ejemplo de consulta a un backend 
    	System.out.println("Consumiento Servicio de Llamado om-account-suspend");
		
    	System.out.println("Creando el token del back");
//		String token = JwtUtil.addAuthenticationBack();
		HttpGet get = new HttpGet("http://localhost:8080/api/configuration/id");
		String responseString=null;
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		Gson gson = new Gson();
		
//		get.setHeader("Authorization", "Bearer " + token);
//		get.setHeader("channel", channel);
//		get.setHeadr("csidpub", csidpub);
		try {
			HttpResponse response = httpClient.execute(get);
			
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.println("Valor del responseString:  "+ responseString);
			EpConfiguration data = gson.fromJson(responseString, EpConfiguration.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

//		objResponse = gson.fromJson(responseString, ResponseApiOmService.class);

    	return responseString;
    }
   
   

	public String Process6(Integer process6) {
		
		EpConfiguration var = new EpConfiguration();
    	Optional<EpConfiguration> var2 = EpConfigurationRepository.findById(1);//
    	if (var2.isPresent()) {
			var = var2.get();
		}else {
			return "la estas poniendo";
		}
		
    	// ejemplo de consulta a un backend 
    	System.out.println("Consumiento Servicio de" + var.getEndpointDapp());
		
//    	System.out.println("Creando el token del back");
//		String token = JwtUtil.addAuthenticationBack();
		HttpGet get = new HttpGet(var.getEndpointDapp());// cargamos el endpoint 
		String responseString=null;
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		Gson gson = new Gson();
		
//		get.setHeader("Authorization", "Bearer " + var.getToken());
//		get.setHeader("channel", channel);
//		get.setHeadr("csidpub", csidpub);
		try {
			HttpResponse response = httpClient.execute(get);
			
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.println("Valor del responseString:  "+ responseString);
//			error data = gson.fromJson(responseString, error.class);
//			System.out.println("mensaje de el cliente "+data.getMsg());
			System.out.println(response.getStatusLine());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return "todo ok";
	}
    
}
