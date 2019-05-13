<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/portal/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>setting - house</title>

<script type="text/javascript">
$(function(){
	 var msg = "${msg}";
		if(msg!=null && msg != ''){
			alert(msg);
		} 
});
function setOff(hs_id){
 	$.ajax({
		url:"/setting/setOffHouseSetting.do?hs_id="+hs_id,
		type:"GET",
		 success:function(){
			document.location.href="/setting/houseSettingList.do";
		} 
	}) 
}

</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 温室设置  - 列表</div>
	<div class="clear"></div>
</div>
<div class="body-box">

<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="80px">温室编号</th>
			<th >温室名称</th>
			<th width="80px">有效性</th>
			<th >IP地址</th>
			<th width="80px">端口号</th>
			<th >节点列表</th>
			<th >操作</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	<c:forEach items="${houseSettings }" var="houseSetting">
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
		
			<form action="/setting/saveOrUpdateHouseSetting.do" method="post">
				<input type="hidden" name = "hs_id" value="${houseSetting.hs_id }" />
				<input type="hidden" name = "h_id" value="${houseSetting.h_id }" />
				<input type="hidden" name = "hs_state" value="${houseSetting.hs_state }" />
				<td align="center">${houseSetting.h_id }</td>
				<td align="center">${houseSetting.houseName }</td>
				<c:if test="${houseSetting.hs_state==1 }"><td align="center" bgcolor="#99ff99">启用</td></c:if>
				<c:if test="${houseSetting.hs_state==0 }"><td align="center" bgcolor="#ffff99">停用</td></c:if>
				<td align="center"><input name = "hs_ip" value = "${houseSetting.hs_ip }"/></td>
				<td align="center"><input name = "hs_port" value = "${houseSetting.hs_port }"/></td>
				<td align="center"><input name = "hs_node" value = "${houseSetting.hs_node }" placeholder="1.2.3.4"/></td>
				<td align="center"><input type="submit" value="保存并启用"/>|<input type="button" value="停用" onclick="setOff(${houseSetting.hs_id})"/></td>
			</form>
		
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>

</body>
</html>