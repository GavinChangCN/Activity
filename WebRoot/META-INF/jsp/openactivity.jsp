<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String planId=request.getParameter("planId"); %><!--获取传的m_userName值 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'openactivity.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="css/shengju.css">
    <script type="text/javascript" src="js/openactivity.js"></script>

  </head>
  
  <body>
      <div style="background-color:white;width:100%;height:100%;border:2px solid #ADD8E6;overflow:auto;">
		    <div id="fsb">活动内容</div>
		    <hr style="color:#ADD8E6"/>
	        <div id="fg">
	          <label>计划编号:</label>
	          <input id="m_planId" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg">
	          <label>创建者编号:</label>
	          <input id="m_createId" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg">
	          <label>活动名称:</label>
	          <input id="m_planName" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg">
	          <label>活动目的:</label>
	          <input id="m_planGoal" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg">
	          <label>活动计划内容:</label>
	          <input id="m_planContent" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg" >
	          <label>地&nbsp;&nbsp;&nbsp;&nbsp;址:</label>
	          <input id="m_address" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg">
	          <label>预算:</label>
	          <input id="m_planBudget" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg" >
	          <label>发布者编号:</label>
	          <input id="m_publishId" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg" >
	          <label>创建时间:</label>
	          <input id="m_createDate" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg" >
	          <label>发布状态:</label>
	          <input id="m_planType" type="text" disabled="disabled"/>
	        </div>
	        <div id="fg">
	          <label>所属层编号:</label>
	          <input id="m_secId" type="text" disabled="disabled"/>
	        </div>
	        <a id="submit" style="margin-left:50px;margin-top:250px;"></a>
	        <div id="xiasu"></div>
	        <div style="margin-top:200px;margin-left:800px">
	            <input type="button" value="发布" onclick="submit()"/>
	        </div>
        </div>
  </body>
</html>