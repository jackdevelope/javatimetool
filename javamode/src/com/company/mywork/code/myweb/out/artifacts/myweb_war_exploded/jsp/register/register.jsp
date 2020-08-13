<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/5
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>myRegister</title>
</head>
<body>

<form>
    <table width="564" border="0" align="center">
        <tr>
            <th colspan="5" align="center" valign="middle" scope="col">My Rregister</th>
        </tr>
        <tr>
            <td width="167" align="right" valign="middle">username:</td>
            <td colspan="4" align="left" valign="middle"><input id="user" name="username" type="text"></td>
        </tr>
        <tr>
            <td align="right" valign="middle">password:</td>
            <td colspan="4" align="left" valign="middle"><input id="pass" name="password" type="password"></td>
        </tr>
        <tr>
            <td align="right" valign="middle">sex:</td>
            <td width="35" align="left" valign="middle">boy:</td>
            <td width="26" align="left" valign="middle"><input id="boy" name="boy" type="radio" value="boy"></td>
            <td width="36" align="left" valign="middle">girl:</td>
            <td width="306" align="left" valign="middle"><input id="girl" name="girl" type="radio" value="girl"></td>
        </tr>
        <tr>
            <td height="26" align="right" valign="middle">education background:</td>
            <td colspan="4" align="left" valign="middle"><input id="educationback" name="educationback" type="text"></td>
        </tr>
        <tr>
            <td height="26" align="right" valign="middle">Own Introduction:</td>
            <td colspan="4" align="left" valign="middle"><textarea id="intro" name="intro" cols="44" rows=""></textarea></td>
        </tr>
        <tr>
            <td height="26" align="right" valign="middle"><input name="submit" type="submit" onclick="mylog()"></td>
            <td colspan="4" align="center" valign="middle"><input name="reset" type="reset"></td>
        </tr>
    </table>
</form>
<script type="application/javascript">
    function mylog() {
        var admin='admin';
        var username=document.getElementById("user").value;
        var password=document.getElementById("pass").value;
        console.log(username,password)
        if (username==admin){
            alert(document.getElementById("educationback").value);
        } else {
            alert("注册失败!!!!!");
        }
    }
</script>
</body>
</html>
