package sport;

import sport.api.UserResource;

import java.util.Arrays;
import java.util.List;

import sport.api.SportResource;
import sport.exceptions.InvalidRequestException;
import web.http.HttpRequest;
import web.http.HttpResponse;
import web.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/users
		if ("users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
			// **/users/{nick}/sport
		} else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])) {
			try {
				String sportName = request.getParams().get("sport");
				response.setBody(sportResource.getUsersBySport(sportName).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/users body=nick:email
		case "users":
			try {
				String[] bodyParams = request.getBody().split(":");
				String userNick = bodyParams[0];
				String userEmail = bodyParams[1];
				userResource.createUser(userNick, userEmail);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				this.responseError(response, e);
			}
			break;
		// POST sport body=sportName
		case "sports":
			try {
				sportResource.createSport(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		// PUT **/users/{nick}/sport body=sportName
		if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			try {
				List<String> sportsName = Arrays.asList(request.getBody().split(","));
				response.setBody(sportResource.addUserToSport(request.paths()[1], sportsName));
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
