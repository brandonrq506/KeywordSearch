/**
 * Clase encargadad de recibir las conversaciones que pasen el filtro
 * y escribirlas en el directorio correcto, con el nombre correcto.
 */
package FileHandling;

import CellStyles.CellStyleManager;
import Conversations.*;
import GUI.FileExplorers.ExplorerFile;
import Sorting.ByDisposition;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Conversation will be printed with the following 'header' Disposition
 * Transcript Email Phone Number Conversation
 */
public class ExcelWriterNoMatch implements IFileHandler {

    private CellStyleManager cellStyle;

    private ExplorerFile fiEx;
    private XSSFWorkbook wb;
    private XSSFSheet ss;

    private int rowNum;
    private Cell cell;
    private Row row;

    //La nueva version no tendra esta lista, ya que la lista vendrrá de
    //Filter Manager
    private List<Conversation> conversations;

    public ExcelWriterNoMatch(ExplorerFile fiEx) throws FileNotFoundException {
        this.fiEx = fiEx;
        this.conversations = new ArrayList<>();
    }

    public int getChatsFound() {
        return this.conversations.size();
    }

    //MISSING THE FUNCION TO WRITE THE ADDITIONAL COLUMNS
    public void write() {
        sortList(conversations);
        //shuffle();
        for (Conversation c : conversations) {

            addColumn(c.getDisposition());
            addColumn(c.getTranscriptId());
            addAdditionalColumns(c.getAdditionalColumns());

            if (c.getMessagesCount() > 0) {

                c.getAllMessages().forEach(m -> {
                    addRow(m.getText());
                    cellStyle.setStyle(cell, m.getSender());
                });
            }
            conversationSeparator();
        }
    }

    @Override
    public void open() throws FileNotFoundException {
        this.wb = new XSSFWorkbook();
        this.ss = wb.createSheet("NoMatches");
        sheetConfig();
    }

    @Override
    public void close() {
        System.out.println("Total: " + conversations.size());
        try {
            try (
                     FileOutputStream out = new FileOutputStream(new File("E:\\Ramirez\\Downloads\\" + "NOmatch.xlsx"))) {
                wb.write(out);
                System.out.println("File closed");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Error writing back");
        }
    }

    private List<Conversation> sortList(List<Conversation> conversationsList) {
        Collections.sort(conversationsList, new ByDisposition());
        return conversationsList;
    }

    private void shuffle() {
        Collections.shuffle(conversations);
    }

    //this needs to improve so we can print more colums with additional info if needed
    private void addRow(String text) {
        this.row = ss.createRow(++rowNum);
        this.cell = row.createCell(0);
        this.cell.setCellValue(text);
    }

    private void addAdditionalColumns(List<String> columns) {
        columns.forEach(text -> this.addColumn(text));
    }

    private void addColumn(String text) {
        int newColumnIndex;
        try {
            newColumnIndex = this.cell.getColumnIndex() + 1;
        } catch (Exception e) {
            this.cell = row.createCell(1);
            newColumnIndex = this.cell.getColumnIndex();
        }
        this.cell = row.createCell(newColumnIndex);
        this.cell.setCellValue(text);
    }

    private void conversationSeparator() {
        this.row = ss.createRow(++rowNum);
        this.row = ss.createRow(++rowNum);
    }

    public void addConverastions(List<Conversation> conversation) {
        this.conversations.addAll(conversation);
    }

    private void sheetConfig() {
        ss.setDisplayGridlines(false);
        ss.setColumnWidth(0, 42000);
        ss.setZoom(150);
        this.row = ss.createRow(++rowNum);
        cellStyle = new CellStyleManager(wb);
    }
}
