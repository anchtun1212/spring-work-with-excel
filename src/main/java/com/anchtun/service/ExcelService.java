package com.anchtun.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelService() {
		this.workbook = new XSSFWorkbook();
	}

	private void writeHeader(String sheetName, List<String> headers) {
		sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(15);
		style.setFont(font);

		for (int i = 0; i < headers.size(); i++) {
			createCell(row, i, headers.get(i), style);
		}
	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void write(List<Map<Integer, String>> listData) {
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Map<Integer, String> map : listData) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			for (Integer key : map.keySet()) {
				createCell(row, columnCount++, map.get(key), style);
			}
		}
	}

	public void generate(HttpServletResponse response, String sheetName, List<Map<Integer, String>> listData, List<String> headers) throws IOException {
		writeHeader(sheetName, headers);
		write(listData);
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
