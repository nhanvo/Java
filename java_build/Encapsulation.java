import lib.User;
public class Encapsulation {

	public static void main(String[] args) {
        User u = new User("Nhan");
        System.out.println(u.toString());

        u.setUserName("Vo Thanh");
        System.out.println(u.toString());
    }
}

