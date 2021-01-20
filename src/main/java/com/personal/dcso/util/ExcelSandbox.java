package com.personal.dcso.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.personal.dcso.view.model.QuestionnaireQuestion;
import com.personal.dcso.view.model.RaciQuestion;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelSandbox {
    public static void main(String[] args) throws Exception {
        Workbook workbook = WorkbookFactory.create(new FileInputStream("c:/tmp/raci_question_input.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        //ArrayList<QuestionnaireQuestion> questionnaireQuestions = new ArrayList<>();
        ArrayList<RaciQuestion> raciQuestions = new ArrayList<>();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            RaciQuestion question = new RaciQuestion();
            question.setId(getCellValueAsString(currentRow.getCell(0)));
            question.setText(getCellValueAsString(currentRow.getCell(1)));
            question.setHelpText(getCellValueAsString(currentRow.getCell(2)));
            question.setExcelRowNum(parseInteger(getCellValueAsString(currentRow.getCell(3))));
            question.setExcelColumnNum(parseInteger(getCellValueAsString(currentRow.getCell(4))));
            raciQuestions.add(question);
//            QuestionnaireQuestion question = new QuestionnaireQuestion();
//            question.setId(getCellValueAsString(currentRow.getCell(0)));
//            question.setRiskAssessmentCategory(getCellValueAsString(currentRow.getCell(1)));
//            question.setRiskAssessmentReference(getCellValueAsString(currentRow.getCell(2)));
//            question.setText(getCellValueAsString(currentRow.getCell(3)));
//            question.setOptionsCommentsOnImpact(getCellValueAsString(currentRow.getCell(4)));
//            question.setExcelRowNumber(parseInteger(getCellValueAsString(currentRow.getCell(5))));
//            questionnaireQuestions.add(question);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter("C:/tmp/raci_questions.json");
        gson.toJson(raciQuestions, fw);
        fw.flush();
        fw.close();
//            Iterator<Cell> cellIterator = currentRow.iterator();
//
//            while (cellIterator.hasNext()) {
//
//                Cell currentCell = cellIterator.next();
//
//                if (currentCell.getCellType() == CellType.STRING) {
//                    System.out.print(currentCell.getStringCellValue() + "--");
//                } else if (currentCell.getCellType() == CellType.NUMERIC) {
//                    System.out.print(currentCell.getNumericCellValue() + "--");
//                }
//
//
//            }
//            System.out.println();

        System.out.println();
    }

    private static String getCellValueAsString(Cell cell) {

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        }
        return null;
    }

    private static int parseInteger(String value) {
        System.out.println("value to parse: "+value);
        try {
            return (int) Double.parseDouble(value);
        } catch (Exception ex) {
            return -1;

        }
    }
}



