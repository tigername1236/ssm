package com.oracle.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.service.CommonService;

@Controller
public class TeacherHandler {
 
	@Autowired
	CommonService commonService;

	@RequestMapping(value="/getTeacher/{type}/{teacherId}",produces="text/html;charset=UTF-8")
	@ResponseBody
    public String getSubject(@PathVariable("type") Integer type,@PathVariable("teacherId") Integer teacherId) {
		
		String str=commonService.getTeacher(type, teacherId);

		return str;
	}
}
