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

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;
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
					
		RegisterLog = EpExecutionLogServices.EpExecutionLogRepository.getById(idBaseDeDatos);
		RegisterLog.setDescriptionProcess("->iniciando procees3");
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
		int theError = 0;

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
			globalexception globalexception = new globalexception (0,"Error",null); 
			try {

				if (handler.handler1(data) != 0) {
					throw globalexception;
				}

			} catch (Exception e) {
				System.out.println("Error no se pudo ejecutar el handler");
				throw globalexception;
				// TODO: handle exception
			}

//			try {
//				if (data == null) {
//					isOkData = false;
//					theError = 1;
//
//				} else if (data.getRc() != 0) {
//					isOkData = false;
//					theError = 2;
//				}
//				if (!data.getMsg().equals("Ok")) {
//					isOkData = false;
//					theError = 3;
//				}
//
//				try {
//					for (Endpoint1data i : data.getData()) {
//						if (i.getId() == null) {
//							isOkData = false;
//							theError = 4;
//							break;
//						} else if (i.getName().equals(null)) {
//							isOkData = false;
//							theError = 5;
//							break;
//						} else if (i.getQr() == null) {
//							isOkData = false;
//							theError = 6;
//							break;
//						} else if (i.getPush_notification() == null) {
//							isOkData = false;
//							theError = 7;
//							break;
//						}
//					}
//				} catch (Exception e) {
//					isOkData = false;
//					theError = 8;
//					e.printStackTrace();
//				}
//
//			} catch (Exception e) {
//				theError = 9;
//				isOkData = false;
//				e.printStackTrace();
//			}
		} catch (Exception e) {
			theError = 10;
			isOkData = false;
			e.printStackTrace();
		}

		if (!isOkData) {
			RegisterLog
					.setDescriptionProcess(RegisterLog.getDescriptionProcess() + "-> endpoint1 Error --> " + theError);
			fechaActual = new Date();
			RegisterLog.setRecupdated(fechaActual);
			RegisterLog.setStatus("Error");
			RegisterLog = EpExecutionLogServices.save(RegisterLog);
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
		int theError = 0;

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
					if (data == null) {
						isOkData = false;
						theError = 1;

					} else if (data.getRc() != 0) {
						isOkData = false;
						theError = 2;
					}
					if (!data.getMsg().equals("Ok")) {
						isOkData = false;
						theError = 3;
					}

				} catch (Exception e) {
					isOkData = false;
					theError = 4;
					e.printStackTrace();
				}

			} catch (Exception e) {
				isOkData = false;
				theError = 5;
				e.printStackTrace();
			}
			if (!isOkData) {
				RegisterLog.setDescriptionProcess(
				RegisterLog.getDescriptionProcess() + "-> endpoint2 Error --> " + theError);
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
			int theError = 0;
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
					if (data == null) {
						isOkData = false;
						theError = 1;

					} else if (data.getRc() != 0) {
						isOkData = false;
						theError = 2;
					}
					if (!data.getMsg().equals("Ok")) {
						isOkData = false;
						theError = 3;
					}

				} catch (Exception e) {
					theError = 4;
					isOkData = false;
					e.printStackTrace();
				}

			} catch (Exception e) {
				isOkData = false;
				theError = 5;
				e.printStackTrace();
			}
			if (!isOkData) {
				RegisterLog.setDescriptionProcess(
						RegisterLog.getDescriptionProcess() + "-> endpoint3 Error --> " + theError);
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
		int theError = 0;

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
					if (data == null) {
						isOkData = false;
						theError = 1;

					} else if (data.getRc() != 0) {
						isOkData = false;
						theError = 2;
					}
					if (!data.getMsg().equals("Ok")) {
						isOkData = false;
						theError = 3;
					}

				} catch (Exception e) {
					isOkData = false;
					theError = 4;
					e.printStackTrace();
				}

			} catch (Exception e) {
				isOkData = false;
				theError = 5;
				e.printStackTrace();
			}
			if (!isOkData) {
				RegisterLog.setDescriptionProcess(
						RegisterLog.getDescriptionProcess() + "-> endpoint4 Error --> " + theError);
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
		int theError = 0;

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
					if (data == null) {
						isOkData = false;
						theError = 1;

					} else if (data.getRc() != 0) {
						isOkData = false;
						theError = 2;
					}
					if (!data.getMsg().equals("Ok")) {
						isOkData = false;
						theError = 3;
					}

				} catch (Exception e) {
					isOkData = false;
					theError = 4;
					e.printStackTrace();
				}

			} catch (Exception e) {
				isOkData = false;
				theError = 5;
				e.printStackTrace();
			}
			if (!isOkData) {
				RegisterLog.setDescriptionProcess(
						RegisterLog.getDescriptionProcess() + "-> endpoint5 Error --> " + theError);
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
