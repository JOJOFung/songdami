<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#buy").click(function() {
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "webapi/order",
				data : prepareJSON(),
				dataType : "text",
				success : function(data, textStatus, jqXHR) {
					alert('预定成功!感谢您的支持！请耐心等待配送员按您家的门铃！');
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('很抱歉！出错了！');
				}
			});
		});
	});

	// Helper function to serialize all the form fields into a JSON string
	function prepareJSON() {
		return JSON.stringify({
			"address" : $('#address').val(),
			"goods" : $('#goods').val()
		});
	}
</script>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">您的地址是：上海市徐汇区</span>
				<input id="address" type="text" class="form-control"
					placeholder="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">您需要：</span> <input
					id="goods" type="text" class="form-control" placeholder="Username"
					aria-describedby="basic-addon1">
			</div>
			<br>
			<p>
				<a id="buy" class="btn btn-primary btn-lg" href="#" role="button">订！</a>
			</p>
		</div>

		<hr>

		<footer>
		<p>&copy; Company 2015</p>
		</footer>
	</div>
</body>
</html>