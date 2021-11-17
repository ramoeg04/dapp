/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.services;

import com.dapp.entities.Endpoint1;
import com.dapp.entities.Endpoint1data;
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

	public Endpoint1 Process1(Integer idEndpoint1) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint1);
		HttpGet get = new HttpGet(var1.getEndpointDapp());
//		"http://localhost:8080/api/configuration/var1.get.id"
		String responseString = null;
		get.setHeader("Authorization", "Basic " + var1.getToken());
//		"OjY3YmUzODU5LThhNjgtNDBmNC1iNzQ4LWQ2MGQxZmExMTZhYQ=="
		HttpClient httpClient = HttpClientBuilder.create().build();
		Gson gson = new Gson();
		Endpoint1 data = null;

		try {
			HttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
//			System.out.println("Valor del responseString:  " + responseString);
			data = gson.fromJson(responseString, Endpoint1.class);

			try {
				if (data == null) {
					System.out.println("Data Vacia");
				} else if (data.getRc() == 0) {
					System.out.println("RC es 0, Todo OK");
				} else if (!data.getMsg().equals("Ok")) {
					System.out.println("Malo");
				} else {
					System.out.println("Todo Ok");

					try {
						for (Endpoint1data i : data.getData()) {
							System.out.println(i);
							if (i.getName() == null) {
								System.out.println("Nombre Nulo");
							} else if (i.getQr() == null) {
								System.out.println("QR Nula");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// if endpoint1. == null{
//				
//			}else rc !==0 
//					{
//				for()
//					}
//								recorrer la lista for each edponit1.get.data campo es = null ..ProcessServices.class break --- global response  
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

//   dar salida de validacion

	public String Process6(Integer process6) {
		EpConfiguration var = new EpConfiguration();
		Optional<EpConfiguration> var2 = EpConfigurationRepository.findById(1);//
		if (var2.isPresent()) {
			var = var2.get();
		} else {
			return "la estas poniendo";
		}
		// ejemplo de consulta a un backend
		System.out.println("Consumiento Servicio de" + var.getEndpointDapp());
//    	System.out.println("Creando el token del back");
//		String token = JwtUtil.addAuthenticationBack();
		HttpGet get = new HttpGet(var.getEndpointDapp());// cargamos el endpoint
		String responseString = null;
		HttpClient httpClient = HttpClientBuilder.create().build();
		Gson gson = new Gson();
//		get.setHeader("Authorization", "Bearer " + var.getToken());
//		get.setHeader("channel", channel);
//		get.setHeadr("csidpub", csidpub);
		
		try {
			HttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.println("Valor del responseString:  " + responseString);
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
