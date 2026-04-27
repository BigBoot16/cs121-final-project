import java.util.*;

public class Character {
	
	private String location;
	private String name;
	private boolean guilty;

	public Character(String input_name, String input_location, boolean guilt) {
		name = input_name;
		location = input_location;
		guilty = guilt;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public boolean getGuilt() {
		return guilty;
	}
}
