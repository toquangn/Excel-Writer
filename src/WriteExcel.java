import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;


public class WriteExcel {
	public static void createExcel(File f) throws WriteException {
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(f);
			WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
			workbook.write();
			workbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void writeExcel(File f) throws WriteException {
		try {
			Workbook workbook = Workbook.getWorkbook(f);
			WritableWorkbook copy = Workbook.createWorkbook(f, workbook);
			WritableSheet copySheet = copy.getSheet(0);
			
			//Adding headers for excel sheet 
			Label studentID = new Label(0, 0, "Student ID");
			copySheet.addCell(studentID);
			
			Label major = new Label(1, 0, "Major");
			copySheet.addCell(major);
			
			Label standing = new Label(2, 0, "Standing");
			copySheet.addCell(standing);
			
			Label grade = new Label(3, 0, "Grade");
			copySheet.addCell(grade);
			
			Label prereqs = new Label(4, 0, "Prerequisites");
			copySheet.addCell(prereqs);
			
			Label letters = new Label(5, 0, "Letters");
			copySheet.addCell(letters);
			
			// Loop starts at 1 to accommodate headers in first row
			for (int i = 1; i <= 40; i++) {
				// Instantiate a new excelRow with predefined values generated from constructor
				excelRow row = new excelRow();
				
				// Student ID
				Number tempID = new Number(0, i, row.studentID);
				copySheet.addCell(tempID);
				
				// Major
				Label tempMajor = new Label(1, i, row.major);
				copySheet.addCell(tempMajor);
				
				// Standing
				Label tempStanding = new Label(2, i, row.standing);
				copySheet.addCell(tempStanding);
				
				// Grade
				Number tempGrade = new Number(3, i, row.grade);
				copySheet.addCell(tempGrade);
				
				// Prerequisites
				Label tempPrereqs = new Label(4, i, row.prereqs);
				copySheet.addCell(tempPrereqs);
				
				// Letters
				Label tempLetter = new Label(5, i, row.letter);
				copySheet.addCell(tempLetter);
			}
			
			copy.write();
			copy.close();
			System.out.println("here");
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException, WriteException {
		// Create excel file with specified file name
		String fileName = "excel.xls";
		File excelFile = new File(fileName);
		
		// If the file does not exist, create it
		if (!excelFile.exists()) {
			createExcel(excelFile);
		}
		
		// Otherwise append onto it
		else {
			writeExcel(excelFile);
		}

	}
}
