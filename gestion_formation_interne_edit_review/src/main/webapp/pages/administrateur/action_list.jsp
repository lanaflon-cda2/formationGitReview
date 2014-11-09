<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-2.1.0.min.js" type="text/javascript"></script>
<script type="text/javascript">

function jsonGetProfil(idProfil){
	$.getJSON('<s:url action="getProfil" namespace="/ajax" />', {idProfil : idProfil}, function(jsonResponse) {
		if(jsonResponse.status === "success"){
			//get update Form			
			var updateForm = document.getElementById("update_profil");
			
			//set inputs value from jsonResponse
			updateForm.idProfil.value = jsonResponse.idProfil;
			updateForm.nom.value = jsonResponse.nom;
			updateForm.description.value = jsonResponse.description;
			
			//select role option
			for(var i=0; i<updateForm.role.length; i++){
				if(jsonResponse.role == updateForm.role[i].value){
					updateForm.role[i].selected=true;
				}else{
					updateForm.role[i].selected=false;
				}
			}
		}
  	});
}	
</script>
</head>
<body>

	<s:fielderror />
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
		<select multiple="multiple" name="actions">
			<s:iterator value="actions">
				<option value='<s:property value="idAction"/>'><s:property value="nomAction"/></option>
			</s:iterator>
		</select>
	</s:form>
	<!-- End Update Form -->

</body>
</html>