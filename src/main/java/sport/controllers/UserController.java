package sport.controllers;

import java.util.ArrayList;
import java.util.List;

import sport.daos.DaoFactory;
import sport.entities.User;
import sport.wrappers.OverageWrapper;
import sport.wrappers.UserListWrapper;
import sport.wrappers.UserWrapper;

public class UserController {

	public UserListWrapper themeList() {
		List<User> themeList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper themeListWrapper = new UserListWrapper();
		for (User theme : themeList) {
			themeListWrapper.addThemeWrapper(new UserWrapper(theme.getId(), theme.getName()));
		}
		return themeListWrapper;
	}

	public void createTheme(String themeName) {
		DaoFactory.getFactory().getUserDao().create(new User(themeName));
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
