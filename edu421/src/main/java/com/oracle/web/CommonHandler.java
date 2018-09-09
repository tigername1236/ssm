package com.oracle.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.service.CommonService;



@Controller
public class CommonHandler {
     
	@Autowired
	CommonService commonService;
	
	@RequestMapping(value="/getState/{type}/{stateId}",produces="text/html;charset=UTF-8")
	@ResponseBody
    public String getSubject(@PathVariable("type") Integer type,@PathVariable("stateId") Integer stateId) {
		
		String str=commonService.getState(type, stateId);
		return str;
	}
}
