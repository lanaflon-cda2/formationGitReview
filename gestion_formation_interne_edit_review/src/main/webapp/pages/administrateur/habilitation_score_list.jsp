<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-2.1.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
function jsonDeleteHabilitationScore(idHabilitationScore){
	$.getJSON('<s:url action="deleteHabilitationScore" namespace="/ajax" />', {idHabilitationScore : idHabilitationScore}, function(jsonResponse) {

		if(jsonResponse.status === "success"){
			//afficher message success	
			
			//update table supprimer field
		}else {
			//afficher message fail
		}
  	});
}	

function jsonGetHabilitationScore(idHabilitationScore){
	$.getJSON('<s:url action="getHabilitationScore" namespace="/ajax" />', {idHabilitationScore : idHabilitationScore}, function(jsonResponse) {

		if(jsonResponse.status === "success"){
			var updateForm = document.getElementById("update_habilitation_score");
			updateForm.idHabilitationScore.value = jsonResponse.idHabilitationScore;
			
			//select sexe option
			for(var i=0; i<updateForm.score.length; i++){
				if(jsonResponse.score == updateForm.score[i].value){
					updateForm.score[i].selected=true;
				}else{
					updateForm.score[i].selected=false;
				}
			}
		}
  	});
}

function jsonUpdateHabilitationScore(){
	//event.preventDefault();//Prevent default action af the form (submit)
	
	//get data form values
	var updateForm = document.getElementById("update_habilitation_score");
	
	var idHabilitationScore = updateForm.idHabilitationScore.value;
	var score = 1;
	for(var i=0; i<updateForm.score.length; i++){
		if(updateForm.score[i].selected == true){
			score = updateForm.score[i].value;
		}
	}
	
	//make update request to /ajax/updateHabilitationScore?idHabilitationScore=x&score=y
	$.getJSON('<s:url action="updateHabilitationScore" namespace="/ajax" />', {idHabilitationScore : idHabilitationScore, score : score}, function(jsonResponse) {
		if(jsonResponse.status === "success"){
			//afficher success message
			
			//update table
		}else{
			//afficher error message
		}
  	});
	
	return false;//prevent form from submit
}

function jsonAddHabilitationScore(){
	//get data form values
	var updateForm = document.getElementById("add_habilitation_score");
	
	var idCollaborateur = updateForm.idCollaborateur.value;
	var idHabilitation = 1;
	for(var i=0; i<updateForm.idHabilitation.length; i++){
		if(updateForm.idHabilitation[i].selected == true){
			idHabilitation = updateForm.idHabilitation[i].value;
		}
	}
	var score = 1;
	for(var i=0; i<updateForm.score.length; i++){
		if(updateForm.score[i].selected == true){
			score = updateForm.score[i].value;
		}
	}
	
	//make update request to /ajax/updateHabilitationScore?idHabilitationScore=x&score=y
	$.getJSON('<s:url action="addHabilitationScore" namespace="/ajax" />', {idCollaborateur : idCollaborateur, idHabilitation : idHabilitation, score : score}, function(jsonResponse) {
		if(jsonResponse.status === "success"){
			//afficher success message
			
			//update table
		}else{
			//afficher error message
		}
  	});
	
	return false;//prevent form from submit
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
	
	<table border="1">
		<tr>
			<td>Nom</td>
			<td>Description</td>
			<td>Score</td>
			<td>Options</td>
		</tr>

		<s:iterator value="habilitationScores">
			<tr>
				<td><s:property value="habilitation.nomHabilitation"/></td>
				<td><s:property value="habilitation.descriptionHabilitation"/></td>
				<td><s:property value="scoreHabilitation"/></td>
				<td>
					<ul>
						<li><a href='javascript:void(0);' onclick="jsonGetHabilitationScore('<s:property value="idHabilitationScore"/>');">Modifier</a></li>
						<li><a href='javascript:void(0);' onclick="jsonDeleteHabilitationScore('<s:property value="idHabilitationScore"/>');">Supprimer</a></li>
					</ul>
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<hr>
	
	<form id="add_habilitation_score" action="addHabilitationScore" method="post" onsubmit="return jsonAddHabilitationScore();">
		<s:hidden name="idCollaborateur" value="%{id}" />
		<select name="idHabilitation" >
			<s:iterator value="habilitations">
				<option value='<s:property  value="idHabilitation" />'><s:property value="nomHabilitation" /></option>
			</s:iterator>
		</select>
		<s:select name="score" list="#{1:1, 2:2, 3:3, 4:4 , 5:5}" ></s:select>
		
		<s:submit value="add" />
	</form>	

	<hr>

	<form id="update_habilitation_score" action="updateHabilitationScore" method="post" onsubmit="return jsonUpdateHabilitationScore();">
		<s:hidden name="idHabilitationScore" />
		<s:select name="score" list="#{1:1, 2:2, 3:3, 4:4 , 5:5}" ></s:select>
		
		<s:submit value="update" />
	</form>
</body>
</html>