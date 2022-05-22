<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap.min.js"></script>
    <script src="jquery.3.6.min.js"></script>
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="text-end w-100 mt-2">
            Chào ${user.username }|
            <a href="/logout" class="text-primary">Thoát</a>
        </div>
        <h3 class="title">
            Diễn đàn: ${forum.title }
        </h3>
        <div class="topics">
            <button type="button" class="btn btn-outline-primary mb-3" onclick="window.location.href='/topic'">Gửi bài mới</button>
            <table class="table table-striped table-hover table-bordered" style=" width: 100%;">
                <thead>
                    <tr>
                      <th scope="col" class="text-center">Chủ đề</th>
                      <th scope="col" style=" width: 10%;" class="text-center">Hồi âm</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="topic" items="${forum.topics}">
                    <tr>
                      <td >
                        <div>
                            <a href="/topic/${topic.id}">${topic.title} </a>
                        </div>
                        <div>
                            Đăng bởi <span class="text-primary">${topic.creator.username}</span> , ${topic.formatTime}
                        </div>
                      </td>
                      <td class="text-center">${topic.messages.size()}</td>
                    </tr>
                    </c:forEach>
                  </tbody>
            </table>
        </div>
    </div>
</body>
</html>