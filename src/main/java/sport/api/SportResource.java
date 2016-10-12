package sport.api;

import sport.controllers.SportController;
import sport.exceptions.InvalidVoteException;
import sport.exceptions.NotFoundThemeIdException;

public class SportResource {

	// POST **/sports   body=sportName
	public void createVote(String sportName) throws InvalidVoteException, NotFoundThemeIdException {
		if (sportName == null || sportName.isEmpty()) {
			throw new InvalidVoteException(sportName);
		}
		new SportController().createSport(sportName);
	}

}
