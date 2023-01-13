import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String code;
    private final String name;
    private final List<Course> preRequiresCourses = new ArrayList<>();

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Course> getPreRequiresCourses() {
        return preRequiresCourses;
    }
}
