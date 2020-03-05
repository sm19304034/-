<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J" %>

<!--<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->

<html>

<head>
    <link rel="stylesheet" href="style.css">
    <title>
        掲示板作成
    </title>
</head>

<body>
	<div class="create">
		<a href="b_board.jsp" class="button">スレッド作成</a>
	</div>
    <div id="container">
        <div id="wrapper">
            <div id="header">
                <h1 align="center">
                    <img src="rogo.jpg" width="160" height="160" alt="Free Board">
                </h1>
            </div>
        </div>
        <h5 align="center">
        <table border="1" align="center">
                <tr>
					<th>id</th>
                    <th>タイトル</th>
                    <th>名前</th>
                    <th>内容</th>
					<th>投稿時間</th>
                </tr>
        <c:forEach var="list" items="${list}">
                <tr>
                    <td><a href="ResponseServlet?b_board_id=${list.b_board_id}">${list.b_board_id}</td>
                    <td>${list.b_board_title}</td>
                    <td>${list.user_name}</td>
                    <td>${list.b_board_body}</td>
					<td>${list.b_date}</td>
					<%-- <td><a href="ResponseServlet?b_board_title=${list.b_board_title}">${list.b_board_title}</td>
					<td>${list.user_name}</td>
					<td>${list.b_board_body}</td>
					<td>${list.b_date}</td> --%>
                </tr>
            </c:forEach>
             </table>
        </h5>
    </div>
</body>

</html>
