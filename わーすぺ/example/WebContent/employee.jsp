
    <%@ page contentType="text/html;charset=UTF-8" import="model.Employee" %>
    <% Employee emp= new Employee("0001","湊 雄輔"); %>
<!DOCTYPE html>
<html>
<head>

<title>IDと名前</title>
</head>
<body>
<p>
IDは<%= emp.getId() %>、名前は<%= emp.getName() %>です
</p>
</body>
</html>