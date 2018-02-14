package com.haier.wetestgo.dao;

import com.haier.wetestgo.bean.DatabaseCfg;
import com.haier.wetestgo.bean.FunctionCfg;
import com.haier.wetestgo.bean.ServiceCfg;

import java.util.Map;

/**
 * 获取公共配置接口.
 *
 * @author libin1@kjtpay.com
 * @date 2018/1/26
 */
public interface CommConfigDao {

    /**
     * Gets team name map.
     *
     * @param teamId the team id
     * @return the team name map
     */
    Map<Integer, String> getTeamNameMap(Integer teamId);

    /**
     * Gets database map.
     *
     * @param databaseId the database id
     * @return the database map
     */
    Map<Integer, DatabaseCfg> getDatabaseMap(Integer databaseId);

    /**
     * Gets environment map.
     *
     * @param env the environment
     * @return the environment map
     */
    Map<String, String> getEnvironmentMap(String... env);

    /**
     * Gets service map.
     *
     * @param serviceId the service id
     * @return the service map
     */
    Map<Integer, ServiceCfg> getServiceMap(Integer serviceId);


    Map<String, String> getServiceNameMap(String... serviceName);

    /**
     * Gets function map.
     *
     * @param functionId the function id
     * @return the function map
     */
    Map<Integer, FunctionCfg> getFunctionMap(Integer functionId);
}
