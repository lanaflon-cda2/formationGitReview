<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>

	<!-- My version of Action Notifications -->
	<s:if test="isSessionActionError()">
		Error: <s:property value="sessionActionErrorText" />
	</s:if>
	<s:if test="isSessionMessageError()">
		Message: <s:property value="sessionActionMessageText" />
	</s:if>
	<!-- End of Action Notifications -->

	<br>

	<!-- Update Form -->
	<s:form id="update_profil_actions" action="updateProfilActions" method="post">
		<s:hidden name="idProfil" />
		<br>
		<s:iterator value="actionBeans">
			<s:if test="checked==true">
				<input type="checkbox" name="actions" value='<s:property value="action.idAction"/>' checked="checked"> <s:property value="action.nomAction" />
			</s:if>
			<s:else>
				<input type="checkbox" name="actions" value='<s:property value="action.idAction"/>'> <s:property value="action.nomAction" />
			</s:else>
		</s:iterator>
		
		<s:submit value="Update" />
	</s:form>
	<!-- End Update Form -->

</body>
</html>