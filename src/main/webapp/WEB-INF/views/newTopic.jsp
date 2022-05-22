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
    <title>New Topic</title>
</head>
<body>
    <div class="container">
        <div class="text-end w-100 mt-2">
            Chào ${user.username }|
            <a href="/logout" class="text-primary">Thoát</a>
        </div>
        <h3 class="title">
            Tạo chủ để mới
        </h3>
        <div class="content w-100">
            <form action="/newtopic" method="post">
                <h4>Tiêu đề</h4>
                <input name = "title" class="w-100 form-control" type="text" required="required">
                <h4>Nội dung</h4>
                <textarea name = "content" class="w-100 form-control" name="content-reply" cols="30" rows="10"  required="required"></textarea>
                <div class="mb-5 mt-3 text-end">
                    <button type="submit" class="btn btn-outline-primary">Gởi</button>
                    <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/list'">Hủy bỏ</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>