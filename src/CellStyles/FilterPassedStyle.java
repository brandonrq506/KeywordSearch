
package CellStyles;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class FilterPassedStyle extends ICellStyle{
    
    public FilterPassedStyle(XSSFWorkbook wb){
        create(wb);
    }

    @Override
    protected void create(XSSFWorkbook wb) {
        super.style = wb.createCellStyle();
        //Agregar cosas especificas para mensajes que pasen filtro
        //super.style.setWrapText(true);
        super.style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        super.style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    }
}
