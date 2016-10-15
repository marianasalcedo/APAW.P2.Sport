package sport.controllers;

import java.util.List;

import aspects.Validator;
import sport.daos.DaoFactory;
import sport.entities.User;
import sport.exceptions.InvalidFieldException;
import sport.exceptions.RepeatedEntityException;
import sport.wrappers.EntireUserWrapper;
import sport.wrappers.UserListWrapper;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			EntireUserWrapper userWrapper = new EntireUserWrapper(user.getNick(), user.getEmail());
			userListWrapper.addUserWrapper(userWrapper);
		}
		return userListWrapper;
	}

	public void createUser(String nick, String email) throws RepeatedEntityException, InvalidFieldException {
		Validator.validateString(nick, "nick del usuario");
		Validator.validateString(email, "email del usuario");
		User user = DaoFactory.getFactory().getUserDao().getByName(nick);
		if(user == null){
			DaoFactory.getFactory().getUserDao().create(new User(nick, email));
		}else{
			throw new RepeatedEntityException("El usuario:" + nick);
		}
	}


}
