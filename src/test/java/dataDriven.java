import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

    public static void main(String[] args) throws IOException {
        // File input stream argument
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        try {
            fis = new FileInputStream("C://Users//mohamed//Downloads//Classeur1.xlsx");
            workbook = new XSSFWorkbook(fis);

            int sheets = workbook.getNumberOfSheets();
            for (int i = 0; i < sheets; i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    // Identify test cases column by scanning the entire 1st row
                    Iterator<Row> rows = sheet.iterator(); // Sheet is a collection of rows
                    Row firstRow = rows.next();
                    Iterator<Cell> ce = firstRow.cellIterator(); // Row is a collection of cells

                    int k = 0;
                    int column = -1; // Initialize column to an invalid index
                    while (ce.hasNext()) {
                        Cell value = ce.next();
                        if (value.getStringCellValue().equalsIgnoreCase("data2")) {
                            column = k;
                            break;
                        }
                        k++;
                    }

                    if (column == -1) {
                        System.out.println("Column 'data2' not found.");
                        return;
                    }

                    System.out.println("Column index of 'data2': " + column);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }
}