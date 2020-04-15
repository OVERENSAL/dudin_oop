import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        PersonLoad load = new PersonLoad();
        HashSet<String> sportSchool = load.personLoad(args);
        showSet(sportSchool);
    }

    public static void showSet(HashSet<String> set) {
        for (String name: set) {
            System.out.println(name);
        }
    }
}
