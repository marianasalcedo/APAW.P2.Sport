package sport.controllers;

import java.util.ArrayList;
import java.util.List;

import sport.daos.DaoFactory;
import sport.entities.User;
import sport.wrappers.EntireUserWrapper;
import sport.wrappers.OverageWrapper;
import sport.wrappers.UserListWrapper;
import sport.wrappers.UserWrapper;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			EntireUserWrapper userWrapper = new EntireUserWrapper(user.getId(), user.getNick(), user.getEmail());
			userListWrapper.addUserWrapper(userWrapper);
		}
		return userListWrapper;
	}

	public void createUser(String nick, String email) {
		DaoFactory.getFactory().getUserDao().create(new User(nick, email));
	}

	public OverageWrapper themeOverage(int themeId) {
		if (DaoFactory.getFactory().getUserDao().read(themeId) == null) {
			return null;
		}
		List<Integer> voteValues = new ArrayList<>();
		double total = 0;
		for (Integer value : voteValues) {
			total += value;
		}
		return new OverageWrapper(total / voteValues.size());
	}

}
