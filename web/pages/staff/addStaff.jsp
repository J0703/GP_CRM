<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script>
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return new ActiveXObject("Msxml2.HTTP");
			} catch (e) {
				try {
					return new ActiveXObject("Microsoft.HTTP");
				} catch (e) {
					throw e;
				}
			}
		}
	}
	function showPost(obj) {
		// 获取选中部门
		var depID = obj.value;
		//1,获得XMLHttpRequest对象
		var xmlHttp = createXMLHttpRequest();
		//2,打开连接
		var url = "${pageContext.request.contextPath}/showPost.action";
		xmlHttp.open("POST", url, true);
		//3,设置请求头
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//4,发出请求时,给出请求体
		xmlHttp.send("depID=" + depID);
		//5,给xmlHttp对象的onreadystatechange事件注册监听
		xmlHttp.onreadystatechange = function () {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				// 获取返回的 json 数据
				var jsonData = eval("(" + xmlHttp.responseText + ")");

				// 显示到 select 的 option 中
				var selectE = document.getElementById("post");
				selectE.innerHTML = "<option value='-1'>----请选择----</option>";
				for (var i = 0; i < jsonData.length; i++) {
					var postObj = jsonData[i];
					selectE.innerHTML += "<option value='" + postObj.postID + "'>" + postObj.postName + "</option>";
				}
			}
		};
	}
</script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form action="${pageContext.request.contextPath}/addStaff.action" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value=""/> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="" id="staffAction_add_staffName"/> </td>
	    <td>性别：</td>
	    <td><input type="radio" name="gender"  value="男"/>男
	    	<input type="radio" name="gender"  value="女"/>女
		</td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<select name="depID" id="depart" onchange="showPost(this)">
			    <option value="-1">----请选择----</option>
			   <s:iterator var="dep" value="departments">
				   <option value="${dep.depID}">${dep.depName}</option>
			   </s:iterator>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select id="post" name="postID">
	    		<option value="-1">----请选择----</option>
	    	</select>
	    </td>
	  </tr>
	   <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="" readonly="readonly"  onfocus="c.showMoreDay=true; c.show(this);" />
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>
</body>
</html>
