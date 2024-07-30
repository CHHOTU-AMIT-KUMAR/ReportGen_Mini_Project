package com.jrtp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Data
@Entity
@Table(name = "citizen_plans_info_entity")
public class CitizenPlansInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citizen_id", nullable = false)
    private Long citizenId;

    @Column(name = "termination_reason")
    private String terminationReason;

    @Column(name = "denial_reason")
    private String denialReason;

    @Column(name = "benifit_amount")
    private Long benifitAmount;

    @Column(name = "plan_end_date")
    private LocalDate planEndDate;

    @Column(name = "plan_start_date")
    private LocalDate planStartDate;

    @Column(name = "plan_status", nullable = false, length = 20)
    private String planStatus;

    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(name = "gender", nullable = false, length = 8)
    private String gender;

    @Column(name = "citizen_name", nullable = false, length = 100)
    private String citizenName;

	public Long getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}

	public String getTerminationReason() {
		return terminationReason;
	}

	public void setTerminationReason(String terminationReason) {
		this.terminationReason = terminationReason;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public Long getBenifitAmount() {
		return benifitAmount;
	}

	public void setBenifitAmount(Long benifitAmount) {
		this.benifitAmount = benifitAmount;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	

}