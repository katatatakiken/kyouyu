<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせフォーム</title>
</head>
<body>
<h2>お問い合わせフォーム</h2>
<form action="/example/testenq" method="post">

<select name="type">
<option value=""></option>
<option value="company">会社について</option>
<option value="product">製品について</option>
<option value="support">アフターサポートについて</option>

</select><br><br>

<textarea name="text"></textarea><br><br>
<input type="submit">
</form>
</body>
</html>