<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!doctype html>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="/js/datepicker/foundation-datepicker.js"></script>
    <script src="/js/datepicker/foundation-datepicker.zh-CN.js"></script>
    <title>setting - FertilizerList</title>
    <style type="text/css">
        #bg {
            display: none;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: #000000;
            opacity:0.4;
            filter: alpha(opacity=40);
            -moz-opacity: 0.7;
        }
        #addDiv {
            display: none;
            position: absolute;
            top:30%;bottom:70%;margin:auto;
            left:0;right:0;
            width: 400px;
            height: 400px;
            background-color: #ffffff;
        }
        .input-text {
            width:90%;
            font-size:18px;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            var msg="${msg}";
            if(msg != ""){
                alert(msg)
            }
        });

    </script>
</head>
<body>
<div class="box-positon">
    <div class="rpos">当前位置:
        <select id="fertilizerId" name="fertilizerId" onchange="changeFertilizer()" style="background-color:#FEFFD0 ">
            <c:forEach items="${fertilizers }" var="fertilizer">
                <option value="${fertilizer.fertilizerId }" <c:if test="${fertilizerId == fertilizer.fertilizerId }">selected="selected"</c:if>>${fertilizer.fertilizerName }</option>
            </c:forEach>
        </select>
        <select id="valveNum" name="valveNum" onchange="changeFertilizer()" style="background-color:#FEFFD0 ">
            <c:forEach begin="1" end="64" step="1" var="item" varStatus="status" >
                <option value="${item}" <c:if test="${valveNum == item}" >selected="selected"</c:if> >${item}号阀</option>
            </c:forEach>
        </select>
        开始时间:<input type="text"  name="start" value="" id="start">
        结束时间:<input type="text"  name="end" value="" id="end">
    </div>
    <div class="clear"></div>
</div>
<div class="body-box">
    <table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
        <thead class="pn-lthead">
        <tr>

            <th style="height:30px;font-size:18px;">阀号</th>
            <th style="height:30px;font-size:18px;">详情</th>
            <th style="height:30px;font-size:18px;">总灌溉量</th>

        </tr>
        </thead>
        <tbody id="tbody" class="pn-ltbody"  align="center">
        <c:forEach items="${irrigationStatistics}" var="statistics" >
            <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                <td align="center" style="height:30px;font-size:18px;">
                        ${statistics.valveNum }号阀
                </td>
                <td align="center" style="height:30px;font-size:18px;">
                    <table >
                        <tr>
                            <c:forEach items="${statistics.irriRecords}" var="record" varStatus="status">
                                <td>

                                    开:<fmt:formatDate type="both" value="${record.start}" /> &nbsp;&nbsp;&nbsp;&nbsp;
                                    关:<fmt:formatDate type="both" value="${record.end}" />&nbsp;&nbsp;&nbsp;&nbsp;
                                    灌溉量:${record.irrigationVolume}

                                </td>
                            </c:forEach>
                        </tr>


                    </table>

                </td>
                <td align="center" style="height:30px;font-size:18px;">
                    ${statistics.totalIrrigation}
                </td>

            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<div id="bg"></div>


<script type="text/javascript">
    $('#start').fdatepicker({
        format: 'yyyy-mm-dd hh:ii',
        pickTime: true
    });
    function changeFertilizer(){
        var fertilizerId = $("#fertilizerId").val();
        window.location.href="/fertilizer/getValveRecord.do?fertilizerId="+fertilizerId;
    }


    function mouseover(i){
        i.bgColor='#eeeeee'
    }
    function mouseout(i){
        i.bgColor='#ffffff'
    }
    function inputOver(i){
        i.style.background="#FEFFD0";
    }
    function inputOut(i){
        i.style.border="0px";
        i.style.background="none";
    }

</script>
</body>
</html>