<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<body>
<form name="f1" method="get" action="enter_data.php">
    <input name="link" type="hidden" value="index.php" />
    Логин: <br />
    <input name="login" type="text" size="25" maxlength="30" value="" /> <br />
    Пароль: <br />
    <input name="pd" type="password" size="25" maxlength="30" value="" /> <br />
    <input name="remember" type="checkbox" value="yes" /> Запомнить <br />
    <input type="submit" name="enter" value="Вход" />
</form>
</body>
</html>