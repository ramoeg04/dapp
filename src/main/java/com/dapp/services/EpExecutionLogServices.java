/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.services;

import com.dapp.entities.EpExecutionLog;
import com.dapp.repositorys.EpExecutionLogRepository;
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

}
