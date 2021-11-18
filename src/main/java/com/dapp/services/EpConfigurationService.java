/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.services;

import com.dapp.entities.EpConfiguration;
import com.dapp.entities.error;
import com.dapp.repositorys.EpConfigurationRepository;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
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
public class EpConfigurationService {
    @Autowired
    public EpConfigurationRepository EpConfigurationRepository;
    
    public List<EpConfiguration> find(){
        List<EpConfiguration> find = EpConfigurationRepository.findAll();
        return find ;
    }
    
    public EpConfiguration findById(Integer id)
    {
    	EpConfiguration var = new EpConfiguration();
    	Optional<EpConfiguration> var2 = EpConfigurationRepository.findById(id);
    	if (var2.isPresent()) {
			var = var2.get();
		}
    	return var;
    }  
    
    public List<EpConfiguration> getAll(){
    	List<EpConfiguration> var2 = EpConfigurationRepository.findAll();
    			
//    			restTemplate.getForObject(
//    	                  "http://services-movies/api/movies/",
//    	                  EpConfiguration[].class);            
//    	                List<EpConfiguration> var2 = Arrays.asList(var);
    	        return  var2;
    	}
    
    
    
}
