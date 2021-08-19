package com.mobiquity.service;

import java.util.List;

import com.mobiquity.model.Atm;

public interface IAtmServices {
	
    List<Atm> findAll();
    
    List<Atm> findAtmsByCity(String city);

}