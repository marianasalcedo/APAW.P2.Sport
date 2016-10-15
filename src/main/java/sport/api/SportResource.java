package sport.api;

import java.util.List;

import aspects.Validator;
import sport.controllers.SportController;
import sport.exceptions.InvalidFieldException;
import sport.exceptions.NotFoundEntityException;
import sport.exceptions.RepeatedEntityException;
import sport.wrappers.UserListWrapper;

public class SportResource {

	// POST **/sports   body=sportName
	public void createSport(String sportName) throws InvalidFieldException, RepeatedEntityException {
		Validator.validateString(sportName, "nombre del sport");
		new SportController().createSport(sportName);
	}

	// PUT **/users/{nick}/sport body=sportName
	public String addUserToSport(String userNick, List<String> sportsName) throws NotFoundEntityException, InvalidFieldException{
		Validator.validateString(userNick, "nombre del usuario");
		Validator.validateList(sportsName, "lista de sports");
		return new SportController().addUserToSport(userNick, sportsName);
	}

	public UserListWrapper getUsersBySport(String sportName) throws InvalidFieldException, NotFoundEntityException{
		Validator.validateString(sportName, "nombre del sport");
		return new SportController().getUsersBySport(sportName);
	}
}
