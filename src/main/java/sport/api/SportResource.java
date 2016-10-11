package sport.api;

import sport.controllers.SportController;
import sport.exceptions.InvalidVoteException;
import sport.exceptions.NotFoundThemeIdException;
import sport.wrappers.SportListWrapper;

public class SportResource {

	// POST **/votes   body="themeId:vote"
	public void createVote(int themeId, int vote) throws InvalidVoteException, NotFoundThemeIdException {
		if (vote < 0 || vote > 10) {
			throw new InvalidVoteException("" + vote);
		}
		if (!new SportController().createVote(themeId, vote)) {
			throw new NotFoundThemeIdException("" + themeId);
		}
	}

	// GET **/votes
	public SportListWrapper voteList() {
		return new SportController().voteList();
	}
}
