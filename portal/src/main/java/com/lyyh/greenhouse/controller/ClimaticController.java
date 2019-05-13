package com.lyyh.greenhouse.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyyh.greenhouse.pojo.Climatic;
import com.lyyh.greenhouse.pojo.User;
import com.lyyh.greenhouse.pojo.vo.ClimaticVo;
import com.lyyh.greenhouse.service.ClimaticService;

@Controller
@RequestMapping(value="/climatic")
public class ClimaticController {

	@Autowired
	private ClimaticService climaticService;

	public ClimaticVo getClimaticVo(HttpSession session,Date start,Date end){
		User user = (User) session.getAttribute("loginUser");
		String zoneName = user.getZoneName();
		ClimaticVo climaticVo = new ClimaticVo(zoneName, start, end);
		return climaticVo;
	}
	
	/*
	 * 天气信息首页,
	 * /climaticData/listAll.do
	 */
	@RequestMapping("/listAll.do")
	public String listAll(Model model,HttpSession session){
		User user = (User) session.getAttribute("loginUser");
		String zoneName = user.getZoneName();
		//获取最新天气信息
		Climatic climatic =climaticService.getNewest(zoneName);
		model.addAttribute("climatic",climatic);
		return "climatic/list";
	}
	@RequestMapping("/historylist.do")
	public String historylist(){
		
		return "climatic/historyList";
	}
	
	/*
	 * 气温
	 */
	@RequestMapping(value="/getTemperatureList.do")
	public @ResponseBody List<Object[]> getTemperatureList(HttpSession session,Date start,Date end){
		ClimaticVo climaticVo = getClimaticVo(session, start, end);
		List<Object[]> temperatures = climaticService.getTemperatureList(climaticVo);
		return temperatures;
	}
	/*
	 * 湿度
	 */
	@RequestMapping(value="/getHumidityList.do")
	public @ResponseBody List<Object[]> getHumidityList(HttpSession session,Date start,Date end){
		ClimaticVo climaticVo = getClimaticVo(session, start, end);
		List<Object[]> humiditys = climaticService.getHumidityList(climaticVo);
		return humiditys;
	}
	/*
	 * 光照
	 */
	@RequestMapping(value="/getLightingList.do")
	public @ResponseBody List<Object[]> getLightingList(HttpSession session,Date start,Date end){
		ClimaticVo climaticVo = getClimaticVo(session, start, end);
		List<Object[]> lightings = climaticService.getLightingList(climaticVo);
		return lightings;
	}
	/*
	 * 气压
	 */
	@RequestMapping(value="/getPressureList.do")
	public @ResponseBody List<Object[]> getPressureList(HttpSession session,Date start,Date end){
		ClimaticVo climaticVo = getClimaticVo(session, start, end);
		List<Object[]> pressures = climaticService.getPressureList(climaticVo);
		return pressures;
	}
	/*
	 * 风速
	 */
	@RequestMapping(value="/getWindSpeedList.do")
	public @ResponseBody List<Object[]> getWindSpeedList(HttpSession session,Date start,Date end){
		ClimaticVo climaticVo = getClimaticVo(session, start, end);
		List<Object[]> windSpeeds = climaticService.getWindSpeedList(climaticVo);
		return windSpeeds;
	}
	/*
	 * 降雨量
	 */
	@RequestMapping(value="/getRainFallList.do")
	public @ResponseBody List<Object[]> getRainFallList(HttpSession session,Date start,Date end){
		ClimaticVo climaticVo = getClimaticVo(session, start, end);
		List<Object[]> rainFalls = climaticService.getRainFallList(climaticVo);
		return rainFalls;
	}
	/*
	 * PH
	 */
	@RequestMapping(value="/getPHList.do")
	public @ResponseBody List<Object[]> getPHList(HttpSession session,Date start,Date end){
		ClimaticVo climaticVo = getClimaticVo(session, start, end);
		List<Object[]> phs = climaticService.getPHList(climaticVo);
		return phs;
	}
	/*
	 * PM2.5
	 */
	@RequestMapping(value="/getPM25List.do")
	public @ResponseBody List<Object[]> getPM25List(HttpSession session,Date start,Date end){
		ClimaticVo climaticVo = getClimaticVo(session, start, end);
		List<Object[]> pm25s = climaticService.getPM25List(climaticVo);
		return pm25s;
	}
	
	
}
