<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<script src="/js/JQ3.2.1.js"></script>
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
				<a href="${pageContext.request.contextPath}/beforeAddStaff.action">
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
<form action="${pageContext.request.contextPath}/findStaff.action" method="post">
	<table width="100%" border="1" >
		<tr class="henglan" style="font-weight:bold;">
			<td width="10%" align="center">员工姓名</td>
			<td width="6%" align="center">性别</td>
			<td width="12%" align="center">入职时间</td>
			<td width="15%" align="center">所属部门</td>
			<td width="10%" align="center">职务</td>
			<td width="10%" align="center">编辑</td>
		</tr>

		<s:iterator value="staffs" var="s">
			<tr class="tabtd1">
				<td align="center">${s.staffName}</td>
				<td align="center">${s.gender}</td>
				<td align="center">${s.onDutyDate}</td>
				<td align="center">${s.post.department.depName}</td>
				<td align="center">${s.post.postName}</td>
				<td width="7%" align="center">
					<a href="${pageContext.request.contextPath}/beforeUpdateStaff.action?staffID=${s.staffID}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
				</td>

			</tr>
		</s:iterator>

		<s:iterator value="#pageBean.date" var="s">
			<tr class="tabtd1">
				<td align="center">${s.staffName}</td>
				<td align="center">${s.gender}</td>
				<td align="center">${s.onDutyDate}</td>
				<td align="center">${s.post.department.depName}</td>
				<td align="center">${s.post.postName}</td>
				<td width="7%" align="center">
					<a href="${pageContext.request.contextPath}/beforeUpdateStaff.action?staffID=${s.staffID}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
				</td>

			</tr>
		</s:iterator>
	</table>
	<input id="pageNum" name="pageNum" type="hidden" value="<s:property value="pageBean.pageNum"/>">
</form>

 <table border="0" cellspacing="0" cellpadding="0" align="center">
	 <tr>
		 <td align="right">
			 <span>第<s:property value="#pageBean.pageNum"/>/<s:property value="#pageBean.totalPage"/>页</span>

			 <span>
                <s:if test="#pageBean.pageNum gt 1">
					<a href="javascript:void(0)" onclick="showPage(1)">[首页]</a>&nbsp;&nbsp;
					<a href="javascript:void(0)"
					   onclick="showPage(<s:property value="#pageBean.pageNum - 1"/>)">[上一页]</a>&nbsp;&nbsp;
				</s:if>

                <s:if test="#pageBean.pageNum lt #pageBean.totalPage">
                    <a href="javascript:void(0)"
					   onclick="showPage(<s:property value="#pageBean.pageNum + 1"/>)">[下一页]</a>&nbsp;&nbsp;
					<a href="javascript:void(0)" onclick="showPage(<s:property value="#pageBean.totalPage"/>)">[尾页]</a>
				</s:if>
        </span>
		 </td>
	 </tr>
 </table>


<script>

	function showPage(num) {
		document.getElementById("pageNum").value = num;
		document.forms[1].submit();
	}


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
