import java.util.Scanner;

public class Main {
    public static final String ERROR_INVALID_MENU_NUMBER = "Error: Invalid menu number.";
    public static final String EXIT = "Exit";
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int STARTED_POSITION_X = 10;
    public static final int STARTED_POSITION_Y = 10;
    public static final int STARTED_POSITION_Z = 10;

    public static void main(String[] args) {
        Drone drone = new Drone(STARTED_POSITION_X, STARTED_POSITION_Y, STARTED_POSITION_Z);

        boolean isContinue = true;
        while (isContinue) {
            drone.printMenu();
            switch (SCANNER.nextLine()) {
                case "1" -> drone.changeY(1);
                case "2" -> drone.changeY(-1);
                case "3" -> drone.changeZ(1);
                case "4" -> drone.changeZ(-1);
                case "5" -> drone.changeX(-1);
                case "6" -> drone.changeX(1);
                case "7" -> drone.printPosition();
                case "8" -> isContinue = false;
                default -> System.out.println(ERROR_INVALID_MENU_NUMBER);
            }
        }
        System.out.println(EXIT);

    }
}
