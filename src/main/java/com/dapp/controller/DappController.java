package com.dapp.controller;

import com.dapp.entities.Endpoint1;
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
import org.springframework.web.bind.annotation.PostMapping;
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
	@Autowired
	EpExecutionServices EpExecutionServices;
	@Autowired
	EpExecutionLogServices EpExecutionLogServices;
	@Autowired
	ProcessServices ProcessServices;

////////////////////////////////Configurations//////////////////////////////////////     
	@GetMapping("/configuration")
	public List<EpConfiguration> find() {
		return EpConfigurationService.find();
	}

	@GetMapping("/configuration/id")
	public EpConfiguration findById() {
		return EpConfigurationService.findById(idEndpoint1);
	}

////////////////////////////////Process//////////////////////////////////////   
	@Value("${endpoint1}")
	private Integer idEndpoint1;

	@GetMapping("/process1")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Endpoint1 Process1() {
		return ProcessServices.Process1(idEndpoint1);
	}

//    @RequestMapping("/getAll")
//    public List<EpConfiguration> getAllEndpoints(){
//        List<EpConfiguration> getAll = EpConfigurationRepository.findAll();
//        return getAll;
//    }

	@Value("${endpoint2}")
	private Integer process2;

	@PostMapping("/process2")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Integer Process2() {
		return process2;
	}

	@Value("${endpoint3}")
	private Integer process3;

	@PostMapping("/process3")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Integer Process3() {
		return process3;
	}

	@Value("${endpoint4}")
	private Integer process4;

	@GetMapping("/process4")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Integer Process4() {
		return process4;
	}

	@Value("${endpoint5}")
	private Integer process5;

	@PostMapping("/process5")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Integer Process5() {
		return process5;
	}

	@Value("${endpoint6}")
	private Integer process6;

	@PostMapping("/process6")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String Process6() {
		return ProcessServices.Process6(process6);
	}
}
