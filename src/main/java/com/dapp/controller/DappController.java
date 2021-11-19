package com.dapp.controller;

import com.dapp.entities.EpConfiguration;
import com.dapp.entities.endpoint1.Endpoint1;
import com.dapp.entities.endpoint2.Endpoint2;
import com.dapp.entities.endpoint3.Endpoint3;
import com.dapp.entities.endpoint4.Endpoint4;
import com.dapp.entities.endpoint5.Endpoint5;
import com.dapp.entities.endpoint6.Endpoint6;
import com.dapp.services.EpConfigurationService;
import com.dapp.services.EpExecutionLogServices;
import com.dapp.services.EpExecutionServices;
import com.dapp.services.ProcessService;

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
	ProcessService ProcessServices;

	@Value("${endpoint1}")
	private Integer idEndpoint1;

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
	@GetMapping("/process1")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Endpoint1 Process1() {
		return ProcessServices.Process1(idEndpoint1);
	}

//    @RequestMapping("/getAll")
//    public List<EpConfiguration> getAllEndpoints(){
//        List<EpConfiguration> getAll = EpConfigurationRepository.findAll();
//        return getAll;
//    }

	@Value("${endpoint2}")
	private Integer idEndpoint2;

	@PostMapping("/process2")
	public Endpoint2 Process2() {
		return ProcessServices.Process2(idEndpoint2);
	}

	@Value("${endpoint3}")
	private Integer idEndpoint3;

	@PostMapping("/process3")
	public Endpoint3 Process3() {
		return ProcessServices.Process3(idEndpoint3);
	}

	@Value("${endpoint4}")
	private Integer idEndpoint4;

	@GetMapping("/process4")
	public Endpoint4 Process4() {
		return ProcessServices.Process4(idEndpoint4);
	}

	@Value("${endpoint5}")
	private Integer idEndpoint5;

	@PostMapping("/process5")
	public Endpoint5 Process5() {
		return ProcessServices.Process5(idEndpoint5);
	}

	@Value("${endpoint6}")
	private Integer idEndpoint6;

	@PostMapping("/process6")
	public Endpoint6 Process6() {
		return ProcessServices.Process6(idEndpoint6);
	}
}
