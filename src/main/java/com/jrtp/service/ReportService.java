package com.jrtp.service;

import com.jrtp.dto.SearchRequest;
import com.jrtp.entity.CitizenPlansInfoEntity;

import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface ReportService {
    public List<String> getPlanName();
    public List<String> getPlanStatus();

    List<CitizenPlansInfoEntity> search(SearchRequest req);

    public boolean exportExcel(HttpServletResponse response) throws Exception;
    public boolean exportPdf(HttpServletResponse response) throws Exception;
    public SearchRequest genAllPlans();



}
