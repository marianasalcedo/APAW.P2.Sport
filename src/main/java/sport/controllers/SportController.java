package sport.controllers;

import sport.daos.DaoFactory;
import sport.entities.Sport;

public class SportController {

	public void createSport(String sportName) {
		DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
	}

}
