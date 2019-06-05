<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>List</title>
		<link type="text/css" rel="styleSheet" href="./css/style.css" />
	</head>

	<body>
		<h2>
			<a href="/SpringMVC">List=========${aaa!}====</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="/SpringMVC/FreeMarkerSpringMVC/add">Add</a>&nbsp;&nbsp;|&nbsp;&nbsp;Total:${pager.totalCount!'0'}
		</h2>
		
		<div style="text-align: right; margin: 20px 0 0; overflow: hidden;">
			<form id="form_link" name="search_form" action="/SpringMVC/FreeMarkerSpringMVC/search" method="get">
				<input type="text" name="k" value="${k!?html}" onmouseover="this.select();" /> 
				<input type="submit" value="Search" />
			</form>
		</div>

  		<table cellSpacing="1" style="width: 100%; border: 1px solid #E6DBC0; border-collapse: collapse;">
  			<thead>
	  			<tr>
					<th width="10%" style="border: 1px solid #E6DBC0;">ID</th>
					<th width="20%" style="border: 1px solid #E6DBC0;">名称</th>
					<th width="10%" style="border: 1px solid #E6DBC0;">状态</th>
					<th width="20%" style="border: 1px solid #E6DBC0;">创建日期</th>
					<th width="10%" style="border: 1px solid #E6DBC0;">Operation</th>
  				</tr>
  			</thead>
  			<tbody>
  				<#if testaaaList??>
  										==no exist==
  				</#if>
  				
  				
  				================
  			
  				<#if testList??>
  				
				<#list testList as test>
					<tr>
						<td style="border: 1px solid #E6DBC0; text-align: center;">
							${test.testId!?string.currency}
						</td>
						<td style="border: 1px solid #E6DBC0; text-align: center;">
							${test.testName!}
						</td>
						<td style="border: 1px solid #E6DBC0; text-align: center;">
							<#if (test.testStatus)>正常
							<#else><font style="background-color: #FFFF00;">不正常</font>
							</#if>
						</td>
						<td style="border: 1px solid #E6DBC0; text-align: center;">
							${test.testDate!?string("yyyy-MM-dd HH:mm:ss")}
						</td>
						<td style="border: 1px solid #E6DBC0; text-align: center;">
							<a href="/SpringMVC/FreeMarkerSpringMVC/${test.testId!}">Edit</a>
							<a href="/SpringMVC/FreeMarkerSpringMVC/del/${test.testId!}" onClick="return confirm('Delete ?');">Delete</a>
						</td>
					</tr>
				</#list>
				</#if>
  			</tbody>
  		</table>
  		
  		<div id="pageNav">
  			<#include "pager.ftl" />
  		</div>
	</body>
</html>

        