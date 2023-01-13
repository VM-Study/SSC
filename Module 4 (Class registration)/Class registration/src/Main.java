public class Main {
    public static void main(String[] args) {
        College college = new College("Seminole State College");
        college.registerCourse("COP2800", "Programming in Java");
        college.registerCourse("COP2805", "Advanced Java Programming");
        college.registerCourse("CEN3024", "Software Development I");
        college.registerCourse("CEN4025", "Software Development II");
        college.registerCourse("COP4655", "Application Develop for Mobile Devices");
        college.registerCourse("COP4813", "Web Applications Programming");
        college.registerCourse("ISM3113", "Information Systems Analysis and Design");

        college.addPreRequiresForCourse("COP2805", "COP2800");
        college.addPreRequiresForCourse("CEN3024", "COP2805");
        college.addPreRequiresForCourse("CEN4025", "CEN3024");
        college.addPreRequiresForCourse("COP4655", "COP2805");
        college.addPreRequiresForCourse("COP4813", "COP2805");
        college.addPreRequiresForCourse("COP4813", "CEN4025");
        college.addPreRequiresForCourse("COP4813", "COP4655");

        long studentID1 = college.registerUser("Darci","Hagan");
        college.addStudentCourse(studentID1, "COP2805", true);
        college.addStudentCourse(studentID1, "CEN3024", true);
        college.addStudentCourse(studentID1, "CEN4025", true);
        long studentID2 = college.registerUser("Nolan","Escobar");
        college.addStudentCourse(studentID2, "COP2805", true);
        college.addStudentCourse(studentID2, "CEN3024", true);
        long studentID3 = college.registerUser("Benjamin","Wilde");
        college.addStudentCourse(studentID3, "COP2805", true);
        college.addStudentCourse(studentID3, "CEN3024", true);

//        college.printAllCourses();
        college.studentStatus(studentID2);
        college.addStudentCourse(studentID2, "ISM3113", false);
        college.addStudentCourse(studentID2, "CEN4025", false);
        college.printStudentClasses(studentID2);

        System.out.println();
        college.addStudentCourse(studentID2, "COP4813", false);
        college.printStudentClasses(studentID2);



        System.out.println();
    }
}
