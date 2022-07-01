<%--
  Created by IntelliJ IDEA.
  User: 祁建邵
  Date: 2022/6/30
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息展示</title>
</head>
<body>

<form>
    <%--<input type="submit" value="Post请求方式处理HelloServlet">--%>
    <jsp:useBean id="student" scope="session" class="domain.Student"/>
    <table>
        <>
        <td>姓名：</td>
        <td><jsp:getProperty name="student" property="name" /></td></br>
        <td>密码：</td>
        <td><jsp:getProperty name="student" property="password" /></td></br>
        </tr>
    </table>
</form>




</body>
</html>
