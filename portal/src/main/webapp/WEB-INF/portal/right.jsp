<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>lyyh-right</title>
<script type="text/javascript">
function startCollection(){
	$.ajax({
		url:"/dataCollection/startCollect.do",
		success:function(data){
			alert(data);
		}
	})
}
function stopCollection(){
	$.ajax({
		url:"/dataCollection/stopCollect.do",
		success:function(data){
			alert(data);
		}
	})
}
</script>
</head>
<body>
	<div class="box-positon">
	 	 <div class="rpos">当前位置: 首页 - 欢迎页</div>
	</div>
<div class="body-box">
        <div class="welcom-con">
        	 <div class="we-txt">
             	  <p>
             	  
		 <br />欢迎蓝洋益海温室管理系统！<br />
		&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  北京蓝洋益海科技有限公司，是一家集科研、创新、生产、技术服务为一体的专业农业物联企业。<br />
		公司成立十几年来，经过不懈努力，在精准施肥灌溉控制、农业物联系统等领域走在国内前列。部分产品性能达到或超过同类国外进口设备，得到行业内专家及广大用户好评。<br />
		公司主要业务范围：农业物联网信息化系统、温室环境控制系统、农业精量配肥施肥系统、灌溉控制系统及水肥一体化系统的研发、生产、销售和技术服务。<br />
		可承揽大型农业园区物联网信息化系统、水肥一体化系统、农业环境控制系统的设计、生产、安装调试、专业承包等。<br />
		我公司以一流的技术、一流的产品、一流的服务诚信于客户，以客户的满意作为企业永恒目标。愿我们的真诚和您的关爱共同铸就农业现代化、信息化的明天。<br />
                 <br />
                  </p>
             </div>
                 
                  <input type="button" value="开始" onclick="startCollection()"/><br />
                  <input type="button" value="停止" onclick="stopCollection()"/>
             <ul class="ms">
             	<li class="wxx">访问量</li><li class="attribute">　　　系统属性</li>
             </ul>
             <div class="ms-xx">
                 <div class="xx-xx">
             	      <table width="100%" border="0" cellspacing="0" cellpadding="0">
             	       <tr>
                        <td width="20%" height="30" align="right"></td>
                        <td width="25%"><b>PV</b></td>
                        <td width="25%"><b>IP</b></td>
                        <td width="30%"><b>独立访客</b></td>
                    </tr>
                      <tr>
                        <td height="30" align="right">今日：</td>
                     	<td>0</td>
                     	<td>0</td>
                     	<td>0</td>
                    </tr>
                      <tr>
                        <td height="30" align="right">昨日：</td>
            			<td>0</td>
                     	<td>0</td>
                     	<td>0</td>
                    </tr>
                      <tr>
                        <td height="30" align="right">本周：</td>
                  		<td>0</td>
                     	<td>0</td>
                     	<td>0</td>
                    </tr>
                      <tr>
                        <td height="30" align="right">本月：</td>
                  		<td>0</td>
                     	<td>0</td>
                     	<td>0</td>
                     </tr>
                     <tr>
                        <td height="30" align="right">累计：</td>
                  		<td>0</td>
                     	<td>0</td>
                     	<td>0</td>
                     </tr>
               </table>
                 </div>
                 <div class="attribute-xx" style="float:left">
                 	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="30%" height="30" align="right">操作系统版本：</td>
                            <td height="30"><span class="black"></span></td>
                        </tr>
                          <tr>
                            <td width="30%" height="30" align="right">操作系统类型：</td>
                            <td height="30"><span class="black"></span> </td>
                        </tr>
                          <tr>
                            <td width="30%" height="30" align="right">用户、目录：</td>
                            <td height="30"><span class="black"></span></td>
                        </tr><tr>
                            <td width="30%" height="30" align="right">JAVA运行环境：</td>
                            <td height="30"><span></span></td>
                          </tr>
                          <tr>
                            <td width="30%" height="30" align="right">JAVA虚拟机：</td>
                            <td height="30"> <span></span></td>
                        </tr>
                   </table>  
               </div>

             </div>
             
  </div>
 </div>
</body>
</html>