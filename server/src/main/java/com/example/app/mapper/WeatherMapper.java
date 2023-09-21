package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.entity.Weather;

@Mapper
public interface WeatherMapper {
	public List<Weather> selectAll();
	
	public void updateNoView(Weather weather);
}