package com.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nit.model.Employee;

@Component("excel_report")
public class ExcelReportView extends AbstractXlsView {

	private int i = 1;

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		//get Model attributes data
		List<Employee> list = (List<Employee>) map.get("empsList");
		//get excel sheet in workbook
		Sheet sheet1 = workbook.createSheet("Employee");
		//create heading row in sheet
		Row row = sheet1.createRow(0);
		row.createCell(0).setCellValue("EMPNO");
		row.createCell(1).setCellValue("EMPNAME");
		row.createCell(2).setCellValue("JOB");
		row.createCell(3).setCellValue("SAL");
		row.createCell(4).setCellValue("DEPTNO");

		list.forEach(emp->{
			//Add row to excel sheet
			Row row1 = sheet1.createRow(i);
			//Add cells to row
			row1.createCell(0).setCellValue(emp.getEmpno());
			row1.createCell(1).setCellValue(emp.getEname());
			row1.createCell(2).setCellValue(emp.getJob());
			row1.createCell(3).setCellValue(emp.getSal());
			if(emp.getDeptno()!=null)
				row1.createCell(4).setCellValue(emp.getDeptno());
			i++;
		});
	}//method

}
