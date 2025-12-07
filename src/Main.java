import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        System.out.println("=== Transcript GPA Calculator ===");

        while (true) {
            System.out.print("Ders adı: ");
            String name = scanner.nextLine();

            System.out.print("Kredi: ");
            double credit = Double.parseDouble(scanner.nextLine());

            System.out.print("Harf Notu (AA, BA, BB, CB, CC, DC, DD, FD, FF): ");
            String letter = scanner.nextLine();

            // Ders nesnesi oluştur
            Course course = new Course(name, credit, letter);
            courses.add(course);

            System.out.print("Başka ders eklemek ister misiniz? (E/H): ");
            String cont = scanner.nextLine();

            if (cont.equalsIgnoreCase("H")) break;
        }

        double termGPA = TranscriptCalculator.calculateTermGPA(courses);

        System.out.print("\nÖnceki AGNO (CGPA): ");
        double prevCGPA = Double.parseDouble(scanner.nextLine());

        System.out.print("Şu ana kadar tamamlanan kredi: ");
        double prevCredits = Double.parseDouble(scanner.nextLine());

        double termCredits = 0;
        for (Course c : courses) termCredits += c.getCredit();

        double newCGPA = TranscriptCalculator.calculateNewCGPA(prevCGPA, prevCredits, termGPA, termCredits);

        System.out.println("\n==============================");
        System.out.println("DÖNEM AGNO (GPA): " + String.format("%.2f", termGPA));
        System.out.println("GÜNCEL GENEL AGNO (CGPA): " + String.format("%.2f", newCGPA));
        System.out.println("==============================");
    }
}
