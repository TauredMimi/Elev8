import java.util.Scanner;
import java.util.ArrayList;

public class cgpaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the CGPA Calculator! Calculate as much Courses as possible, type result to finish the calculation");

        int totalGradeUnits = 0;
        double totalGradePoints = 0.0;

        ArrayList<courses> courses = new ArrayList<>();
        
        boolean first = true;

        while (true) {
            System.out.print("Enter course code: ");
            String courseCode = scanner.nextLine();

            if (courseCode.equalsIgnoreCase("Result")) {
                break;
            }

            System.out.print("Enter course units: ");
            int courseUnits = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter score: ");
            int score = Integer.parseInt(scanner.nextLine());

            courses course = new courses(courseCode, courseUnits, score);
            courses.add(course);

            totalGradeUnits += course.getCourseUnits();
            totalGradePoints += calculateGradePoints(course.getScore()) * (course.getCourseUnits());

            if (!first){
                System.out.println("If that's all, type 'Result' to finish or keep computing your grades.");
            }
            first = false;
        }

        // Display table header
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        for (courses course : courses) {
            String grade = calculateGrade(course.getScore());
            int gradeUnit = calculateGradePoints(course.getScore());
            System.out.printf("| %-27s| %-22d| %-11s| %-20d|%n", course.getCourseCode(), course.getCourseUnits(), grade, gradeUnit);
        }
        // Display table footer
        System.out.println("|---------------------------------------------------------------------------------------|");

        if (totalGradeUnits > 0) {
            double CGPA = totalGradePoints / totalGradeUnits;
            System.out.printf("Your CGPA is = %.2f to 2 decimal places.%2Remember hardwork pays", CGPA);
        } else {
            System.out.println("No courses entered. CGPA cannot be calculated.");
        }

        scanner.close();
    }

    private static int calculateGradePoints(int score) {
        if (score >= 70 && score <= 100) {
            return 5;
        } else if (score >= 60 && score <= 69) {
            return 4;
        } else if (score >= 50 && score <= 59) {
            return 3;
        } else if (score >= 45 && score <= 49) {
            return 2;
        } else if (score >= 40 && score <= 44) {
            return 1;
        } else {
            return 0;
        }
    }

    private static String calculateGrade(int score) {
        if (score >= 70 && score <= 100) {
            return "A";
        } else if (score >= 60 && score <= 69) {
            return "B";
        } else if (score >= 50 && score <= 59) {
            return "C";
        } else if (score >= 45 && score <= 49) {
            return "D";
        } else if (score >= 40 && score <= 44) {
            return "E";
        } else {
            return "F";
        }
    }
}