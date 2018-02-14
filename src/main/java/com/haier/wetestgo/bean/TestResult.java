package com.haier.wetestgo.bean;

import java.util.Date;

/**
 * The type Test result.
 *
 * @author libin1 @kjtpay.com
 * @date 2018 /2/13
 */
public class TestResult {
    /**
     * The Test id.
     */
    private int testId;
    /**
     * The Test purpose.
     */
    private String testPurpose;
    /**
     * The Result.
     */
    private String result;
    /**
     * The Operator.
     */
    private String operator;
    /**
     * The Gmt create.
     */
    private Date gmtCreate;
    /**
     * The Gmt update.
     */
    private Date gmtUpdate;

    /**
     * Gets test id.
     *
     * @return the test id
     */
    public int getTestId() {
        return testId;
    }

    /**
     * Sets test id.
     *
     * @param testId the test id
     */
    public void setTestId(int testId) {
        this.testId = testId;
    }

    /**
     * Gets test purpose.
     *
     * @return the test purpose
     */
    public String getTestPurpose() {
        return testPurpose;
    }

    /**
     * Sets test purpose.
     *
     * @param testPurpose the test purpose
     */
    public void setTestPurpose(String testPurpose) {
        this.testPurpose = testPurpose;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Gets operator.
     *
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets operator.
     *
     * @param operator the operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Gets gmt create.
     *
     * @return the gmt create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Sets gmt create.
     *
     * @param gmtCreate the gmt create
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Gets gmt update.
     *
     * @return the gmt update
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * Sets gmt update.
     *
     * @param gmtUpdate the gmt update
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
