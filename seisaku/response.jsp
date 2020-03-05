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
    <div id="container">
        <div id="wrapper">
            <div id="header">
                <h1 align="center">
                    <form action='b_board.jsp'><img src="rogo.jpg" width="160" height="160" alt="Free Board"></form>
                </h1>
            </div>
        </div>
		<div class="response">
		<c:forEach var="list1" items="${b_boardlist}" >
			<h1>${list1.b_board_title}</h1>
		</c:forEach>
		</div>
		<table border="1" align="center">
		<tr>
			<th>ユーザー名</th>
			<th>内容</th>
			<th>投稿日時</th>
		</tr>
		<c:forEach var="list" items="${reslist}" >
			<tr>
				<%-- <td>${list.b_board_id}</td> --%>
				<td>${list.response_name}</td>
				<td>${list.response_comment}</td>
				<td>${list.responseday_date}</td>
			</tr>
			</c:forEach>
		</table>
        <h5 align="center">
            <form method="POST" action="ResponseServlet">
                名前<br><input type="text" name="responsename" required><br><br>
                内容<br><textarea name="rescomment" rows="8" cols="40" required></textarea><br><br>
                <input type="hidden" name="b_board_id" value="${b_board_id}">
                <input class="btn-3d-shadow" type='submit' name="btn1" value='書き込む' ><br><br><br>
				<%-- <div id="bottom"> --%>
                	<%-- <button onclick="location.href='B_boardServlet'">Topに戻る</button>required
				</div> --%>
				<%-- <input type="button" onclick="location.href='./result.jsp'" value="内容"> --%>

			<a href="/seisaku//B_boardServlet">top</a></div>
		</form>
        </h5>
    </div>
</body>

</html>
