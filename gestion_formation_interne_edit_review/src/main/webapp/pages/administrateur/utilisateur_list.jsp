<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-2.1.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
function jsonGetUtilisateur(idUtilisateur){
	//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
	$.getJSON('<s:url action="getUtilisateur" namespace="/ajax" />', {idUtilisateur : idUtilisateur}, function(jsonResponse) {
		//if satuts == "success" , do
		if(jsonResponse.status === "success"){
			//get update Form			
			var updateForm = document.getElementById("update_utilisateur");
			
			//set inputs value from jsonResponse
			updateForm.idUtilisateur.value = jsonResponse.idUtilisateur;
			updateForm.nom.value = jsonResponse.nom;
			updateForm.prenom.value = jsonResponse.prenom;
			updateForm.email.value = jsonResponse.email;
			updateForm.telephone.value = jsonResponse.telephone;
			updateForm.dateNaissance.value = jsonResponse.dateNaissance;
			updateForm.adresse.value = jsonResponse.adresse;
			
			//select sexe option
			for(var i=0; i<updateForm.sexe.length; i++){
				if(jsonResponse.sexe == updateForm.sexe[i].value){
					updateForm.sexe[i].selected=true;
				}else{
					updateForm.sexe[i].selected=false;
				}
			}
			
			//select sexe option
			for(var i=0; i<updateForm.profil.length; i++){
				if(jsonResponse.profil == updateForm.profil[i].value){
					updateForm.profil[i].selected=true;
				}else{
					updateForm.profil[i].selected=false;
				}
			}
			
		}
  	});
}	
</script>
</head>
<body>

	<s:fielderror/>
	<!-- My version of Action Notifications -->
	<s:if test="isSessionActionError()">
		Error: <s:property value="sessionActionErrorText" />
	</s:if>
	<s:if test="isSessionMessageError()">
		Message: <s:property value="sessionActionMessageText" />
	</s:if>
	<!-- End of Action Notifications -->
	
	<a href='<s:url action="addCollaborateur" />'>Ajouter Collaborateur</a><br>
	
	<table border="1">
		<tr>
			<td>Nom et prenom</td>
			<td>Email</td>
			<td>Telephone</td>
			<td>Adresse</td>
			<td>Profil</td>
			<td>Options</td>
		</tr>

		<s:iterator value="utilisateurs">
			<tr>
				<td><s:property value="fullname"/></td>
				<td><s:property value="emailUtilisateur"/></td>
				<td><s:property value="telephoneUtilisateur"/></td>
				<td><s:property value="adresseUtilisateur"/></td>
				<td><s:property value="profil.nomProfil"/></td>
				<td>
					<ul>
						<li><a href='javascript:void(0);' onclick="jsonGetUtilisateur(<s:property value="idUtilisateur"/>);">Modifier</a></li>
						<li><a href='<s:url action="deleteUtilisateur" ><s:param name="id"><s:property value="idUtilisateur"/></s:param></s:url>'>Supprimer</a></li>
						<li><a href='<s:url action="sendEmailToUtilisateur" ><s:param name="id"><s:property value="idUtilisateur"/></s:param></s:url>'>Email</a></li>
					</ul>
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<hr>
	
	<!-- Add Form -->
	<s:form id="add_utilisateur" action="addUtilisateur" method="post">
		nom: <s:textfield name="nom" /><br>
		prenom: <s:textfield name="prenom" /><br>
		email: <s:textfield name="email" /><br>
		date: <s:textfield name="dateNaissance" /><br>
		tele: <s:textfield name="telephone" /><br>
		adresse: <s:textfield name="adresse"  /><br>
		<s:select label="Sexe" list="#{'true':'Male', 'false':'Female'}" name="sexe" />
		<br>
		<select name="profil">
			<s:iterator value="profils">
				<option value='<s:property value="idProfil" />'><s:property value="nomProfil" /></option>
			</s:iterator>
		</select>
		<br>
		<s:checkbox name="sendEmail">Envoyer email:</s:checkbox><br>
		
		<s:submit value="Add"  />
	</s:form>
	<!-- End Add Form -->
	
	<hr>
	
	<!-- Update Form -->
	<s:form id="update_utilisateur" action="updateUtilisateur" method="post">
		<s:hidden name="idUtilisateur" />
		<s:textfield name="nom" /><br>
		<s:textfield name="prenom" /><br>
		<s:textfield name="email" /><br>
		<s:textfield name="dateNaissance" /><br>
		<s:textfield name="telephone" /><br>
		<s:textfield name="adresse"  /><br>
		<s:select label="Sexe" list="#{'true':'Male', 'false':'Female'}" name="sexe" />
		<br>
		<select name="profil">
			<s:iterator value="profils">
				<option value='<s:property value="idProfil" />'><s:property value="nomProfil" /></option>
			</s:iterator>
		</select>
		<br>
		
		<s:checkbox name="sendEmail">Envoyer email:</s:checkbox><br>
		
		<s:submit value="Update"  />
	</s:form>
	<!-- End Update Form -->
	
</body>
</html>