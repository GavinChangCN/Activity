package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Factory.BllFacadeFactory;
import com.Interface.BllInterface;

@SuppressWarnings("serial")
public class ServletAddActplan extends HttpServlet{
	
	private BllFacadeFactory bllFactory =  BllFacadeFactory.getbBllFactoryInstance();
	private BllInterface bllInterface = bllFactory.getInterface();
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int m_createId = Integer.parseInt(request.getParameter("m_createId"));  //创建者ID，即省局ID m_userId
		String m_planName = new String(request.getParameter("m_planName").getBytes("ISO-8859-1"),"utf-8");		//活动名称
		String m_planGoal = new String(request.getParameter("m_planGoal").getBytes("ISO-8859-1"),"utf-8");		//活动目的
		String m_planContent = new String(request.getParameter("m_planContent").getBytes("ISO-8859-1"),"utf-8");//活动计划内容
		String m_address = new String(request.getParameter("m_address").getBytes("ISO-8859-1"),"utf-8");		//地址
		double m_planBudget = Double.parseDouble(request.getParameter("m_planBudget")); //预算
		int m_publishId = Integer.parseInt(request.getParameter("m_publishId"));		//发布者编号，获取帐号ID m_userId
		
		Date m_createDate = new Date();											//创建时间
		
		int m_planType = Integer.parseInt(request.getParameter("m_planType"));  //发布状态 0：未发布 1：已发布 2：已结束
		int m_planMold = Integer.parseInt(request.getParameter("m_planMold"));  //活动类型 0：普通活动 1：走访活动
		int m_secId = Integer.parseInt(request.getParameter("m_secId"));		//阶层编号，获取帐号的阶层编号
		
		String m_receiveAbleId = new String(request.getParameter("m_receive").getBytes("ISO-8859-1"),"utf-8");  //能接单的单位m_secId
		String[] s = m_receiveAbleId.split(",");
		int[] m_receive = new int[s.length];
		for(int i=0;i<s.length;i++){
			m_receive[i] = Integer.valueOf(s[i]).intValue();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = bllInterface.CreateActplan(m_createId, m_planName, m_planGoal, m_planContent, m_address,
				m_planBudget, m_publishId, m_createDate, m_planType, m_planMold, m_secId,m_receive);
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(map);
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.close();
		
	}
}
