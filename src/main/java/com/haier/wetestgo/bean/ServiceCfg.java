package com.haier.wetestgo.bean;

/**
 * 应用服务名配置.
 *
 * @author libin1@kjtpay.com
 * @date 2018/1/27
 */
public class ServiceCfg {
    private int serviceId;
    private String serviceName;
    private String comment;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
