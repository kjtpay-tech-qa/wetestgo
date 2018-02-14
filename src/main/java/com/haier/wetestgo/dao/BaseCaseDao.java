package com.haier.wetestgo.dao;

import com.haier.wetestgo.bean.Assertion;
import com.haier.wetestgo.bean.BaseCase;

import java.util.List;
import java.util.Map;

/**
 * 操作基线测试用例接口.
 *
 * @author libin1@kjtpay.com
 * @date 2018/1/29
 */
public interface BaseCaseDao {
    /**
     * Gets base case.
     *
     * @param sqlStatement the sql statement
     * @return the base case
     */
    List<BaseCase> getBaseCase(String sqlStatement);

    /**
     * Filter base case list.
     *
     * @param map the map
     * @return the list
     */
    List<BaseCase> filterBaseCase(Map map);


    /**
     * Gets assertion.
     *
     * @param map the map
     * @return the assertion
     */
    List<Assertion> getAssertion(Map map);
}
