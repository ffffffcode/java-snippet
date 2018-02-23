<%--
  Created by IntelliJ IDEA.
  User: AaronFae
  Date: 2018/2/23
  Time: 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>captcha</title>
</head>
<body>
<form action="login" method="post">
    <input type="text" name="verifyCode"><input type="submit">
    <img id="captcha" src="captcha">
    <a href="javascript:reloadCaptcha()">看不清，换一个</a>
</form>
${msg}
</body>
<script>
    function reloadCaptcha() {
        var time = new Date().getTime();
        document.getElementById("captcha").src = "captcha?d=" + time;
    }
</script>
</html>
