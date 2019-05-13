<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/portal/head.jsp" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>历史数据</title>
	<link rel="stylesheet" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
	<link href="/css/foundation.min.css" rel="stylesheet" type="text/css">
	<link href="/css/foundation-datepicker.css" rel="stylesheet" type="text/css">
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script src="/js/foundation-datepicker.js"></script>
	<script src="/js/locales/foundation-datepicker.zh-CN.js"></script>	
<!-- 	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> -->
	<script src="/highcharts/code/highcharts.js"></script>
	<script src="/highcharts/code/modules/exporting.js"></script>
	<script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
	<style>
	.container { margin:0 auto;  max-width:960px;padding:20px;height:100%;background-color:#AADEF6}
	</style>
</head>
<body >

<div class="container">
  <div style="float: left">
	<form id="dataForm11" style="padding-top:5px;">
		<table class="table">
			<thead>
				<tr>
					<th>起始日期:
						<input type="text" class="span2" value="" id="start" name="start">
					</th>
					<th>截止日期:
						<input type="text" class="span2" value="" id="end" name="end">
					</th>
				</tr>
			</thead>
		</table>
	</form>
  </div >
  <div style="float: right;margin: 15 100">
	<table>
		<tr>
			<td><div><a onclick = "temperature()">温度</a></div></td>
			<td><a onclick = "lighting()">光照</a></td>
			<td><a onclick = "windSpeed()">风速</a></td>
			<td><a onclick = "ph()">PH</a></td>
		</tr>
		<tr>
			<td><a onclick = "humidity()">湿度</a></td>
			<td><a onclick = "pressure()">气压</a></td>
			<td><a onclick = "rainFall()">降雨量</a></td>
			<td><a onclick = "pm25()">PM2.5</a></td>
		</tr>
	</table>
  </div>

	<%@ include file="historyChart/index.jsp" %>
	<%@ include file="historyChart/temperature.jsp" %>
	<%@ include file="historyChart/humidity.jsp" %>
	<%@ include file="historyChart/lighting.jsp" %>
	<%@ include file="historyChart/pressure.jsp" %>
	<%@ include file="historyChart/windSpeed.jsp" %>
	<%@ include file="historyChart/rainFall.jsp" %> 
	<%@ include file="historyChart/ph.jsp" %> 
	<%@ include file="historyChart/pm25.jsp" %> 
	
</div>
<script>
	var nowTemp = new Date();
	var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
	var checkin = $('#start').fdatepicker({
			onRender: function (date) {
				return date.valueOf() < now.valueOf() ? '' : '';
			}
		}).on('changeDate', function (ev) {
			if (ev.date.valueOf() > checkout.date.valueOf()) {
				var newDate = new Date(ev.date)
				newDate.setDate(newDate.getDate() + 1);
				checkout.update(newDate);
			}
			checkin.hide();
			$('#end')[0].focus();
		}).data('datepicker');
	var checkout = $('#end').fdatepicker({
			onRender: function (date) {
				return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
			}
		}).on('changeDate', function (ev) {
			checkout.hide();
		}).data('datepicker');
</script>

</body>
</html>