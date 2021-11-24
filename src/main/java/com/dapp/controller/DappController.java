package com.dapp.controller;

import com.dapp.entities.EpConfiguration;
import com.dapp.entities.EpExecutionLog;
import com.dapp.entities.Response;

import com.dapp.entities.endpoint2.endpoint2request;

import com.dapp.entities.endpoint5.endpoint5request;
import com.dapp.services.EpConfigurationService;
import com.dapp.services.EpExecutionLogServices;
import com.dapp.services.EpExecutionServices;
import com.dapp.services.ProcessService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
	ProcessService ProcessService;

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
	public Response Process1(@RequestHeader(value = "idBaseDeDatos") int idBaseDeDatos) {
		return new Response(1, "Process 1", ProcessService.Process1(idEndpoint1,idBaseDeDatos));
	}

//	private endpoint2request endpoint2request;

	@PostMapping("/process2")
	public Response Process2(@RequestBody endpoint2request endpoint2request,
			@RequestHeader(value = "idBaseDeDatos") int idBaseDeDatos) {
//		System.out.println(endpoint2request.toString());
		return new Response(2, "Process 2", ProcessService.Process2(idEndpoint1, endpoint2request, idBaseDeDatos));
	}

	@GetMapping("/process3/{id}")
	public Response Process3(@PathVariable("id") String id, @RequestHeader(value = "idBaseDeDatos") int idBaseDeDatos) {
		return new Response(3, "Process 3", ProcessService.Process3(id, idEndpoint1, idBaseDeDatos));
	}

	@Value("${endpoint4}")
	private Integer idEndpoint4;

	@PostMapping("/process4/{id}")
	public Response Process4(@PathVariable("id") String ticket_id,
			@RequestHeader(value = "idBaseDeDatos") int idBaseDeDatos) {
		return new Response(4, "Process 4", ProcessService.Process4(ticket_id, idEndpoint4, idBaseDeDatos));
	}

	@PostMapping("/process5/{id}/{payment_id}")
	public Response Process5(@PathVariable("id") String ticket_id, @PathVariable("payment_id") String payment_id,
			@RequestBody endpoint5request endpoint5request, @RequestHeader(value = "idBaseDeDatos") int idBaseDeDatos) {
		return new Response(5, "Process 5",
				ProcessService.Process5(ticket_id, payment_id, idEndpoint4, endpoint5request, idBaseDeDatos));
	}

	@GetMapping("/isok/{id}")
	public EpExecutionLog isTodoOk(@PathVariable("id") int idBaseDedatos) {
		return ProcessService.istodook(idBaseDedatos);
	}
}
