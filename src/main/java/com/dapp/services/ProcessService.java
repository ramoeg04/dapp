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
//import com.dapp.entities.endpoint1.Endpoint1data;
import com.dapp.entities.endpoint2.Endpoint2;
import com.dapp.entities.endpoint2.endpoint2request;
import com.dapp.entities.endpoint3.Endpoint3;
import com.dapp.entities.endpoint4.Endpoint4;
import com.dapp.entities.endpoint5.Endpoint5;
import com.dapp.entities.endpoint5.endpoint5request;
import com.dapp.entities.exception.globalexception;
import com.dapp.repositorys.EpConfigurationRepository;
import com.dapp.util.handler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ch.qos.logback.classic.Logger;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import javax.faces.flow.SwitchCase;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
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
	@Autowired
	public EpExecutionServices EpExecutionServices;
	@Autowired
	public handler handler;

	public Endpoint1 Process1(Integer idEndpoint1, int idBaseDeDatos) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint1);
		HttpGet get = new HttpGet(var1.getEndpointDapp() + "/wallets");
		EpExecutionLog RegisterLog = new EpExecutionLog();
		EpExecution Register = new EpExecution();
		Date fechaActual = new Date();

		RegisterLog.setDescriptionProcess("->iniciando procees1");
		RegisterLog.setTypeProcess("venta");
		RegisterLog.setReccreated(fechaActual);
		RegisterLog.setRecupdated(fechaActual);
		RegisterLog.setStatus("initiated");
		RegisterLog = EpExecutionLogServices.save(RegisterLog);
		Register.setEpConfigurationId(var1);
		Register.setReccreated(fechaActual);
		Register.setRecupdated(fechaActual);
		Register.setEpExecutionLogId(RegisterLog);
		Register = EpExecutionServices.save(Register);

		String responseString = null;
		get.setHeader("Authorization", "Basic " + var1.getToken());
		HttpClient httpClient = HttpClientBuilder.create().build();
		Gson gson = new Gson();
		Endpoint1 data = new Endpoint1();
		boolean isOkData = true;
		String message = null;
		int error = 0;
		Register.setJsonIn("");
		fechaActual = new Date();
		Register.setRecupdated(fechaActual);
		Register = EpExecutionServices.save(Register);
		
		try {
			HttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			Register.setJsonOut(responseString);
			System.out.print(responseString);
			fechaActual = new Date();
			Register.setRecupdated(fechaActual);
			Register = EpExecutionServices.save(Register);
			data = gson.fromJson(responseString, Endpoint1.class);

			try {
				error = handler.handler1(data);
				if (error != 0) {
					isOkData = false;
					System.out.println(error);
					switch (error) {
					case 1:
						message = "Objeto del Endpoint Vacio";
						break;
					case 2:
						message = "Datos del Objeto del Endpoint Vacio";
						break;
					case 3:
						message = "Endpoint Fallo";
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("Error no se pudo ejecutar el handler");
				error = 4;
				message = e.getMessage();
				isOkData = false;
			}
		} catch (Exception e) {
			error = 4;
			message = e.getMessage();
			isOkData = false;
		}
		if (!isOkData) {
			RegisterLog
					.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "-> endpoint1 Error --> " + message);
			fechaActual = new Date();
			RegisterLog.setRecupdated(fechaActual);
			RegisterLog.setStatus("Error");
			RegisterLog = EpExecutionLogServices.save(RegisterLog);
			throw new globalexception(error, message, null);
		} else {
			RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "-> endpoint1 sucess");
			fechaActual = new Date();
			RegisterLog.setRecupdated(fechaActual);
			RegisterLog.setStatus("En Proceso");
			RegisterLog = EpExecutionLogServices.save(RegisterLog);
		}
		return data;
	}

	public Endpoint2 Process2(Integer idEndpoint1, endpoint2request endpoint2resquest, int idBaseDeDatos) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint1);
		EpExecutionLog RegisterLog = new EpExecutionLog();
		EpExecution Register = new EpExecution();
		Date fechaActual = new Date();
		Endpoint2 data = null;
		boolean isOkData = true;
		String message = null;
		int error = 0;
		

		if (!(RegisterLog.getStatus() == "Error")) {
			RegisterLog = EpExecutionLogServices.EpExecutionLogRepository.getById(idBaseDeDatos);
			RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "->iniciando procees2");
			RegisterLog.setRecupdated(fechaActual);
			RegisterLog = EpExecutionLogServices.save(RegisterLog);
			Register.setEpExecutionLogId(RegisterLog);
			Register.setEpConfigurationId(var1);
			Register.setReccreated(fechaActual);
			Register.setRecupdated(fechaActual);
			Register = EpExecutionServices.EpExecutionRepository.save(Register);

			HttpPost post = new HttpPost(var1.getEndpointDapp());
			String responseString = null;
			post.setHeader("Authorization", "Basic " + var1.getToken());
			post.setHeader("Content-Type", "application/json");
			ObjectMapper mapper = new ObjectMapper();

			try {
				String json = mapper.writeValueAsString(endpoint2resquest);
				post.setEntity(new StringEntity(json, StandardCharsets.UTF_8));
				Register.setJsonIn(json);
				HttpClient httpClient = HttpClientBuilder.create().build();
				HttpResponse response = httpClient.execute(post);
				HttpEntity entity = response.getEntity();
				responseString = EntityUtils.toString(entity, "UTF-8");
				Register.setJsonOut(responseString);
				fechaActual = new Date();
				Register.setRecupdated(fechaActual);
				Register = EpExecutionServices.EpExecutionRepository.save(Register);
				Gson gson = new Gson();
				data = gson.fromJson(responseString, Endpoint2.class);
				System.out.println(data);

				try {
					error = handler.handler2(data);
					if (error != 0) {
						isOkData = false;
						System.out.println(error);
						switch (error) {
						case 1:
							message = "Objeto del Endpoint Vacio";
							break;
						case 2:
							message = "Datos del Objeto del Endpoint Vacio";
							break;
						case 3:
							message = "Endpoint Fallo";
							break;
						}
					}
				} catch (Exception e) {
					System.out.println("Error no se pudo ejecutar el handler");
					error = 4;
					message = e.getMessage();
					isOkData = false;
				}
			} catch (Exception e) {
				error = 4;
				message = e.getMessage();
				isOkData = false;
			}
			if (!isOkData) {
				RegisterLog.setDescriptionProcess(
						RegisterLog.getDescriptionProcess() + "-> endpoint2 Error --> " + message);
				fechaActual = new Date();
				RegisterLog.setRecupdated(fechaActual);
				RegisterLog.setStatus("Error");
				RegisterLog = EpExecutionLogServices.save(RegisterLog);
			} else {
				RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "-> endpoint2 sucess");
				fechaActual = new Date();
				RegisterLog.setRecupdated(fechaActual);
				RegisterLog.setStatus("En Proceso");
				RegisterLog = EpExecutionLogServices.save(RegisterLog);
			}
		} else {
////////////////////////////////////////////////
		}
		return data;
	}

	public Endpoint3 Process3(String id, Integer idEndpoint1, int idBaseDeDatos) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint1);
		HttpGet get = new HttpGet(var1.getEndpointDapp() + id + "/payment");
		EpExecutionLog RegisterLog = new EpExecutionLog();
		EpExecution Register = new EpExecution();
		Date fechaActual = new Date();
		Endpoint3 data = new Endpoint3();

		if (!(RegisterLog.getStatus() == "Error")) {
			RegisterLog = EpExecutionLogServices.EpExecutionLogRepository.getById(idBaseDeDatos);
			RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "->iniciando procees3");
			RegisterLog.setRecupdated(fechaActual);
			RegisterLog.setStatus("fin");
			RegisterLog = EpExecutionLogServices.save(RegisterLog);
			Register.setEpExecutionLogId(RegisterLog);
			Register.setEpConfigurationId(var1);
			Register.setReccreated(fechaActual);
			Register.setRecupdated(fechaActual);
			Register = EpExecutionServices.EpExecutionRepository.save(Register);

			String responseString = null;
			get.setHeader("Authorization", "Basic " + var1.getToken());
			HttpClient httpClient = HttpClientBuilder.create().build();
			Gson gson = new Gson();
			boolean isOkData = true;
			String message = null;
			int error = 0;
			Register.setJsonIn("");
			try {
				HttpResponse response = httpClient.execute(get);
				HttpEntity entity = response.getEntity();
				responseString = EntityUtils.toString(entity, "UTF-8");
				Register.setJsonOut(responseString);
				System.out.print(responseString);
				fechaActual = new Date();
				Register.setRecupdated(fechaActual);
				Register = EpExecutionServices.save(Register);
				data = gson.fromJson(responseString, Endpoint3.class);

				try {
					error = handler.handler3(data);
					if (error != 0) {
						isOkData = false;
						System.out.println(error);
						switch (error) {
						case 1:
							message = "Objeto del Endpoint Vacio";
							break;
						case 2:
							message = "Datos del Objeto del Endpoint Vacio";
							break;
						case 3:
							message = "Endpoint Fallo";
							break;
						}
					}
				} catch (Exception e) {
					System.out.println("Error no se pudo ejecutar el handler");
					error = 4;
					message = e.getMessage();
					isOkData = false;
				}
			} catch (Exception e) {
				error = 4;
				message = e.getMessage();
				isOkData = false;
			}
			if (!isOkData) {
				RegisterLog.setDescriptionProcess(
						RegisterLog.getDescriptionProcess() + "-> endpoint3 Error --> " + message);
				fechaActual = new Date();
				RegisterLog.setRecupdated(fechaActual);
				RegisterLog.setStatus("Error");
				RegisterLog = EpExecutionLogServices.save(RegisterLog);
			} else {
				RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "-> endpoint3 sucess");
				fechaActual = new Date();
				RegisterLog.setRecupdated(fechaActual);
				RegisterLog.setStatus("En Proceso");
				RegisterLog = EpExecutionLogServices.save(RegisterLog);
			}

		} else {
/////////////////////////////////////////
		}
		return data;
	}

	public Endpoint4 Process4(String ticket_id, Integer idEndpoint4, int idBaseDeDatos) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint4);
		EpExecutionLog RegisterLog = new EpExecutionLog();
		EpExecution Register = new EpExecution();
		Date fechaActual = new Date();
		Endpoint4 data = null;
		boolean isOkData = true;
		String message = null;
		int error = 0;
		Register.setJsonIn("");

		if (!(RegisterLog.getStatus() == "Error")) {
			RegisterLog = EpExecutionLogServices.EpExecutionLogRepository.getById(idBaseDeDatos);
			RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "->iniciando procees4");
			RegisterLog.setTypeProcess("Reembolso");
			RegisterLog.setRecupdated(fechaActual);
			RegisterLog = EpExecutionLogServices.save(RegisterLog);
			Register.setEpExecutionLogId(RegisterLog);
			Register.setEpConfigurationId(var1);
			Register.setReccreated(fechaActual);
			Register.setRecupdated(fechaActual);
			Register = EpExecutionServices.EpExecutionRepository.save(Register);

			HttpPost post = new HttpPost(var1.getEndpointDapp() + ticket_id + "/refund/full");
			String responseString = null;
			post.setHeader("Authorization", "Basic " + var1.getToken());
			post.setHeader("Content-Type", "application/json");
			ObjectMapper mapper = new ObjectMapper();

			try {
//				String json = mapper.writeValueAsString(endpoint5request);
//				post.setEntity(new StringEntity(json, StandardCharsets.UTF_8));
//				Register.setJsonIn(json);
				HttpClient httpClient = HttpClientBuilder.create().build();
				HttpResponse response = httpClient.execute(post);
				HttpEntity entity = response.getEntity();
				responseString = EntityUtils.toString(entity, "UTF-8");
				Register.setJsonOut(responseString);
				fechaActual = new Date();
				Register.setRecupdated(fechaActual);
				Register = EpExecutionServices.EpExecutionRepository.save(Register);
				Gson gson = new Gson();
				data = gson.fromJson(responseString, Endpoint4.class);
				System.out.println(data);
				try {
					error = handler.handler4(data);
					if (error != 0) {
						isOkData = false;
						System.out.println(error);
						switch (error) {
						case 1:
							message = "Objeto del Endpoint Vacio";
							break;
						case 2:
							message = "Datos del Objeto del Endpoint Vacio";
							break;
						case 3:
							message = "Endpoint Fallo";
							break;
						}
					}
				} catch (Exception e) {
					System.out.println("Error no se pudo ejecutar el handler");
					error = 4;
					message = e.getMessage();
					isOkData = false;
				}
			} catch (Exception e) {
				error = 4;
				message = e.getMessage();
				isOkData = false;
			}
			if (!isOkData) {
				RegisterLog.setDescriptionProcess(
						RegisterLog.getDescriptionProcess() + "-> endpoint4 Error --> " + message);
				fechaActual = new Date();
				RegisterLog.setRecupdated(fechaActual);
				RegisterLog.setStatus("Error");
				RegisterLog = EpExecutionLogServices.save(RegisterLog);
			} else {
				RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "-> endpoint4 sucess");
				fechaActual = new Date();
				RegisterLog.setRecupdated(fechaActual);
				RegisterLog.setStatus("En Proceso");
				RegisterLog = EpExecutionLogServices.save(RegisterLog);
			}
		} else {
///////////////////////////////
		}
		return data;
	}

	public Endpoint5 Process5(String ticket_id, String payment_id, Integer idEndpoint4,
			endpoint5request endpoint5request, int idBaseDeDatos) {
		EpConfiguration var1 = EpConfigurationRepository.getById(idEndpoint4);
		EpExecutionLog RegisterLog = new EpExecutionLog();
		EpExecution Register = new EpExecution();
		Date fechaActual = new Date();
		Endpoint5 data = null;
		boolean isOkData = true;
		String message = null;
		int error = 0;
		

		if (!(RegisterLog.getStatus() == "Error")) {
			RegisterLog = EpExecutionLogServices.EpExecutionLogRepository.getById(idBaseDeDatos);
			RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "->iniciando procees5");
			RegisterLog.setTypeProcess("Reembolso");
			RegisterLog.setRecupdated(fechaActual);
			RegisterLog = EpExecutionLogServices.save(RegisterLog);
			Register.setEpExecutionLogId(RegisterLog);
			Register.setEpConfigurationId(var1);
			Register.setReccreated(fechaActual);
			Register.setRecupdated(fechaActual);
			Register = EpExecutionServices.EpExecutionRepository.save(Register);

			HttpPost post = new HttpPost(var1.getEndpointDapp() + ticket_id + "/refund/partial/" + payment_id);
			String responseString = null;
			post.setHeader("Authorization", "Basic " + var1.getToken());
			post.setHeader("Content-Type", "application/json");
			ObjectMapper mapper = new ObjectMapper();

			try {
				String json = mapper.writeValueAsString(endpoint5request);
				post.setEntity(new StringEntity(json, StandardCharsets.UTF_8));
				Register.setJsonIn(json);
				HttpClient httpClient = HttpClientBuilder.create().build();
				HttpResponse response = httpClient.execute(post);
				HttpEntity entity = response.getEntity();
				responseString = EntityUtils.toString(entity, "UTF-8");
				Register.setJsonOut(responseString);
				fechaActual = new Date();
				Register.setRecupdated(fechaActual);
				Register = EpExecutionServices.EpExecutionRepository.save(Register);
				Gson gson = new Gson();
				data = gson.fromJson(responseString, Endpoint5.class);
				System.out.println(data);
				try {
					error = handler.handler5(data);
					if (error != 0) {
						isOkData = false;
						System.out.println(error);
						switch (error) {
						case 1:
							message = "Objeto del Endpoint Vacio";
							break;
						case 2:
							message = "Datos del Objeto del Endpoint Vacio";
							break;
						case 3:
							message = "Endpoint Fallo";
							break;
						}
					}
				} catch (Exception e) {
					System.out.println("Error no se pudo ejecutar el handler");
					error = 4;
					message = e.getMessage();
					isOkData = false;
				}
			} catch (Exception e) {
				error = 4;
				message = e.getMessage();
				isOkData = false;
			}
			if (!isOkData) {
				RegisterLog.setDescriptionProcess(
						RegisterLog.getDescriptionProcess() + "-> endpoint5 Error --> " + message);
				fechaActual = new Date();
				RegisterLog.setRecupdated(fechaActual);
				RegisterLog.setStatus("Error");
				RegisterLog = EpExecutionLogServices.save(RegisterLog);
			} else {
				RegisterLog.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "-> endpoint5 sucess");
				fechaActual = new Date();
				RegisterLog.setRecupdated(fechaActual);
				RegisterLog.setStatus("En Proceso");
				RegisterLog = EpExecutionLogServices.save(RegisterLog);
			}
		} else {
/////////////////////////
		}
		return data;
	}

	public EpExecutionLog istodook(int idBaseDedatos) {
		EpExecutionLog dataOutput = new EpExecutionLog();
		try {
			Optional<EpExecutionLog> data = EpExecutionLogServices.EpExecutionLogRepository.findById(idBaseDedatos);
			if (data.isPresent()) {
				dataOutput = data.get();
			}
			System.out.println(dataOutput.toString());
			System.out.println(dataOutput.getEpExecutionCollection());
			try {
				for (EpExecution iterable_element : dataOutput.getEpExecutionCollection()) {
					System.out.println(iterable_element.getEpConfigurationId());
					System.out.println(iterable_element.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return dataOutput;
	}

}
