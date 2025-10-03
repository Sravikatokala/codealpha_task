import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grades.add(grade);
        } else {
            System.out.println("Invalid grade. Please enter a value between 0 and 100.");
        }
    }

    public double getAverageScore() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public double getHighestScore() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return Collections.max(grades);
    }

    public double getLowestScore() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return Collections.min(grades);
    }

    public List<Double> getGrades() {
        return grades;
    }
}
