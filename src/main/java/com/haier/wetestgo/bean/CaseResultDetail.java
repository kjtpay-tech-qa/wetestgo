package com.haier.wetestgo.bean;

import java.util.Date;

/**
 * @ClassName CaseResultDetail
 * @Description 单条用例执行详情
 * @author libin1@kjtpay.com.cn
 * @date 2017-11-22
 */
public class CaseResultDetail {

	private int testSuiteId;
	
	private int caseDetailId;
	
	private String caseDescription;
	
	private String inputParams;
	
	private String outputParams;
	
	private String baselineParams;
	
	private Date gmtCreate;
	
	private Date gmtUpdate;
	
	private String caseResult;



	public int getTestSuiteId() {
		return testSuiteId;
	}

	public void setTestSuiteId(int testSuiteId) {
		this.testSuiteId = testSuiteId;
	}

	public int getCaseDetailId() {
		return caseDetailId;
	}

	public void setCaseDetailId(int caseDetailId) {
		this.caseDetailId = caseDetailId;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtUpdate() {
		return gmtUpdate;
	}

	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}

	public String getCaseDescription() {
		return caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}

	public String getInputParams() {
		return inputParams;
	}

	public void setInputParams(String inputParams) {
		this.inputParams = inputParams;
	}

	public String getOutputParams() {
		return outputParams;
	}

	public void setOutputParams(String outputParams) {
		this.outputParams = outputParams;
	}

	public String getBaselineParams() {
		return baselineParams;
	}

	public void setBaselineParams(String baselineParams) {
		this.baselineParams = baselineParams;
	}

	public String getCaseResult() {
		return caseResult;
	}

	public void setCaseResult(String caseResult) {
		this.caseResult = caseResult;
	}
	
	
}
