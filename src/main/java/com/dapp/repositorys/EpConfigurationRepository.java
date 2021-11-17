/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.repositorys;

import com.dapp.entities.EpConfiguration;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Geomar Salas
 */
@Repository
public interface EpConfigurationRepository extends JpaRepository<EpConfiguration, Serializable> {
    
}
