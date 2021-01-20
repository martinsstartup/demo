package com.personal.dcso.view.model;

public class RaciQuestion {
    private String id;
    private String text;
    private String helpText;
    private int excelRowNum;
    private int excelColumnNum;

    public int getExcelRowNum() {
        return excelRowNum;
    }

    public void setExcelRowNum(int excelRowNum) {
        this.excelRowNum = excelRowNum;
    }

    public int getExcelColumnNum() {
        return excelColumnNum;
    }

    public void setExcelColumnNum(int excelColumnNum) {
        this.excelColumnNum = excelColumnNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }
}
