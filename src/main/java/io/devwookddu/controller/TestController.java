package io.devwookddu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.devwookddu.model.Test;
import io.devwookddu.service.TestService;
import io.devwookddu.util.JsonToClassConverter;

@Controller
@CrossOrigin(origins="*")
@RequestMapping("/test")
public class TestController {
	
	private static final Logger log = Logger.getLogger(TestController.class);
	
	@Inject
	TestService testService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseBody
	public Object get(
			@RequestParam(value="name", required=false) String name){
		Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		
		inputMap.put("name", name);
		returnMap.put("tests", testService.select(inputMap));
		returnMap.put("status", Boolean.TRUE);
		
		return returnMap;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST, headers = {"content-type=application/json"})
	@ResponseBody
	public Object post(
			@RequestBody Map<String, Object> requestBody){
		Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> testList = (ArrayList<Map<String, Object>>) requestBody.get("tests");
		try{
			returnMap.put("status", Boolean.TRUE);
			returnMap.put("number_of_result", testService.insert(JsonToClassConverter.convert(testList, Test.class)));
		}catch(Exception e){
			e.printStackTrace();
			returnMap.put("status", Boolean.FALSE);
			returnMap.put("msg", e.getMessage());
		}
		return returnMap;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT, headers = {"content-type=application/json"})
	@ResponseBody
	public Object put(
			@RequestBody Map<String, Object> requestBody){
		Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> testList = (ArrayList<Map<String, Object>>) requestBody.get("tests");
		try{
			returnMap.put("status", Boolean.TRUE);
			returnMap.put("number_of_result", testService.update(JsonToClassConverter.convert(testList, Test.class)));
		}catch(Exception e){
			e.printStackTrace();
			returnMap.put("status", Boolean.FALSE);
			returnMap.put("msg", e.getMessage());
		}
		return returnMap;
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE, headers = {"content-type=application/json"})
	@ResponseBody
	public Object delete(
			@RequestBody Map<String, Object> requestBody){
		Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> testList = (ArrayList<Map<String, Object>>) requestBody.get("tests");
		try{
			returnMap.put("status", Boolean.TRUE);
			returnMap.put("number_of_result", testService.delete(JsonToClassConverter.convert(testList, Test.class)));
		}catch(Exception e){
			e.printStackTrace();
			returnMap.put("status", Boolean.FALSE);
			returnMap.put("msg", e.getMessage());
		}
		return returnMap;
	}
	
}
