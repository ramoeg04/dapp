/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.repositorys;

import com.dapp.entities.EpExecution;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Geomar Salas
 */
public interface EpExecutionRepository extends JpaRepository<EpExecution, Serializable> {
    
}