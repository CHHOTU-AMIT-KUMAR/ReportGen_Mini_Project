package com.jrtp.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jrtp.entity.CitizenPlansInfoEntity;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	public void generatePdf(HttpServletResponse response,List<CitizenPlansInfoEntity> records,File f) throws Exception
	{
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document,response.getOutputStream());

		PdfWriter.getInstance(document,new FileOutputStream(f));
    	document.open();
    	Paragraph p=new Paragraph("Citizen Plans Info");
    	
    	
    			
               
    	
    	document.add(p);
    	
    	PdfPTable table=new PdfPTable(7);
    	table.setWidthPercentage(100); // Set table width to 100%
    	table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); // Center-align cell content
    	table.getDefaultCell().setPadding(5); 
    
  
    	 table.addCell("ID");
         table.addCell("Citizen Name");
         table.addCell("Gender");
         table.addCell("Plan Start Date");
         table.addCell("Plan End Date");
         table.addCell("Plan Status");
         table.addCell("Plan Benefit");
         
         
         
     	for(CitizenPlansInfoEntity plan:records)
     	{
     		 table.addCell(String.valueOf(plan.getCitizenId()));
             table.addCell(plan.getCitizenName());
             table.addCell(plan.getGender());
             table.addCell(String.valueOf(plan.getPlanStartDate()));
             table.addCell(String.valueOf(plan.getPlanEndDate()));
             table.addCell(plan.getPlanStatus());
             table.addCell(String.valueOf(plan.getBenifitAmount()));

     		
     	}
     	document.add(table);
    	document.close();
	}
}
