<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="Dowrite">
		<table border="1">
			
    	<tr><td algin=right>제목</td> <td><input type="text" id="bTitle" name="bTitle"></td></tr>
    	<tr><td algin=right>작성자</td> <td><input type="text" id="bName" name="bName"></td></tr>
    	<tr><td algin=right>내용</td><td><textarea id="bContent" name="bContent"></textarea></td></tr>
    	<tr><td><a href="list">list</a></td></tr>
    	<tr><td><input type="submit" onclick = "invalid()" value="완료"></td></tr>
		
		
		
		
		</table>
	
	
	
	</form>

</body>
</html>
<script type="text/javascript">
function invalid()
{
	var title = document.getElementById("bTitle");
	var name = document.getElementById("bName");
	var content = document.getElementById("bContent");
	if(title == "")
	{
		alert("제목을 입력해주세요.");
		return false;
	}
	if(name == "")
	{
		alert("이름을 입력해주세요.");
		return false;
	}
	if(content =="")
	{
		alert("내용을 입력해주세요.");
		return false;
	}
	
	
}



</script>