<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng nhập</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .login-form {
      width: 300px;
      margin: 150px auto;
    }
    .login-form form {
      margin-bottom: 15px;
      background: #fff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0px 0px 15px 0px rgba(0,0,0,0.1);
    }
    .login-form h2 {
      margin: 0 0 15px;
    }
    .form-control, .btn {
      min-height: 38px;
      border-radius: 2px;
    }
    .btn {        
      font-size: 15px;
      font-weight: bold;
    }
  </style>
</head>
<body>
  <div class="login-form">
    <form action="login" method="post">
      <h2 class="text-center">Đăng nhập</h2>
      <p class="warning-text">${mess}</p>
      <div class="form-group">
        <input name="user" type="text" class="form-control" placeholder="Tên đăng nhập" required="required">
      </div>
      <div class="form-group">
        <input name="pass" type="password" class="form-control" placeholder="Mật khẩu" required="required">
      </div>
      <div>
          <p> chưa có tài khoản ? <a href="./signup.jsp">đăng kí</a></p>
      </div>
      <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>
      </div>
    </form>
  </div>
</body>
</html>
