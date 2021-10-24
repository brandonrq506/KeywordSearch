
package CellStyles;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ICellStyle {
    
    XSSFCellStyle style;
    
    protected abstract void create(XSSFWorkbook wb);
    
    public XSSFCellStyle apply(){
        return style;
    }
}
