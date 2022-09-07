<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
//セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガチャシミュレーター</title>
</head>
<body>
<% if(loginUser != null) { %>
	<p>ログインに成功しました</p>
	<p>ようこそ<%= loginUser.getName() %>さん</p>
	<a href="/gacha/Main">ガチャ結果一覧へ</a>
<% } else { %>
	<p>ログインに失敗しました</p>
	<a href="/gacha/">TOPへ</a>
<% } %>

</body>
</html>