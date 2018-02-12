<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page language="java"
         import="java.util.*,java.io.*,java.sql.*,javax.sql.*,javax.naming.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">

    <title>测试结果预览</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is test page">

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/test_result.js" charset="utf-8"></script>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/inner.css"/>
    <link rel="icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon"/>

</head>
<body>
<div class="main">
    <!-- 		<h4>测试结果详情</h4>

            <span style="color: red;">注:....</span> -->

    <div class="recodeTable">
        <div class="content-box"></div>
        <table class="recordThead">
        </table>
        <table class="bordered">
            <thead>
            <tr>
                <th id="testId">testId</th>
                <th id="serviceName">被测服务</th>
                <th id="interfaceName">接口名称</th>
                <th id="environment">测试环境</th>
                <th id="suiteResult">测试结果</th>
                <!-- <th id="passedCases">通过的用例数</th>
            <th id="executedCases">已执行的用例数</th>
            <th id="totalCases">总用例数</th> -->
                <th id="testPurpose">测试目的</th>
                <th id="operator">测试人</th>
                <th id="passedRate">通过率</th>
                <th id="gmtCreate">开始时间</th>
                <th id="gmtUpdate">结束时间</th>
                <th id="suiteOperation">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="cs">
                <tr>
                    <td id="testId">${cs.testId}</td>
                    <td id="serviceName">${cs.serviceName}</td>
                    <td id="interfaceName">${cs.interfaceName}</td>
                    <c:choose>
                        <c:when test="${cs.environment.equalsIgnoreCase('zsc')}">
                            <td id="environment">准生产</td>
                        </c:when>
                        <c:when test="${cs.environment.equalsIgnoreCase('cs1')}">
                            <td id="environment">测试1</td>
                        </c:when>
                        <c:when test="${cs.environment.equalsIgnoreCase('cs2')}">
                            <td id="environment">测试2</td>
                        </c:when>
                        <c:when test="${cs.environment.equalsIgnoreCase('sc')}">
                            <td id="environment">生产</td>
                        </c:when>
                        <c:otherwise>
                            <td id="environment">null</td>
                        </c:otherwise>
                    </c:choose>

                    <td id="suiteResult">${cs.suiteResult}</td>
                    <td id="testPurpose">${cs.testPurpose}</td>
                    <td id="operator">${cs.operator}</td>
                    <td id="passedRate">${cs.passedRate}</td>
                    <td id="gmtCreate"><fmt:formatDate value="${cs.gmtCreate}"
                                                       pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td id="gmtUpdate"><fmt:formatDate value="${cs.gmtUpdate}"
                                                       pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td id="suiteOperation"><a style="background-color: yellow"
                                               onclick="viewSuiteResult(${cs.testSuiteId});">查看详细</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="foot"></div>
</div>
<div>
    <img src="<%=request.getContextPath()%>/img/fire.png" align="middle" class="fire">
</div>
</body>
</html>