package com.jrtp.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrtp.dto.SearchRequest;
import com.jrtp.entity.CitizenPlansInfoEntity;
import com.jrtp.service.ReportService;
import com.jrtp.service.Impl.ReportServiceImpl;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	@Autowired
	private ReportService service;
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception
	{
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=\"file-plans.xls\"");
		service.exportExcel(response);
		
	}
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception
	{
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=\"plans.pdf\"");
		service.exportPdf(response);
		
	}
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request,Model model)
	{
		System.out.println(request);
		List<CitizenPlansInfoEntity> plans=service.search(request);
		model.addAttribute("plans",plans);
		init(model);
		return "index";
	}
	
	@GetMapping("/")
	public String indexPage(Model model)
	{
		model.addAttribute("search",new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {
		//model.addAttribute("search",new SearchRequest());
		model.addAttribute("names",service.getPlanName());
		
		model.addAttribute("status",service.getPlanStatus());
	}
	
	
}
