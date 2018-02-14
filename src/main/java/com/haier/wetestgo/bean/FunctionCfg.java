package com.haier.wetestgo.bean;

/**
 * 各应用服务的功能点配置.
 *
 * @author libin1 @kjtpay.com
 * @date 2018 /1/27
 */
public class FunctionCfg {
    private int functionId;
    private int teamId;
    private int serviceId;
    private String comment;

    public int getFunctionId() {
        return functionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
