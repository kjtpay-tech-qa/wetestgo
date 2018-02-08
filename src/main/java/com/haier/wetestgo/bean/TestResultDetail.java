package com.haier.wetestgo.bean;

import java.util.Date;

/**
 * @ClassName: TestResultDetail
 * @Description: 整份测试用例执行结果
 * @author libin1@kjtpay.com.cn
 * @date 2017年9月12日 下午4:36:18 
 */
public class TestResultDetail {
	private int testId;
	
	private String result;
	
	private int suiteResultId;
	
	private int testSuiteId;
	
	private String serviceName;
	
	private String interfaceName;
	
	private String environment;
	
	private String suiteResult;
	
	private String testPurpose;
	
	private String operator;
	
	private int passedCases;
	
	private int executedCases;
	
	private int totalCases;
	
	private String passedRate;
	
	private Date gmtCreate;
	
	private Date gmtUpdate;
	
	private String suiteFile;

	public int getSuiteResultId() {
		return suiteResultId;
	}

	public void setSuiteResultId(int suiteResultId) {
		this.suiteResultId = suiteResultId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getSuiteResult() {
		return suiteResult;
	}

	public void setSuiteResult(String suiteResult) {
		this.suiteResult = suiteResult;
	}

	public int getPassedCases() {
		return passedCases;
	}

	public void setPassedCases(int passedCases) {
		this.passedCases = passedCases;
	}

	public int getExecutedCases() {
		return executedCases;
	}

	public void setExecutedCases(int executedCases) {
		this.executedCases = executedCases;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	public String getPassedRate() {
		return passedRate;
	}

	public void setPassedRate(String passedRate) {
		this.passedRate = passedRate;
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

	public String getSuiteFile() {
		return suiteFile;
	}

	public void setSuiteFile(String suiteFile) {
		this.suiteFile = suiteFile;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTestPurpose() {
		return testPurpose;
	}

	public void setTestPurpose(String testPurpose) {
		this.testPurpose = testPurpose;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getTestSuiteId() {
		return testSuiteId;
	}

	public void setTestSuiteId(int testSuiteId) {
		this.testSuiteId = testSuiteId;
	}
	
	
	
}
