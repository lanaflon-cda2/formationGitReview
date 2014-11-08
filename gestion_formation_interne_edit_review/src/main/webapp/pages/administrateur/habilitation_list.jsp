<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-2.1.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
function jsonGetHabilitation(idHabilitation){
	//make ajax request to /ajax/getHabilitation?idHabilitation=x
	$.getJSON('<s:url action="getHabilitation" namespace="/ajax" />', {idHabilitation : idHabilitation}, function(jsonResponse) {
		//if satuts == "success" , do
		if(jsonResponse.status === "success"){
			//get update Form			
			var updateForm = document.getElementById("update_habilitation");
			
			//set inputs value from jsonResponse
			updateForm.idHabilitation.value = jsonResponse.idHabilitation;
			updateForm.nomHabilitation.value = jsonResponse.nomHabilitation;
			updateForm.descriptionHabilitation.value = jsonResponse.descriptionHabilitation;
			
		}
  	});
}	
</script>
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
	
	<a href='<s:url action="addHabilitation" />'>Ajouter Habilitation</a><br>
	
	<table border="1">
		<tr>
			<td>Nom</td>
			<td>Description</td>
			<td>Options</td>
		</tr>

		<s:iterator value="habilitations">
			<tr>
				<td><s:property value="nomHabilitation"/></td>
				<td><s:property value="descriptionHabilitation"/></td>
				<td>
					<ul>
						<li><a href='javascript:void(0);' onclick="jsonGetHabilitation(<s:property value="idHabilitation"/>);">Modifier</a></li>
						<li><a href='<s:url action="deleteHabilitation" ><s:param name="id"><s:property value="idHabilitation"/></s:param></s:url>'>Supprimer</a></li>
					</ul>
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<hr>
	
	<!-- Add Form -->
	<s:form id="add_habilitation" action="addHabilitation" method="post">
		<s:textfield name="nom" /><br>
		<s:textarea name="description" /><br>
		
		<s:submit value="Enregistrer"  />
	</s:form>
	<!-- End Add Form -->
	
	<hr>
	
	<!-- Update Form -->
	<s:form id="update_habilitation" action="updateHabilitation" method="post">
		<s:hidden name="idHabilitation" />
		<s:textfield name="nomHabilitation"  /><br>
		<s:textarea name="descriptionHabilitation" /><br>
		
		<s:submit value="Update"  />
	</s:form>
	<!-- End Update Form -->
</body>
</html>