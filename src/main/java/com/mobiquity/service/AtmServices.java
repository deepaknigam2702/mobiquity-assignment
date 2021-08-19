package com.mobiquity.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.model.Atm;
import com.mobiquity.utility.AtmUtility;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AtmServices implements IAtmServices {

	@SuppressWarnings("unchecked")
	@Override
	public List<Atm> findAll() {
		ObjectMapper mapper = new ObjectMapper();
		List<Atm> atmList = null;
		try {
			atmList = (List<Atm>) mapper.readValue(AtmUtility.loadAtmDataFromFile(), new TypeReference<List<Atm>>(){});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return atmList;
	}
	
	@Override
	public List<Atm> findAtmsByCity(String city) {
		List<Atm> allAtms = findAll();
	    return allAtms.stream()
	    		      .filter(e -> e.getAddress().getCity().equalsIgnoreCase(city))
	    		      .collect(Collectors.toList());
	}
}