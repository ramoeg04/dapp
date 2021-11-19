/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.services;

import com.dapp.entities.EpConfiguration;
import com.dapp.entities.EpExecution;
import com.dapp.entities.EpExecutionLog;
import com.dapp.entities.endpoint1.Endpoint1;
import com.dapp.entities.endpoint1.Endpoint1data;
import com.dapp.entities.endpoint2.Endpoint2;
import com.dapp.entities.endpoint3.Endpoint3;
import com.dapp.entities.endpoint4.Endpoint4;
import com.dapp.entities.endpoint5.Endpoint5;
import com.dapp.entities.endpoint6.Endpoint6;
import com.dapp.repositorys.EpConfigurationRepository;
import com.dapp.repositorys.EpExecutionLogRepository;
import com.google.gson.Gson;
import java.util.Optional;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Geomar Salas
 */
@Service
public class ProcessService {
	@Autowired
	public EpConfigurationRepository EpConfigurationRepository;
	@Autowired
	public EpExecutionLogServices EpExecutionLogServices;

	public Endpoint1 Process1(Integer idEndpoint1) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint1);
		HttpGet get = new HttpGet(var1.getEndpointDapp());
		EpExecutionLog RegisterLog = new EpExecutionLog(); // no
		EpExecution Register = new EpExecution();// no
		/// AQUI VA EL REGISTRADO DE LA BASE DE DATOS///

		String responseString = null;
		get.setHeader("Authorization", "Basic " + var1.getToken());
//		"OjY3YmUzODU5LThhNjgtNDBmNC1iNzQ4LWQ2MGQxZmExMTZhYQ=="
		HttpClient httpClient = HttpClientBuilder.create().build();
		Gson gson = new Gson(); // no
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
				}
				if (!data.getMsg().equals("Ok")) {
					System.out.println("Malo");
				} else {
					System.out.println("Todo Ok");

					try {
						for (Endpoint1data i : data.getData()) {
							if (i.getId() == 0) {
								System.out.println("Id Nulo");
							} else if (i.getName().equals(null)) {
								System.out.println("Nombre Nula");
							} else if (i.getQr() == null) {
								System.out.println("QR Nula");
							} else if (i.getPush_notification() == null) {
								System.out.println("notificacion Nula");
							} else {
								System.out.println(i);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Endpoint2 Process2(Integer idEndpoint2) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint2);
		HttpPost post = new HttpPost(var1.getEndpointDapp());
		String responseString = null;
		post.setHeader("Authorization", "Basic " + var1.getToken());
		HttpClient httpClient = HttpClientBuilder.create().build();
		Endpoint2 data = null;
		try {
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.print(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Endpoint3 Process3(Integer idEndpoint3) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint3);
		HttpPost post = new HttpPost(var1.getEndpointDapp());
		String responseString = null;
		post.setHeader("Authorization", "Basic " + var1.getToken());
		HttpClient httpClient = HttpClientBuilder.create().build();
		Endpoint3 data = null;
		try {
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.print(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Endpoint4 Process4(Integer idEndpoint4) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint4);
		HttpGet get = new HttpGet(var1.getEndpointDapp());
		String responseString = null;
		get.setHeader("Authorization", "Basic " + var1.getToken());
		HttpClient httpClient = HttpClientBuilder.create().build();
		Endpoint3 data = null;
		try {
			HttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			System.out.print(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Endpoint5 Process5(Integer idEndpoint5) {
		return null;
	}

	public Endpoint6 Process6(Integer idEndpoint6) {
		EpConfiguration var = new EpConfiguration();
		Optional<EpConfiguration> var2 = EpConfigurationRepository.findById(1);//
//		if (var2.isPresent()) {
//			var = var2.get();
//		} else {
//			return "la estas poniendo";
//		}
		// ejemplo de consulta a un backend
		System.out.println("Consumiento Servicio de" + var.getEndpointDapp());
//    	System.out.println("Creando el token del back");
//		String token = JwtUtil.addAuthenticationBack();
		HttpPost post = new HttpPost(var.getEndpointDapp());// cargamos el endpoint
		String responseString = null;
		HttpClient httpClient = HttpClientBuilder.create().build();
		Gson gson = new Gson();
//		get.setHeader("Authorization", "Bearer " + var.getToken());
//		get.setHeader("channel", channel);
//		get.setHeadr("csidpub", csidpub);

		try {
			HttpResponse response = httpClient.execute(post);
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
		return null;
	}

}
