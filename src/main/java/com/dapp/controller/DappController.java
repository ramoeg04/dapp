package com.dapp.controller;

import com.dapp.entities.EpConfiguration;
import com.dapp.services.EpConfigurationService;
import com.dapp.services.EpExecutionLogServices;
import com.dapp.services.EpExecutionServices;
import com.dapp.services.ProcessServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Geomar Salas
 */

@RestController
@RequestMapping("/api")
public class DappController {
    @Autowired 
    EpConfigurationService EpConfigurationService;
    EpExecutionServices EpExecutionServices;
    EpExecutionLogServices EpExecutionLogServices;
    ProcessServices ProcessServices;
 
    @Value("${endpoint1}")
    private Integer id; 
    
    @GetMapping("/configuration")
    public List<EpConfiguration> find() {
        return EpConfigurationService.find();
    }
    
    @GetMapping("/configuration/id")
    public EpConfiguration findById() {
        return EpConfigurationService.findById(id);
    }
    
    @GetMapping("/process1")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String Process1() {
		return ProcessServices.Process1();
    }
    
//    @RequestMapping("/getAll")
//    public List<EpConfiguration> getAllEndpoints(){
//        List<EpConfiguration> getAll = EpConfigurationRepository.findAll();
//        return getAll;
//    }
    
  ////////////////////////////////JA//////////////////////////////////////  
    @Value("${endpoint2}")
    private Double process2; 
    @GetMapping("/process2")
    public Double Process2() {
    	return process2;
    }
    
    @Value("${endpoint3}")
    private Double process3; 
    @GetMapping("/process3")
    public Double Process3() {
    	return process3;
    }
    
    @Value("${endpoint4}")
    private Double process4; 
    @GetMapping("/process4")
    public Double Process4() {
    	return process4;
    }
    
    @Value("${endpoint5}")
    private Double process5; 
    @GetMapping("/process5")
    public Double Process5() {
    	return process5;
    }
    
    @Value("${endpoint6}")
    private Integer process6; 
    
    @GetMapping("/process6")
    public String Process6() {
    	    	
    	return ProcessServices.Process6(process6);
    	
    	
    }
}
