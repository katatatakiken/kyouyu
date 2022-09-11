<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
    <%
    String[] luckArray = {"超スッキリ","スッキリ","最悪"};

    int index = (int) (Math.random() * 3);
    String luck = luckArray[index];

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String today = sdf.format(date);


    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%= today %>の運勢は<%= luck %>です</p>

</body>
</html>