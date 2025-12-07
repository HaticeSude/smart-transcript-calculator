import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TranscriptCalculator {

    private static final Map<String, Double> gradePoints = new HashMap<>();

    static {
        gradePoints.put("AA", 4.0);
        gradePoints.put("BA", 3.5);
        gradePoints.put("BB", 3.0);
        gradePoints.put("CB", 2.5);
        gradePoints.put("CC", 2.0);
        gradePoints.put("DC", 1.5);
        gradePoints.put("DD", 1.0);
        gradePoints.put("FD", 0.5);
        gradePoints.put("FF", 0.0);
    }

    public static double getPoint(String letter) {
        return gradePoints.getOrDefault(letter.toUpperCase(), -1.0);
    }

    public static double calculateCourseGPA(Course course) {
        double gradeValue = getPoint(course.getLetter());
        if (gradeValue < 0) return 0;
        return gradeValue * course.getCredit();
    }

    public static double calculateTermGPA(ArrayList<Course> courses) {
        double totalPoints = 0;
        double totalCredits = 0;

        for (Course course : courses) {
            totalPoints += calculateCourseGPA(course);
            totalCredits += course.getCredit();
        }

        if (totalCredits == 0) return 0;
        return totalPoints / totalCredits;
    }

    public static double calculateNewCGPA(double previousCGPA, double previousCredits,
                                          double termGPA, double termCredits) {

        double totalQualityPoints = (previousCGPA * previousCredits) + (termGPA * termCredits);
        double totalCredits = previousCredits + termCredits;

        if (totalCredits == 0) return 0;
        return totalQualityPoints / totalCredits;
    }
}
