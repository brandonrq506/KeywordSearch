
package CellStyles;

import java.awt.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class CustomerStyle extends ICellStyle{
    
    public CustomerStyle(XSSFWorkbook wb){
        create(wb);
    }

    @Override
    protected void create(XSSFWorkbook wb) {
        super.style = wb.createCellStyle();
        //Agregar cosas especificas para customer
        //super.style.setWrapText(true);
        XSSFColor myColor = new XSSFColor(new Color(200, 220, 220));
        super.style.setFillForegroundColor(myColor);
        super.style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    }
}
