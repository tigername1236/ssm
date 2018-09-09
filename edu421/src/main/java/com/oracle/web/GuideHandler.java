package com.oracle.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.service.CommonService;
@Controller
public class GuideHandler {

	@Autowired
	CommonService commonService;

	@RequestMapping(value="/getGuide/{type}/{guideid}",produces="text/html;charset=UTF-8")
	@ResponseBody
    public String getSubject(@PathVariable("type") Integer type,@PathVariable("guideid") Integer guideid) {
		
		String str=commonService.getGuide(type,guideid);

		return str;
	}
}
