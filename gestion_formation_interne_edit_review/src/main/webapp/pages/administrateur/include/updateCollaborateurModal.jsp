<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Modification</h4>
			</div>

			<form id="update_collaborateur" action="updateCollaborateur"
				method="post">
				<div class="modal-body">
					<div class="col-lg-12 image">
						<img src="images/members/avatar.png" />
					</div>
					<input type="hidden" id="idCollaborateur" name="idCollaborateur">
					<div class="form-group">
						<label for="inputLastName" class="col-lg-4 control-label">Nom</label>
						<div class="col-lg-8">
							<input autocomplete="off" name="nom" class="form-control"
								id="inputLastName" placeholder="Nom" type="text">
						</div>
					</div>
					<div class="form-group">
						<label for="inputFirstName" class="col-lg-4 control-label">Prenom</label>
						<div class="col-lg-8">
							<input autocomplete="off" name="prenom" class="form-control"
								id="inputFirstName" placeholder="Prenom" type="text">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="col-lg-4 control-label">Email</label>
						<div class="col-lg-8">
							<input autocomplete="off" name="email" class="form-control"
								id="inputEmail" placeholder="Email" type="email">
						</div>
					</div>

					<div class="form-group">
						<label for="inputDateNaissance" class="col-lg-4 control-label">Date
							de Naissance</label>
						<div class="col-lg-8">
							<input autocomplete="off" name="dateNaissance"
								class="form-control" id="inputDateNaissance"
								placeholder="dateNaissance" type="text">
						</div>
					</div>

					<div class="form-group">
						<label for="inputTelephone" class="col-lg-4 control-label">Telephone</label>
						<div class="col-lg-8">
							<input autocomplete="off" name="telephone" class="form-control"
								id="inputTelephone" placeholder="Ex : 0610807402" type="text">
						</div>
					</div>
					<div class="form-group">
						<label for="inputAdress" class="col-lg-4 control-label">Adresse</label>
						<div class="col-lg-8">
							<input autocomplete="off" name="adresse" class="form-control"
								id="inputAdress" placeholder="Ex : Casablanca Rue 10 N80"
								type="text">
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-4 control-label">Sexe</label>
						<div class="col-lg-8">
							<div class="radio">
								<label> <input type="radio" name="sexe" id="optionHomme"
									value="true"> Homme
								</label>
							</div>

							<div class="radio">
								<label> <input type="radio" name="sexe" id="optionFemme"
									value="false"> Femme
								</label>
							</div>
						</div>
					</div>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
					<button type="submit" class="btn btn-primary">Mettre à
						jour</button>
				</div>

			</form>
		</div>
	</div>
</div>