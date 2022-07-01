<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>



<p>登录界面</p>
<form action="login" method="post">
    账号：<input type="text" name="id" required> <br/>
    密码：<input type="password" name="password" required> <br/>
    <input type="submit" value="登录">
</form>

<form action="resgiter.jsp" method="post">
    <input type="submit" value="注册">
</form>


</body>
</html>
