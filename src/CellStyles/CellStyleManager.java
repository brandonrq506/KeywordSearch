
package CellStyles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public final class CellStyleManager {
    
    private BotStyle bot;
    private CustomerStyle customer;
    private FilterPassedStyle passed;
    
    public CellStyleManager(XSSFWorkbook wb){
        create(wb);
    }
    
    private void create(XSSFWorkbook wb){
        bot = new BotStyle(wb);
        customer = new CustomerStyle(wb);
        passed = new FilterPassedStyle(wb);
    }
    
    public void setStyle(Cell cell, int style){
        switch(style){
            case 1:
                cell.setCellStyle(customer.apply());
                break;
            case 3:
                cell.setCellStyle(bot.apply());
                break;
            case 4:
                cell.setCellStyle(passed.apply());
                break;
        }
    }
}
