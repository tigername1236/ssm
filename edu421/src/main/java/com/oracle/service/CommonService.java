package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.dao.TbClassMapper;
import com.oracle.dao.TbGuideMapper;
import com.oracle.dao.TbStateMapper;
import com.oracle.dao.TbTeacherMapper;
import com.oracle.vo.TbGuide;
import com.oracle.vo.TbGuideExample;
import com.oracle.vo.TbState;
import com.oracle.vo.TbStateExample;
import com.oracle.vo.TbTeacher;
import com.oracle.vo.TbTeacherExample;

@Service
public class CommonService {
    
	@Autowired
	TbGuideMapper guidedao;
	@Autowired
	TbStateMapper statedao;
	@Autowired
	TbTeacherMapper teacherdao;
	@Transactional(readOnly=true)
	public String getState(Integer type,Integer stateId) {
		TbStateExample e=new TbStateExample(); 
		e.createCriteria().andTypeEqualTo(type);
		e.setOrderByClause("stateName");
		List<TbState> list=statedao.selectByExample(e);
		//组装字符串<option value='stateid' selected>stateName</option>
		StringBuffer sb=new StringBuffer();
		for(TbState s:list) {
			if(s.getStateid().equals(stateId)){
			sb.append("<option value="+s.getStateid()+"selected>").append(s.getStatename()).append("</option>");	
			}else{
				sb.append("<option value="+s.getStateid()+" >").append(s.getStatename()).append("</option>");	
			} 
		}
		return sb.toString();
	}
	@Transactional(readOnly=true)
	public String getTeacher(Integer type,Integer teacherId) {
		 TbTeacherExample  t=new TbTeacherExample();
		 t.createCriteria().andTeachertypeidEqualTo(type);
		 t.setOrderByClause("name");
		List<TbTeacher> list=teacherdao.selectByExample(t);
		StringBuffer sb=new StringBuffer();
		for(TbTeacher s:list) {
			if(s.getTeacherid().equals(teacherId)){
			sb.append("<option value="+s.getTeacherid()+"selected>").append(s.getName()).append("</option>");	
			}else{
				sb.append("<option value="+s.getTeacherid()+" >").append(s.getName()).append("</option>");	
			} 
		}
		return sb.toString();
	}
	@Transactional(readOnly=true)
	public String getGuide(Integer type,Integer guideId) {
		 TbGuideExample  t=new TbGuideExample();
		 t.createCriteria().andTypeEqualTo(type);
		 t.setOrderByClause("name");
		List<TbGuide> list=guidedao.selectByExample(t);
		StringBuffer sb=new StringBuffer();
		for(TbGuide g:list) {
			if(g.getGuideid().equals(guideId)){
			sb.append("<option value="+g.getGuideid()+"selected>").append(g.getName()).append("</option>");	
			}else{
				sb.append("<option value="+g.getGuideid()+" >").append(g.getName()).append("</option>");	
			} 
		}
		return sb.toString();
	}
	
}
