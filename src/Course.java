public class Course {
    private String name;
    private double credit;
    private String letter;

    public Course(String name, double credit, String letter) {
        this.name = name;
        this.credit = credit;
        this.letter = letter;
    }

    public double getCredit() {
        return credit;
    }

    public String getLetter() {
        return letter;
    }

    public String getName() {
        return name;
    }
}
