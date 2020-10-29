package ua.com.integrity.parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import ua.com.integrity.dto.ExcelData;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<ExcelData> parse (MultipartFile multipartFile) {
        List<ExcelData> excelData = new ArrayList<>();

        try(InputStream file = multipartFile.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            sheet.removeRow(sheet.getRow(0));
            sheet.removeRow(sheet.getRow(1));
            sheet.removeRow(sheet.getRow(2));

            for (Row row : sheet) {
                ExcelData data = new ExcelData();
                int i = 1;
                for (Cell cell : row) {
                    switch (i) {
                        case 1:
                            data.setBpCode(cell.getStringCellValue());
                            break;
                        case 2:
                            data.setObservationArea(cell.getStringCellValue());
                            break;
                        case 3:
                            data.setObservation(cell.getStringCellValue());
                            break;
                        case 4:
                            data.setObservationDescription(cell.getStringCellValue());
                            break;
                        case 5:
                            data.setRootCause(cell.getStringCellValue());
                            break;
                        case 6:
                            data.setRiskType(cell.getStringCellValue());
                            break;
                        case 7:
                            data.setSignificance(cell.getStringCellValue());
                            break;
                        case 8:
                            data.setRiskLevel(cell.getStringCellValue());
                            break;
//9 for risk type -> loading into the process is not required
                        case 10:
                            data.setRiskCategory(cell.getStringCellValue());
                            break;
                        case 11:
                            data.setRecommendations(cell.getStringCellValue());
                            break;
                        case 12:
                            data.setInspector(cell.getStringCellValue());
                            break;
//13 for Görüləcək tədbir/iş, 14 for İcra edən struktur bölmə / şəxs, 15 for İcra prosesinə nəzarət edən məsul struktur bölmə / şəxs, 16 for İcra prosesi üçün nəzərdə tutulan müddət, 17 for Cavab tədbiri, 18 for Məsul strukturun rəyi -> loading into the process is not required
//                    case 19:
//                        data.setPropertyValue("responseMeasure", cell.getStringCellValue());
//                        break;
                        case 19:
                            data.setObservationRepetitionFeature(cell.getStringCellValue());
                            break;
                        case 20:
                            data.setLastObservationYear((int) cell.getNumericCellValue());
                            break;
                        case 21:
                            data.setGeneralCount((int) cell.getNumericCellValue());
                            break;
                        case 22:
                            data.setSampleNumber((int) cell.getNumericCellValue());
                            break;
                        case 23:
                            data.setDeviationCount((int) cell.getNumericCellValue());
                            break;
                        case 24:
                            data.setActualLoss(cell.getNumericCellValue());
                            break;
                        case 25:
                            data.setPotentialLoss(cell.getNumericCellValue());
                            break;
                        case 26:
                            data.setLikelyhood((int) cell.getNumericCellValue());
                            break;
                        case 27:
                            data.setFinancialLoss((int) cell.getNumericCellValue());
                            break;
                        case 28:
                            data.setReputational(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                        case 29:
                            data.setRegulatory(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                        case 30:
                            data.setBusinessProcess(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                        case 31:
                            data.setSeverity(String.valueOf(Math.round(cell.getNumericCellValue() * 100.0) / 100.0));
                            break;
                    }
                    i++;
                }
                excelData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelData;
    }

}
