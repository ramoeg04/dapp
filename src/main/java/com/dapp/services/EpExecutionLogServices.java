/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.services;

import com.dapp.entities.EpExecution;
import com.dapp.entities.EpExecutionLog;
import com.dapp.repositorys.EpExecutionLogRepository;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Geomar Salas
 */
@Service
public class EpExecutionLogServices {
	@Autowired
	public EpExecutionLogRepository EpExecutionLogRepository;

	public EpExecutionLog save(EpExecutionLog saveData) {
		EpExecutionLog save = EpExecutionLogRepository.save(saveData);
		return save;
	}
	
	public EpExecutionLog proceesSave(
			 int epExecutionLogId,
			 String typeProcess,
		     String descriptionProcess,
		     String status,
		     Date reccreated,
		     Date recupdated,
		     Collection<EpExecution> epExecutionCollection) {
		EpExecutionLog dataOutput=null;
		if (epExecutionLogId!=0) {
			dataOutput.setEpExecutionLogId(epExecutionLogId);
		}
		if (typeProcess.isEmpty()) {
			
		}
		
		
		
		
		return dataOutput;
		
		
	}

}
