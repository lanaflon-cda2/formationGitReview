<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- URL to the root -->
<s:url namespace="/" action="" var="rootUrl" />

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Maquette</title>
		<link rel="stylesheet" href='<s:property value="rootUrl"/>css/style.css' />
		<link rel="stylesheet" href='<s:property value="rootUrl"/>lib/dist/css/bootstrap.css' />
		
		
		<!-- Begin CSS for the dateTables -->
		<link rel="stylesheet" href='<s:property value="rootUrl"/>lib/media/css/jquery.dataTables.css' />
		<!-- End CSS for the dateTables -->
	
	</head>
	<body class="main">
	
		<div class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a href="menu.php" class="navbar-brand">FORMATION</a>
					<button class="navbar-toggle" type="button" data-toggle="collapse"
						data-target="#navbar-main">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse" id="navbar-main">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="button-nav">Modifier Profil</a></li>
						<li><a href="#" class="button-nav">Se déconnecter</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="user-banner">
			<div class="container">
				<div class="col-lg-9">
					<ul class="nav navbar-nav navbar-left member-nav">
						<li><a href="index_administrateur.html"
							class="active button-nav">Gestion des Collaborateurs</a></li>
						<li><a href="#" class="button-nav">Gestion des
								utilisateurs</a></li>
						<li><a href="#" class="button-nav">Gestion des profils</a></li>
					</ul>
				</div>
				<div class="col-lg-3 member">
					<div class="pull-left user-img">
						<img src='<s:property value="rootUrl"/>images/members/avatar.png'>
					</div>
					<h2>Mouad Elfakir</h2>
					<p>administrateur</p>
				</div>
			</div>
		</div>
		<div class="container header-table">
			<div class="col-lg-12">
				<h3>
					<blockquote>Liste des collaborateurs</blockquote>
				</h3>
	
				<div class="col-lg-6">
					<h4 class="add">
						<span class="glyphicon glyphicon-plus-sign"></span> <a
							href="ajouter_collaborateur.html">Ajouter collaborateur</a>
					</h4>
				</div>
				<div class="col-lg-2"></div>
				<div class="col-lg-4">
					<div class="input-group">
						<input type="text" class="form-control"> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-search"></span></span>
					</div>
				</div>
			</div>
		</div>
	
		<div class="container main-table">
			<div class="col-lg-12">
				<table id="dataTable_Collaborateur" class="display dataTable"
					width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>Nom & Prénom</th>
							<th>Email</th>
							<th>Telephone</th>
							<th>Adresse</th>
							<th>Date de naissance</th>
							<th>Options</th>
						</tr>
					</thead>
						
					<tbody>
					
						<s:iterator value="collaborateurs">
							<tr>
								<td><s:property value="fullname"/></td>
								<td><s:property value="emailCollaborateur"/></td>
								<td><s:property value="telephoneCollaborateur"/></td>
								<td><s:property value="adresseCollaborateur"/></td>
								<td><s:property value="dateNaissanceCollaborateur"/></td>
								<td>
								
									<ul class="nav navbar-nav nav-options">
										<li><a data-toggle="modal" data-target="#myModal"
											class="button-nav"> <span class="glyphicon glyphicon-file"
												title="afficher"></span></a>
												<!-- <a href='<s:url action="listHabilitationScores" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Habilitations</a> -->
												</li>
										<li><a href="message.html" class="button-nav"> <span
												class="glyphicon glyphicon-envelope" title="envoyer message"></span></a>
												<!-- <a href='<s:url action="sendEmailToCollaborateur" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Email</a> -->
										</li>
										<li><a href="ajouter_collaborateur.html" class="button-nav"
											title="modifier"> <span class="glyphicon glyphicon-pencil"></span></a>
											<!-- <a href='javascript:void(0);' onclick="jsonGetCollaborateur(<s:property value="idCollaborateur"/>);">Modifier</a> -->
										</li>
										<li><a data-href=<s:url action="deleteCollaborateur" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url> data-toggle="confirmation" data-original-title="" title=""> <span
												class="glyphicon glyphicon-remove" title="supprimer"></span></a>
											<!-- <a href='<s:url action="deleteCollaborateur" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Supprimer</a> -->		
										</li>
									</ul>
								
									<%-- <ul>
										<li><a href='javascript:void(0);' onclick="jsonGetCollaborateur(<s:property value="idCollaborateur"/>);">Modifier</a></li>
										<li><a href='<s:url action="deleteCollaborateur" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Supprimer</a></li>
										<li><a href='<s:url action="sendEmailToCollaborateur" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Email</a></li>
										<li><a href='<s:url action="listHabilitationScores" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Habilitations</a></li>
									</ul> --%>
								</td>
							</tr>
						</s:iterator>
						
					</tbody>
				</table>
			</div>
		</div>
	
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Information</h4>
					</div>
					<div class="modal-body">
						<div class="col-lg-12 image">
							<img src="images/members/avatar.png" />
						</div>
						<h3>Nom et Prénom :</h3>
						<p>Mouad Sahi</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-trans" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script type="text/javascript" src='<s:property value="rootUrl"/>lib/dist/js/bootstrap.js'></script>
	
		<!-- Begin javascript for the dateTables -->
		<script type="text/javascript" src='<s:property value="rootUrl"/>lib/media/js/jquery.js'></script>
	
		<script type="text/javascript" src='<s:property value="rootUrl"/>lib/media/js/jquery.dataTables.js'></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#dataTable_Collaborateur').DataTable();
			});
		</script>
		<!-- End javascript for the dateTables -->
		
		<!-- bootstrap confirmation tool -->
	
			<script src='<s:property value="rootUrl"/>lib/BootstrapConfirmation_files/bootstrap-transition.js'></script>
			<script src='<s:property value="rootUrl"/>lib/BootstrapConfirmation_files/bootstrap-tooltip.js'></script>
	
			<script src='<s:property value="rootUrl"/>lib/BootstrapConfirmation_files/holder.js'></script>
			<script src='<s:property value="rootUrl"/>lib/BootstrapConfirmation_files/prettify.js'></script>
	
			<script src='<s:property value="rootUrl"/>lib/BootstrapConfirmation_files/application.js'></script>
	
			<script src='<s:property value="rootUrl"/>lib/BootstrapConfirmation_files/bootstrap-confirmation.js'></script>
	
		<!-- end bootstrap confirmation tool -->
	
	</body>
</html>





<%-- 
<html>
<head>

<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-2.1.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
function jsonGetCollaborateur(idCollaborateur){
	//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
	$.getJSON('<s:url action="getCollaborateur" namespace="/ajax" />', {idCollaborateur : idCollaborateur}, function(jsonResponse) {
		//if satuts == "success" , do
		if(jsonResponse.status === "success"){
			//get update Form			
			var updateForm = document.getElementById("update_collaborateur");
			
			//set inputs value from jsonResponse
			updateForm.idCollaborateur.value = jsonResponse.idCollaborateur;
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
			<td>Date de Naissance</td>
			<td>Options</td>
		</tr>

		<s:iterator value="collaborateurs">
			<tr>
				<td><s:property value="fullname"/></td>
				<td><s:property value="emailCollaborateur"/></td>
				<td><s:property value="telephoneCollaborateur"/></td>
				<td><s:property value="adresseCollaborateur"/></td>
				<td><s:property value="dateNaissanceCollaborateur"/></td>
				<td>
					<ul>
						<li><a href='javascript:void(0);' onclick="jsonGetCollaborateur(<s:property value="idCollaborateur"/>);">Modifier</a></li>
						<li><a href='<s:url action="deleteCollaborateur" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Supprimer</a></li>
						<li><a href='<s:url action="sendEmailToCollaborateur" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Email</a></li>
						<li><a href='<s:url action="listHabilitationScores" ><s:param name="id"><s:property value="idCollaborateur"/></s:param></s:url>'>Habilitations</a></li>
					</ul>
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<hr>
	
	<!-- Add Form -->
	<s:form id="add_collaborateur" action="addCollaborateur" method="post">
		nom: <s:textfield name="nom" /><br>
		prenom: <s:textfield name="prenom" /><br>
		email: <s:textfield name="email" /><br>
		date: <s:textfield name="dateNaissance" /><br>
		tele: <s:textfield name="telephone" /><br>
		adresse: <s:textfield name="adresse"  /><br>
		<s:select label="Sexe" list="#{'true':'Male', 'false':'Female'}" name="sexe" /><br>
		
		<s:checkbox name="sendEmail">Envoyer email:</s:checkbox><br>
		
		<s:submit value="Mettre à jour"  />
	</s:form>
	<!-- End Add Form -->
	
	<hr>
	
	<!-- Update Form -->
	<s:form id="update_collaborateur" action="updateCollaborateur" method="post">
		<s:hidden name="idCollaborateur" />
		<s:textfield name="nom" /><br>
		<s:textfield name="prenom" /><br>
		<s:textfield name="email" /><br>
		<s:textfield name="dateNaissance" /><br>
		<s:textfield name="telephone" /><br>
		<s:textfield name="adresse"  /><br>
		<s:select label="Sexe" list="#{'true':'Male', 'false':'Female'}" name="sexe" /><br>
		
		<s:checkbox name="sendEmail">Envoyer email:</s:checkbox><br>
		
		<s:submit value="Mettre à jour"  />
	</s:form>
	<!-- End Update Form -->
	
</body>
</html> --%>