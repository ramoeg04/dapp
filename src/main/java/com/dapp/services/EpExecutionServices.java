/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.services;

import com.dapp.entities.EpExecution;
import com.dapp.repositorys.EpExecutionRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Geomar Salas
 */
@Service
public class EpExecutionServices {
    public EpExecutionRepository EpExecutionRepository; 
	
	public EpExecution save(EpExecution saveData) {
		EpExecution save = EpExecutionRepository.save(saveData);
		return save;
	}
}
