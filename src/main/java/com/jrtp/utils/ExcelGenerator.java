package com.jrtp.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.jrtp.entity.CitizenPlansInfoEntity;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator{
	
	public void generateExcel(HttpServletResponse response,List<CitizenPlansInfoEntity> records,File f)  throws Exception{
		Workbook workbook =new HSSFWorkbook();
    	Sheet sheet=workbook.createSheet("plans-data");
    	Row headerrow=sheet.createRow(0);
    	headerrow.createCell(0).setCellValue("ID");
    	headerrow.createCell(1).setCellValue("citizenName");
    	headerrow.createCell(2).setCellValue("Gender");
    	headerrow.createCell(3).setCellValue("PlanStartDate");
    	headerrow.createCell(4).setCellValue("PlanEndDate");
    	headerrow.createCell(5).setCellValue("PlanStatus");
    	headerrow.createCell(6).setCellValue("PlanBenifit");
    	
//    	List<CitizenPlansInfoEntity> records=planRepo.findAll();
    	int datarow=1;
    	for(CitizenPlansInfoEntity plan:records)
    	{
    		Row row=sheet.createRow(datarow);
    		row.createCell(0).setCellValue(plan.getCitizenId());
    		row.createCell(1).setCellValue(plan.getCitizenName());
    		row.createCell(2).setCellValue(plan.getGender());
    		row.createCell(3).setCellValue(String.valueOf(plan.getPlanStartDate()));
    		row.createCell(4).setCellValue(String.valueOf(plan.getPlanEndDate()));
    		row.createCell(5).setCellValue(plan.getPlanStatus());
    		
    		row.createCell(6).setCellValue(String.valueOf(plan.getBenifitAmount()));
    		datarow++;
    	}
    	 
    	FileOutputStream fos=new FileOutputStream(f);
    	workbook.write(fos);
    	fos.close();
    	
    	ServletOutputStream outputstream=response.getOutputStream();
    	workbook.write(outputstream);
    	workbook.close();
		
	}
}
