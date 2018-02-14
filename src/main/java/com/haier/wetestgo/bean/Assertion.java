package com.haier.wetestgo.bean;

import java.util.Date;

/**
 * The type Assertion.
 *
 * @author libin1 @kjtpay.com
 * @date 2018 /2/1
 */
public class Assertion {
    /**
     * The Assert id.
     */
    private int assertId;
    /**
     * The Case id.
     */
    private int caseId;

    /**
     * The Team id.
     */
    private int teamId;
    /**
     * The Env id.
     */
    private String environment;
    /**
     * The Type.
     */
    private int type;
    /**
     * The Statement.
     */
    private String statement;
    /**
     * The Gmt create.
     */
    private Date gmtCreate;
    /**
     * The Gmt update.
     */
    private Date gmtUpdate;

    /**
     * Gets assert id.
     *
     * @return the assert id
     */
    public int getAssertId() {
        return assertId;
    }

    /**
     * Sets assert id.
     *
     * @param assertId the assert id
     */
    public void setAssertId(int assertId) {
        this.assertId = assertId;
    }

    /**
     * Gets case id.
     *
     * @return the case id
     */
    public int getCaseId() {
        return caseId;
    }

    /**
     * Sets case id.
     *
     * @param caseId the case id
     */
    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    /**
     * Gets env id.
     *
     * @return the env id
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * Sets env id.
     *
     * @param environment the env id
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Gets statement.
     *
     * @return the statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Sets statement.
     *
     * @param statement the statement
     */
    public void setStatement(String statement) {
        this.statement = statement;
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

    /**
     * Gets team id.
     *
     * @return the team id
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Sets team id.
     *
     * @param teamId the team id
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
