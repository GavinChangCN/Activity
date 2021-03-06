package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Factory.BllFacadeFactory;
import com.Interface.BllInterface;
import com.Vo.Accessory;

@SuppressWarnings("serial")
public class ServletUpdateAccessory extends HttpServlet{
	private BllFacadeFactory bllFactory = BllFacadeFactory.getbBllFactoryInstance();
	private BllInterface bllInterface = bllFactory.getInterface();
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Accessory accessory = new Accessory();
		
		accessory.setM_accId(Integer.getInteger(request.getParameter("m_accId")));
		accessory.setM_accImage(new String(request.getParameter("m_accImage").getBytes("ISO-8859-1"),"utf-8"));
		accessory.setM_accDescribe(new String(request.getParameter("m_accDescribe").getBytes("ISO-8859-1"),"utf-8"));
		accessory.setM_accAddress(new String(request.getParameter("m_accAddress").getBytes("ISO-8859-1"),"utf-8"));
		accessory.setM_accContent(new String(request.getParameter("m_accContent").getBytes("ISO-8859-1"),"utf-8"));
		accessory.setM_accType(Integer.getInteger(request.getParameter("m_accType")));
		accessory.setM_createTime(new Date());
		boolean check = bllInterface.UpdateAccessory(accessory);
		JSONObject json = JSONObject.fromObject(check);
		System.out.println(check);
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.close();
	}
}
