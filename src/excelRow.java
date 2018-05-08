import java.util.Random;

public class excelRow {
	int studentID;
	String major;
	String standing;
	int grade;
	String prereqs;
	String letter;
	
	
	public static int generateRandomStudentID(int min, int max) {
		Random random = new Random();
		return random.nextInt(max) + min;
	}
	
	public static String generateRandomMajor() {
		Random random = new Random();
		String[] listOfMajors = {"Aerospace Engineering", "African American Studies", "Business Economics",  
								"Biomedical Engineering", "Chemistry", "Chinese Studies", 
								"History", "Music", "Pharmaceutical Sciences", 
								"Philosophy", "Software Engineering", "Spanish"};
		
		return listOfMajors[random.nextInt(12) + 0];		
	}
	
	public static String generateRandomStanding() {
		Random random = new Random();
		String [] listOfStandings = {"Freshman", "Sophomore", "Junior", "Senior"};
		
		return listOfStandings[random.nextInt(4) + 0];
	}
		
	public static int generateRandomGrade() {
		Random random = new Random();
		
		return random.nextInt(100) + 0;
	}
	
	public static String generateRandomPrereqs() {
		Random random = new Random();
		String [] listOfPrereqs = {"Y", "N"};
		
		return listOfPrereqs[random.nextInt(2) + 0];
	}
	
	public static String generateLetter(int grade) {
		if (grade >= 90) {
			return "A";
		}
		else if (grade >= 80) {
			return "B";
		}
		else if (grade >= 70) {
			return "C";
		}
		else if (grade >= 60) {
			return "D";
		}
		else {
			return "F";
		}
	}
	
	public excelRow() {
		studentID = generateRandomStudentID(0, 9999);
		major = generateRandomMajor();
		standing = generateRandomStanding();
		grade = generateRandomGrade();
		prereqs = generateRandomPrereqs();
		letter = generateLetter(grade);
	}
}
