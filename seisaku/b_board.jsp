<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J" %>
<!--<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->

<html>

<head>
    <link rel="stylesheet" href="style.css">
    <title>
        �f���쐬
    </title>
</head>

<body>
    <div id="container">
        <div id="wrapper">
            <div id="header">
                <h1 align="center">
                    <img src="rogo.jpg" width="160" height="160" alt="Free Board">
                </h1>
            </div>
        </div>
        <h5 align="center">
            <form method="POST" action="B_boardServlet">
                �^�C�g��<br><input type='text' name='title' required><br><br>
                ���O<br><input type='text' name='name' required><br><br>
                ���e<br><textarea name='body' rows="8" cols="40" required></textarea><br><br>
                <input class="btn-3d-shadow" type='submit' name='btn1' value='���e����'><br><br>
                <input class='btn-3d-shadow' type='submit' value='�X���b�h�ꗗ'>
            </form>
        </h5>
    </div>
</body>

</html>
