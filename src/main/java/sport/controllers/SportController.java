package sport.controllers;

import java.util.List;

import sport.daos.DaoFactory;
import sport.entities.Sport;
import sport.entities.User;
import sport.exceptions.NotFoundEntityException;
import sport.exceptions.RepeatedEntityException;
import sport.wrappers.UserListWrapper;
import sport.wrappers.UserWrapper;

public class SportController {

	public void createSport(String sportName) throws RepeatedEntityException {
		Sport sport = DaoFactory.getFactory().getSportDao().getByName(sportName);
		if(sport == null){
			DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
		}else{
			throw new RepeatedEntityException("El sport:" + sportName);
		}	
	}

	public String addUserToSport(String userNick, List<String> sportsName) throws NotFoundEntityException {
		for (String sportName: sportsName){
			Sport sport = DaoFactory.getFactory().getSportDao().getByName(sportName);
			if(sport == null){
				throw new NotFoundEntityException("El sport:" + sportName);
			}else{
				sport.setUser(new User(userNick, ""));
			}
			DaoFactory.getFactory().getSportDao().update(sport);
		}
		
		return "Deporte agregado exitósamente!";	
	}
	
	
	public UserListWrapper getUsersBySport(String sportName) throws NotFoundEntityException{
		Sport sport = DaoFactory.getFactory().getSportDao().getByName(sportName);
		if(sport == null){
			throw new NotFoundEntityException("El sport:" + sportName);
		}else{
			UserListWrapper result = new UserListWrapper();
			for(User user: sport.getUserList()){
				result.addUserWrapper(new UserWrapper(user.getNick()));
			}
			return result;
		}
	}
	
}
