package com.jrtp.service.Impl;

import com.jrtp.dto.SearchRequest;
import com.jrtp.entity.CitizenPlansInfoEntity;
import com.jrtp.repository.CitizenPlansInfoEntityRepository;
import com.jrtp.service.ReportService;
import com.jrtp.utils.EmailUtils;
import com.jrtp.utils.ExcelGenerator;
import com.jrtp.utils.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
	List<CitizenPlansInfoEntity> records;
	
	
	private EmailUtils emailUtils;
    private CitizenPlansInfoEntityRepository planRepo;
    private ExcelGenerator excelGenerate;
	private PdfGenerator pdfGenerate;
	public ReportServiceImpl(CitizenPlansInfoEntityRepository planRepo, ExcelGenerator excelGenerate,
			PdfGenerator pdfGenerate,EmailUtils emailUtils) {
		super();
		this.planRepo = planRepo;
		this.excelGenerate = excelGenerate;
		this.pdfGenerate = pdfGenerate;
		this.emailUtils=emailUtils;
	}


    @Override
    public List<String> getPlanName() {
        return planRepo.getPlanName();
    }

    @Override
    public List<String> getPlanStatus() {
        return planRepo.getPlanStatus();
    }

    @Override
    public List<CitizenPlansInfoEntity> search(SearchRequest req) {
    	CitizenPlansInfoEntity entity=new CitizenPlansInfoEntity();
//    	BeanUtils.copyProperties(req, entity);
    	if(null!=req.getPlanName() && !"".equals(req.getPlanName())) {
    		entity.setPlanName(req.getPlanName());
    	}
    	if(null!=req.getPlanStatus() && !"".equals(req.getPlanStatus())) {
    		entity.setPlanStatus(req.getPlanStatus());
    	}
    	if(null!=req.getGender() && !"".equals(req.getGender())) {
    		entity.setGender(req.getGender());
    	}
    	if(null!=req.getPlanStartDate() && !"".equals(req.getPlanStartDate())) {
    		entity.setPlanStartDate(req.getPlanStartDate());
    	}
    	if(null!=req.getPlanEndDate() && !"".equals(req.getPlanEndDate())) {
    		entity.setPlanEndDate(req.getPlanEndDate());
    	}
    	records=planRepo.findAll(Example.of(entity));
        return records;
    }

    @Override
    public boolean exportExcel(HttpServletResponse response) throws Exception{
    	File f=new File("plans.xls");
    	
    	excelGenerate.generateExcel(response,records,f);
    	String subject="Test Mail Subject";
    	String body="<h1> Test Mail Body </h1>";
    	String to="chhotu8676@gmail.com";
    	emailUtils.sendEmail(subject, body, to,f);
        return true;
    }

    @Override
    public boolean exportPdf(HttpServletResponse response) throws Exception{
    	File f=new File("Plans.pdf");
    	pdfGenerate.generatePdf(response, records,f);
    	String subject="Test Mail Subject";
    	String body="<h1> Test Mail Body </h1>";
    	String to="chhotu8676@gmail.com";
    	emailUtils.sendEmail(subject, body, to,f);
        return true;
    }

    @Override
    public SearchRequest genAllPlans() {
    	
        return null;
    }
}
