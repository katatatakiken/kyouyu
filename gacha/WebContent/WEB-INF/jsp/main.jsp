<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Gacha,java.util.List" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<Gacha> gachaList = (List<Gacha>) application.getAttribute("gachaList");
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガチャシミュレーター</title>
</head>
<body>
<h1>ガチャシミュレーター</h1>
<p>
<%= loginUser.getName()  %>さん、ログイン中
<a href="/gacha/Logout">ログアウト</a>
</p>
<p><a href="/gacha/Main">更新</a></p>
<form action="/gacha/Main" method="post">

<input type="submit" name="gacharu" value="10連ガチャる">
</form>

<form action="/gacha/Main" method="post">

<input type="submit" name="derumade" value="SSRが出るまでガチャる">
</form>
<% if(errorMsg != null) { %>
<p><%= errorMsg %></p>
<% } %>
<% for(Gacha gacha : gachaList) { %>
	<p><%= gacha.getUserName()  %>:<%= gacha.getGacha() %></p>
<% } %>

</body>
</html>