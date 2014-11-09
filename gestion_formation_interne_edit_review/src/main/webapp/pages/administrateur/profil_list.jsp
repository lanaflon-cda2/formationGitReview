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

	<table border="1">
		<tr>
			<td>Nom</td>
			<td>Role de Base</td>
			<td>Elementaire</td>
			<td>Desciption</td>
			<td>Options</td>
		</tr>

		<s:iterator value="profils">
			<tr>
				<td><s:property value="nomProfil" /></td>
				<td><s:property value="roleBase" /></td>
				<td><s:property value="elementaire" /></td>
				<td><s:property value="description" /></td>
				<td>
					<ul>
						<li><a href='javascript:void(0);' onclick="jsonGetProfil(<s:property value="idProfil"/>);">Modifier</a></li>
						<li><a href='<s:url action="deleteProfil" ><s:param name="id"><s:property value="idProfil"/></s:param></s:url>'>Supprimer</a></li>
						<li><a href='<s:url action="listActions" ><s:param name="id"><s:property value="idProfil"/></s:param></s:url>'>Actions</a></li>
					</ul>
				</td>
			</tr>
		</s:iterator>
	</table>

	<hr>

	<!-- Add Form -->
	<s:form id="add_profil" action="addProfil" method="post">
		nom: <s:textfield name="nom" />
		<br>
		description: <s:textfield name="description" />
		<br>
		<s:select label="Role de base" list="#{'Administrateur':'Administrateur', 'Responsable de formation':'Responsable de formation', 'Formateur' : 'Formateur'}" name="role" />
		<br>
		<s:submit value="Add" />
	</s:form>
	<!-- End Add Form -->

	<hr>

	<!-- Update Form -->
	<s:form id="update_profil" action="updateProfil"
		method="post">
		<s:hidden name="idProfil" />
		<br>
		<s:textfield name="nom" />
		<br>
		<s:textfield name="description" />
		<br>
		<s:select label="Role de base" list="#{'Administrateur':'Administrateur', 'Responsable de formation':'Responsable de formation', 'Formateur' : 'Formateur'}" name="role" />
		<br>
		<s:submit value="Update" />
	</s:form>
	<!-- End Update Form -->

</body>
</html>