package com.sigma.june25.dao;

import java.util.List;

import com.sigma.june25.model.City;

public interface CitiesDAO {
	public List<City> getAllCities();
	public boolean DeleteCity(int k);
	public boolean AddCity(int i,String fn,String ln);
	public boolean UpdateStudent(int h,String f,String l);
}
