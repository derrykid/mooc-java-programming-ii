
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
		HashMap<String, String> nickname = new HashMap<>();
		nickname.put("matthew", "matt");
		nickname.put("michael", "mix");
		nickname.put("arthur", "artie");
		System.out.println(nickname.get("matthew"));
    }

}
