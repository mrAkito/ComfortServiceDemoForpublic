package com.example.app.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Weather {
	private int id;
	private int temp;
	private int humid;
	private int pressure;
	private int comfort;
	private boolean deal_flg;
	private boolean del_flg;
	private Timestamp date;
}