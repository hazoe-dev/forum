<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/bootstrap.min.js"></script>
    <script src="/jquery.3.6.min.js"></script>
    <title>Document</title>
</head>
<body>
    <div class="container">
       <div class="text-end w-100 mt-2">
            Chào ${user.username }|
            <a href="/logout" class="text-primary">Thoát</a>
        </div>
        <h3 class="title">
            Topic: ${topic.title}
        </h3>
        <p class="new-topic">Đăng vào: ${topic.formatTime}, do: <strong>${topic.creator.username}</strong> tạo. ${topic.messages.size()} hồi âm.</p>
        <div class="messages">
            <button type="button" class="btn btn-outline-primary mb-3" onclick="window.location.href='/topic'">Gửi bài mới</button>
            <table class="table table-bordered" style=" width: 100%;">
                <thead>
                    <tr>
                      <th scope="col" colspan="2" class="table-secondary">${topic.formatTime}</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td rowspan="2" class="align-middle text-center" style="background: azure;width: 25%;"><strong>${topic.creator.username}</strong><br>${topic.creator.formatTime}</td>
                        <td class="d-flex bd-highlight " style="background: #c9ffff;"><span class="me-auto"><strong>${topic.title}</strong></span> 
                        	<form action="/reply"  method="get">
                        		<input name="title" type="hidden" value="${topic.title}">
                        		<input name="id" type="hidden" value="${topic.id}">
                        		<a class="text-end" onclick="this.closest('form').submit();return false;">Trả lời</a>
                        	</form>
                        </td>
                    </tr>
                    <tr class="bg-light">
                        <td>Chủ đề: ${topic.content}</td>
                    </tr>
                  </tbody>
            </table>
            
            <c:forEach var="msg" items="${topic.messages}">
            <table class="table table-bordered" style=" width: 100%;">
                <thead>
                    <tr>
                      <th scope="col" colspan="2" class="table-secondary">${msg.formatTime}</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <tr>
                        <td rowspan="2" class="align-middle text-center" style="background: azure;width: 25%;"><strong>${msg.creator.username}</strong><br>Tham gia ${msg.creator.formatTime}</td>
                        <td class="d-flex bd-highlight " style="background: #c9ffff;"><span class="me-auto"><strong>RE: ${msg.title}</strong></span> 
                        	<form action="/reply" method="get">
                        		<input name="title" type="hidden" value="${msg.title}">
                        		<input name="id" type="hidden" value="${topic.id}">
                        		<a  class="text-end" onclick="this.closest('form').submit();return false;">Trả lời</a>
                        	</form>
                        </td>
                    </tr>
                    <tr class="bg-light">
                        <td><p>${msg.content}</p>  ${msg.creator.username}</td>
                    </tr>
                  </tbody>
            </table>
            </c:forEach>
        </div>
        <div class="text-end w-100 mt-2 mb-5">
            <a href="/list" class="text-primary">Danh sách chủ đề</a>
        </div>
    </div>
</body>
</html>