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
    <title>Đăng nhập</title>
</head>
<body>
    <div class="container text-center  mt-5" >
        <div class="row d-flex justify-content-center">
            <div class="col-7 ">
                <h3 class="text-center pb-2 pt-2 bg-info text-white border mb-0 w-100">
                    Đăng nhập
                </h3>
                <form action="/login" class="row border w-100 me-0 ms-0" method="post">
                    <label for="username" class="col-4 text-end mb-2 mt-2">Tên đăng nhập</label>
                    <input name="username"type="text" class="col-6 mb-2 mt-2">
                    
                    <label for="password" class="col-4 text-end mb-2 mt-2">Mật khẩu</label>
                    <input name="password" type="text" class="col-6 mb-2 mt-2">

                    <button type="submit" class="btn btn-outline-info col-4 m-auto mb-2">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>