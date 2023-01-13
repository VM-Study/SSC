
public class Drone {
    public static final String MENU_TEXT = """

            Which direction would you like yo move the drone?
              1 - Move Up
              2 - Move Down
              3 - Move Forward
              4 - Move Backward
              5 - Turn Left
              6 - Turn Right
              7 - Display Position
              8 - Exit Navigation""";
    public static final String MOVED_RIGHT = "You have moved Right";
    public static final String MOVED_LEFT = "You have moved Left";
    public static final String MOVED_UP = "You have moved Up";
    public static final String MOVED_DOWN = "You have moved Down";
    public static final String MOVED_FORWARD = "You have moved Forward";
    public static final String MOVED_BACKWARD = "You have moved Backward";

    private int x;
    private int y;
    private int z;

    public Drone(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void printMenu() {
        System.out.println(MENU_TEXT);
    }

    public void changeX(int index) {
        x += index;
        System.out.println((index > 0) ? MOVED_RIGHT : MOVED_LEFT);
    }

    public void changeY(int index) {
        y += index;
        System.out.println((index > 0) ? MOVED_UP : MOVED_DOWN);
    }

    public void changeZ(int index) {
        z += index;
        System.out.println((index > 0) ? MOVED_FORWARD : MOVED_BACKWARD);
    }

    public String calculateOrientation() {
        String orientation;
        if (x == 0 && z < 0) {
            orientation = "N";
        } else if (x > 0 && z < 0) {
            orientation = "NE";
        } else if (x > 0 && z == 0) {
            orientation = "E";
        } else if (x > 0 && z > 0) {
            orientation = "SE";
        } else if (x == 0 && z > 0) {
            orientation = "S";
        } else if (x < 0 && z < 0) {
            orientation = "SW";
        } else if (x < 0 && z == 0) {
            orientation = "W";
        } else if (x < 0 && z > 0) {
            orientation = "NW";
        } else {
            orientation = "ERROR";
        }
        return orientation;
    }

    public void printPosition() {
        System.out.println("[Drone X: " + x + ", Y: " + y + ", Z: " + z + ", Orientation: " + calculateOrientation() + "]");
    }
}
