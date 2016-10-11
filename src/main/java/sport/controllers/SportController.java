package sport.controllers;

import java.util.List;

import sport.daos.DaoFactory;
import sport.entities.User;
import sport.entities.Sport;
import sport.wrappers.SportListWrapper;
import sport.wrappers.SportWrapper;

public class SportController {

	public boolean createVote(int themeId, int vote) {
		User theme = DaoFactory.getFactory().getUserDao().read(themeId);
		if (theme != null) {
			DaoFactory.getFactory().getSportDao().create(new Sport(vote, theme));
			return true;
		} else {
			return false;
		}
	}

	public SportListWrapper voteList() {
		List<Sport> votes = DaoFactory.getFactory().getSportDao().findAll();
		SportListWrapper voteListWrapper = new SportListWrapper();
		for (Sport vote : votes) {
			voteListWrapper.addVoteWrapper(new SportWrapper(vote.getTheme().getName(),vote.getValue()));
		}
		return voteListWrapper;
	}

}
