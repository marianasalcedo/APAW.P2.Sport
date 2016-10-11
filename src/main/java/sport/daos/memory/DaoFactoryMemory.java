package sport.daos.memory;

import sport.daos.DaoFactory;
import sport.daos.UserDao;
import sport.daos.SportDao;

public class DaoFactoryMemory extends DaoFactory {

	private UserDao userDao;
	private SportDao sportDao;

	public DaoFactoryMemory() {
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoMemory();
		}
		return userDao;
	}

	@Override
	public SportDao getSportDao() {
		if (sportDao == null) {
			sportDao = new SportDaoMemory();
		}
		return sportDao;
	}

}
