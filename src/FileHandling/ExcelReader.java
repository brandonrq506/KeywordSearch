/**
 * Clase encargadad de recolectar las filas del excel con todas las columnas
 * que posean informacion. Posee metodos para iterar sobre el excel.
 */
package FileHandling;

import GUI.FileExplorers.ExplorerFile;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements IFileHandler {

    private ExplorerFile fiEx;
    private List<String> rowValues;

    private InputStream file;
    private XSSFWorkbook wb;
    private XSSFSheet ss;

    private Iterator<Row> rowIter;
    private Iterator<Cell> cellIter;
    private Row row;

    public ExcelReader(ExplorerFile fiEx) throws IOException {
        this.fiEx = fiEx;
        rowValues = new ArrayList<>();
        open();
        setUpExcel();
        createIterators();
    }

    @Override
    public final void open() throws FileNotFoundException {
        File[] fileList = fiEx.getFiles();
        File firstFile = fileList[0];
        this.file = new BufferedInputStream(new FileInputStream(firstFile.getAbsoluteFile()));
    }

    private void setUpExcel() throws IOException {
        this.wb = new XSSFWorkbook(file);
        this.ss = wb.getSheetAt(0);
    }

    private void createIterators() {
        this.rowIter = ss.iterator();
        this.row = rowIter.next();   //This is to not having to delete header rows
    }

    @Override
    public void close() throws IOException {
        file.close();
    }

    public boolean hasNext() {
        return this.rowIter.hasNext();
    }

    public List<String> getNext() {
        row = rowIter.next();
        cellIter = row.cellIterator();
        rowValues.clear();

        while (cellIter.hasNext()) {
            Cell cell = cellIter.next();
            switch (cell.getCellType()) {
                case NUMERIC:
                    rowValues.add(String.valueOf(cell.getNumericCellValue()));
                    break;
                case STRING:
                    rowValues.add(cell.getStringCellValue());
                    break;
            }
        }
        return rowValues;
    }
}
