package sport.api;

import sport.controllers.UserController;
import sport.exceptions.InvalidThemeFieldException;
import sport.exceptions.NotFoundThemeIdException;
import sport.wrappers.OverageWrapper;
import sport.wrappers.UserListWrapper;

public class UserResource {

	// GET **/users
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// POST **/users   body="nick:email"
	public void createTheme(String userNick, String userEmail) throws InvalidThemeFieldException {
		this.validateField(userNick);
		this.validateField(userEmail);
		new UserController().createUser(userNick, userEmail);
	}

	private void validateField(String field) throws InvalidThemeFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidThemeFieldException(field);
		}
	}

	// GET **themes/{id}/overage
	public OverageWrapper themeOverage(int themeId) throws NotFoundThemeIdException {
		OverageWrapper overageWrapper = new UserController().themeOverage(themeId);
		if (overageWrapper == null) {
			throw new NotFoundThemeIdException("" + themeId);
		} else {
			return overageWrapper;
		}
	}

}
