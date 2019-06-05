<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Edit</title>
	</head>

	<body>
		<form method="post" action="/SpringMVC/FreeMarkerSpringMVC/save">
			名称：<input type="text" name="testName" value="${test.testName!}" /><br />
			状态：
				<input type="radio" name="testStatus" value="true" <#if (test.testStatus)>checked</#if> />正常
				<input type="radio" name="testStatus" value="false" <#if (!test.testStatus)>checked</#if> />异常			
			<br />
			<input type="hidden" name="testId" value="${test.testId!}" />
			<input type="hidden" name="testDate" value="${test.testDate!}" />
			<input type="submit" value="Submit" />
			<input type="button" value="Return" onClick="javascript:history.back();" />
		</form>
	</body>
</html>