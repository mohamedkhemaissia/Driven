import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//file input stream argument
		FileInputStream fis =new FileInputStream("C://Users//mohamed//Downloads//Classeur1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
int sheets =workbook.getNumberOfSheets();
for(int i=0;i<sheets;i++)
{
	if(workbook.getSheetName(i).equalsIgnoreCase("testdata"));
	XSSFSheet sheet =workbook.getSheetAt(i);
	System.out.println(sheet.getSheetName());
}
	}

}
