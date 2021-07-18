<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빌드테스트</title>
</head>
<body>

<h1>Builder Test</h1>
<hr>
<b>BuildVO A : (build 활용) <br></b>
 BuilderVO.builder()
							.id("아이디")
							//.name(미입력_기본값)
							.age(10)
							.item(Arrays.asList("AA","BB"))<br>
							.singularItem("test1")<br>
							.singularItem("test2")<br>
							.singularItem(Arrays.asList("testA","testB"))<br>
							.singularItem(Arrays.asList("testC","testD"))<br>
							.build();<br>
							//collection<\String> 형태로 넣으려면, Arrays.asList()를 활용하여야한다.<br>
결과:<br>
<p style="color: red; font-weight: bold;">${buildA }</p><hr>
<b>BuildVO B : (tobuild 활용) <br></b>
BuilderVO b = <b>a.toBuilder()</b>.id("아메리카노").age(35).build();
<br>
결과:<br>
<p style="color: red; font-weight: bold;">${buildB }</p>


</body>
</html>