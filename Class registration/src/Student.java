import java.util.*;

public class Student {
    private final String firstName;
    private final String lastName;
    private final long id;
    private final Set<Course> currentCourses = new TreeSet<>(Comparator.comparing(Course::getCode));
    private final Set<Course> finishedCourses = new TreeSet<>(Comparator.comparing(Course::getCode));

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getId() {
        return id;
    }

    public Set<Course> getCurrentCourses() {
        return currentCourses;
    }

    public Set<Course> getFinishedCourses() {
        return finishedCourses;
    }
}
