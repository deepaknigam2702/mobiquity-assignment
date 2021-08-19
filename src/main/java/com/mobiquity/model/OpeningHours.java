package com.mobiquity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpeningHours {
	private Integer dayOfWeek;
    private List<Hours> hours;
    
    public OpeningHours() {
	}
    
	public OpeningHours(Integer dayOfWeek, List<Hours> hours) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.hours = hours;
	}

	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<Hours> getHours() {
		return hours;
	}

	public void setHours(List<Hours> hours) {
		this.hours = hours;
	}
}