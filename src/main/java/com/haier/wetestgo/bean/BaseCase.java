package com.haier.wetestgo.bean;

import java.util.Date;

/**
 * 基线测试用例.
 *
 * @author libin1@kjtpay.com
 * @date 2018/1/27
 */
public class BaseCase {
    private int caseId;
    private int isRun;
    private int teamId;
    private String environment;
    private int serviceId;
    private int functionId;
    private String comment;
    private String operationSteps;
    private int caseLevel;
    private String preAction;
    private int excutionMode;
    private String executionPostAction;
    private String postAction;
    private Date gmtCreate;
    private Date gmtUpdate;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getIsRun() {
        return isRun;
    }

    public void setIsRun(int isRun) {
        this.isRun = isRun;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getFunctionId() {
        return functionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOperationSteps() {
        return operationSteps;
    }

    public void setOperationSteps(String operationSteps) {
        this.operationSteps = operationSteps;
    }

    public int getCaseLevel() {
        return caseLevel;
    }

    public void setCaseLevel(int caseLevel) {
        this.caseLevel = caseLevel;
    }

    public String getPreAction() {
        return preAction;
    }

    public void setPreAction(String preAction) {
        this.preAction = preAction;
    }

    public int getExcutionMode() {
        return excutionMode;
    }

    public void setExcutionMode(int excutionMode) {
        this.excutionMode = excutionMode;
    }

    public String getExecutionPostAction() {
        return executionPostAction;
    }

    public void setExecutionPostAction(String executionPostAction) {
        this.executionPostAction = executionPostAction;
    }

    public String getPostAction() {
        return postAction;
    }

    public void setPostAction(String postAction) {
        this.postAction = postAction;
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
}
