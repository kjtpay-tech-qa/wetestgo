<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,java.io.*,java.sql.*,javax.sql.*,javax.naming.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("vEnter", "\n");
request.setAttribute("vLessThan", "<");
request.setAttribute("vGreaterThan", ">");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>执行结果详情</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is test page">
	
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/test_result.js" charset="utf-8"></script>
	
	<link rel="stylesheet" type="text/css" href="css/inner.css" />
	<link rel="icon" href="favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
	
  </head>
  <body>
 	<div class="main">
  <!--   <h4>测试结果详情</h4>
    
    <span style="color: red;">注:....</span> -->

	<div class="recodeTable">
		<div class="content-box"></div>
		<table class="recordThead">
		</table>
		<table class="bordered">
			<thead>
				<tr>
					<th id="testSuiteId">testSuiteId</th>
					<th id="caseDescription">用例描述</th>
					<th id="inputParams">接口入参</th>
					<th id="baselineParams">预期返回</th>
					<th id="outputParams">实际返回</th>
					<th id="caseResult">执行结果</th>
					<th id="gmtUpdate">测试时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="cs">
					<tr>
						<td id="testSuiteId">${cs.testSuiteId}</td>
						<td id="caseDescription">${cs.caseDescription}</td>
						<td id="inputParams">${fn:replace(cs.inputParams,vEnter,"<BR />")}</td>
						<td id="baselineParams">
							${fn:replace(fn:replace(fn:replace(cs.baselineParams,vLessThan,"&lt;"),vGreaterThan,"&gt;"),vEnter,"<BR />")}
						</td>
						<td id="outputParams">
							${fn:replace(fn:replace(fn:replace(cs.outputParams,vLessThan,"&lt;"),vGreaterThan,"&gt;"),vEnter,"<BR />")}
						</td>
						<td id="caseResult">${cs.caseResult}</td>
						<td id="gmtUpdate"><fmt:formatDate value="${cs.gmtUpdate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="foot"></div>
	</div>
		<div><img src="img/fire.png" align="middle" class="fire">
    </div>
</body>
</html>