<%--
  Created by IntelliJ IDEA.
  User: libin1
  Date: 2018/2/11
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <style type="text/css">
        * { font-family: "微软雅黑"; }
        .textField { border:none; border-bottom: 1px solid gray; text-align: center; }
        #file { border:1px solid black; width: 80%; margin:0 auto; }
        h1 input{ font-size:72px; }
        td textarea { font-size: 14px; }
        .key { width:125px; font-size:20px; }
    </style>
</head>
<body>
<form action="/reportWord" method="post" enctype="multipart/form-data">
    <div id="file" align="center">
        <h1><input type="text" name="title" class="textField" value="测试word导出"/></h1>
        <hr/>
        <table>
            <tr>
                <td colspan="4">
                    <input type="file" name="image" />
                </td>
            </tr>
        </table>
    </div>
    <div align="center" style="margin-top:15px;">
        <input type="submit" value="保存Word文档" />
    </div>
</form>
</body>
</html>
