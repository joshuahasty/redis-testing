package com.makehaste.objectcache.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@RedisHash("units")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Unit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private @Id String unitName;
	private String location;

	public Unit() {

	}

	@JsonCreator
	public Unit(
			@JsonProperty("unitName") String unitName,
			@JsonProperty("location") String location) {

		this.unitName = unitName;
		this.location = location;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Unit: " + this.unitName + ", Location: " + this.location;
	}
}
