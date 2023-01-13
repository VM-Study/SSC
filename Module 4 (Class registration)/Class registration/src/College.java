import java.util.*;

public class College {
    private final String name;
    private final Set<Course> coursesList = new TreeSet<>(Comparator.comparing(Course::getCode));
    private final List<Student> studentsList = new ArrayList<>();

    public College(String name) {
        this.name = name;
    }

    public long registerUser(String firstName, String lastName) {
        Student student = createNewStudent(firstName, lastName);
        studentsList.add(student);
        return student.getId();
    }

    private Student createNewStudent(String firstName, String lastName) {
        return new Student(firstName, lastName, generateStudentId());
    }

    private int generateStudentId() {
        while (true) {
            int id = (int) (Math.random() * 1000000) + 100000;
            if (findStudentById(id) == null) {
                return id;
            }
        }
    }

    public void addStudentCourse(long studentId, String code, boolean isCourseDone) {
        Course course = findCourse(code);
        Student student = findStudentById(studentId);
        if (course == null || student == null) {
            throw new RuntimeException("Course or Student not found.");
        }
        if (isCourseDone) {
            student.getFinishedCourses().add(course);
        } else if (checkCourseRequirements(student, course)) {
            student.getCurrentCourses().add(course);
            System.out.println("[" + course.getCode() + "] - " + course.getName() + " added to the schedule.");
        } else {
            System.out.println("[" + course.getCode() + "] - " + course.getName() + " cannot be added. The requirements are not met.");
        }

    }

    private boolean checkCourseRequirements(Student student, Course course) {
        return course.getPreRequiresCourses().stream()
                .allMatch(preRequiresCourses -> student.getFinishedCourses().contains(preRequiresCourses));
    }

    public void registerCourse(String code, String name) {
        coursesList.add(createNewCourse(code, name));
    }

    public void addPreRequiresForCourse(String classCode, String preRequiresClassCode) {
        Course course = findCourse(classCode);
        Course preRequiresCourse = findCourse(preRequiresClassCode);
        if (course == null || preRequiresCourse == null) {
            throw new RuntimeException("Course not found.");
        }
        if (!course.getPreRequiresCourses().contains(preRequiresCourse)) {
            course.getPreRequiresCourses().add(preRequiresCourse);
        }
    }

    private Student findStudentById(long id) {
        return studentsList.stream()
                .filter(student -> student.getId() == id)
                .findAny()
                .orElse(null);
    }

    private Course findCourse(String code) {
        return coursesList.stream()
                .filter(course -> course.getCode().equals(code))
                .findAny()
                .orElse(null);
    }

    private Course createNewCourse(String code, String name) {
        return new Course(code, name);
    }

    public void printAllCourses() {
        coursesList.stream()
                .forEach(course -> {
                            System.out.println("[" + course.getCode() + "] - " + course.getName());
                            course.getPreRequiresCourses().stream()
                                    .forEach(preCourse -> System.out.println("     (required) [" + preCourse.getCode() + "] - " + preCourse.getName()));
                        }
                );
    }

    public void printStudentClasses(long id) {
        Student student = findStudentById(id);
        if (student == null) {
            throw new RuntimeException("Student not found.");
        }

        System.out.println("Finished Courses:");
        student.getFinishedCourses().stream()
                .forEach(course -> System.out.println("  + [" + course.getCode() + "] - " + course.getName()));


        System.out.println("Current Courses:");
        student.getCurrentCourses().stream()
                .forEach(course -> System.out.println("  * [" + course.getCode() + "] - " + course.getName()));

    }

    public void studentStatus(long id) {
        Student student = findStudentById(id);
        if (student == null) {
            throw new RuntimeException("Student not found.");
        }
        System.out.println("[College: " + name + "]");
        System.out.println("    Student: " + student.getFirstName() + " " + student.getLastName()
                + ", ID: " + student.getId());
    }
}
