
public class ValidationLogin {
	public static Boolean validate(String u,String p) {
		if(u.equals("Admin") && p.equals("Admin@123")) {
			return true;
		}
		else {
			return false;
		}
	}
}
