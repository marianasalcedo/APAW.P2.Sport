package sport.api;

import aspects.Validator;
import sport.controllers.UserController;
import sport.exceptions.InvalidFieldException;
import sport.exceptions.RepeatedEntityException;
import sport.wrappers.UserListWrapper;

public class UserResource {

	// GET **/users
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// POST **/users   body="nick:email"
	public void createUser(String userNick, String userEmail) throws InvalidFieldException, RepeatedEntityException {
		Validator.validateString(userNick, "nick del usuario");
		Validator.validateString(userEmail, "email del usuario");
		new UserController().createUser(userNick, userEmail);
	}


}
