<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<script src="/JQ3.2.1.js"></script>
	<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>



<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/showStaff.action" method="post">
	<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
		<tr>
			<td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
			<td width="39%" align="left">[员工管理]</td>

			<td width="57%"align="right">
				<%--高级查询 --%>
				<button type="submit"><a href="javascript:void(0)" onclick="condition()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a></button>

				<%--员工注入 --%>
				<a href="${pageContext.request.contextPath}/selectStaffDepartmentAdd.action">
					<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
				</a>

			</td>
			<td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
		</tr>
	</table>

	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    	
	    	<select  id="depart" name="depID">
			    <option value="-1">---请选择部门---</option>
			</select>
		</td>

	    <td width="80px" >职务：</td>
	    <td width="200px" >
			<select id="post" name="postID">
			    <option value="-1">---请选择职务---</option>
			</select>
		</td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" /></td>
	    <td ></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>

	<s:iterator value="staffs" var="staff">
		<tr class="tabtd1">
			<td align="center">${staff.staffName}</td>
			<td align="center">${staff.gender}</td>
			<td align="center">${staff.onDutyDate}</td>
			<td align="center">${staff.post.department.depName}</td>
			<td align="center">${staff.post.postName}</td>
			<td width="7%" align="center">
				<a href="${pageContext.request.contextPath}/beforeUpdateStaff.action?staffID=${staff.staffID}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
			</td>

		</tr>
	</s:iterator>

</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
<script>
	$(function () {
		$.post("${pageContext.request.contextPath}/showDepartment.action",
				null,
				function (data) {
					var _html ="<option value='-1'>---请选择部门---</option>";
					$.each(data, function (index, value) {
						_html += '<option value="' + value.depID + '">' + value.depName+ '</option>'
					});

					$("#depart").html(_html);
				},
				"json");
		$("#depart").change(function () {
			$.post("${pageContext.request.contextPath}/showPost.action",
					{
						depID: $("#depart").val()
					},
					function (data) {
						var _html="<option value='-1'>---请选择职务---</option>";
						$.each(data,function (index, value) {
							_html +='<option value="' + value.postID +'">'+value.postName+'</option>'
						});
						$("#post").html(_html)
					},
					"json")
		})
	});

</script>
</body>
</html>
