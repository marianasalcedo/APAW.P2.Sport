package aspects;

import java.util.List;

import sport.exceptions.InvalidFieldException;

public abstract class Validator {

	public static void validateString(String field, String fieldName) throws InvalidFieldException{
		if (field == null || field.isEmpty()) {
			throw new InvalidFieldException(fieldName);
		}
	}

	public static <T> void validateList(List<T> list , String fieldName) throws InvalidFieldException{
		if (list == null || list.isEmpty()) {
			throw new InvalidFieldException(fieldName);
		}
	}
	
}
