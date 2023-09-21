package com.example.app.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.entity.Weather;
import com.example.app.mapper.WeatherMapper;

@Controller
public class ServiceController {
	
	@Autowired
	WeatherMapper weatherMapper;
	
	@RequestMapping(value="/")
	public String index(Model model) {
	    // 横軸
		//横軸に日付を入れるリストを作成する
		List<String> date = new ArrayList<>();

        // 縦軸
		//気温格納用リストを作成
		List<Integer> temp = new ArrayList<>();
		//湿度格納用リストを作成
		List<Integer> humi = new ArrayList<>();
		//気圧格納用リストを作成
		List<Integer> press = new ArrayList<>();

		//SQL実行結果をリストに格納
		List<Weather> list = weatherMapper.selectAll();

		//気温、湿度、気圧リストにstreamAPIで値を追加する
		list.stream()
			.forEach(t -> {
				date.add(t.getDate().toString());
				temp.add(t.getTemp());
				humi.add(t.getHumid());
				press.add(t.getPressure());
			});

		//気温、湿度、気圧リストからstreamAPIで配列に変換する
		String[] label = date.stream()
								.toArray(String[]::new);
		int[] tempArr = temp.stream()
							.mapToInt(Integer::intValue)
							.toArray();
		int[] humiArr = humi.stream()
							.mapToInt(Integer::intValue)
							.toArray();
		int[] pressArr = press.stream()
							.mapToInt(Integer::intValue)
							.toArray();
		model.addAttribute("label",label);
		model.addAttribute("tempArr",tempArr);
		model.addAttribute("humiArr",humiArr);
		model.addAttribute("pressArr",pressArr);
		model.addAttribute("info", list);
		System.out.println(list);
		return "index";
	}

	@RequestMapping(value="/update")
	public String update(Weather weather){
		weatherMapper.updateNoView(weather);
		return "redirect:/";
	}
}