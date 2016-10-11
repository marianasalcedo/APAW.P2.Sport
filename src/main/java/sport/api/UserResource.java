package sport.api;

import sport.controllers.UserController;
import sport.exceptions.InvalidThemeFieldException;
import sport.exceptions.NotFoundThemeIdException;
import sport.wrappers.OverageWrapper;
import sport.wrappers.UserListWrapper;

public class UserResource {

	// GET **/themes
	public UserListWrapper themeList() {
		return new UserController().themeList();
	}

	// POST **/themes   body="themeName"
	public void createTheme(String themeName) throws InvalidThemeFieldException {
		this.validateField(themeName);
		new UserController().createTheme(themeName);
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
