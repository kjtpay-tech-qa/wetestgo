package com.haier.wetestgo.dao;

import java.util.List;
import java.util.Map;

import com.haier.wetestgo.bean.TestResultDetail;

public interface TestSuiteResultDao {
	/**
	 * queryResultDetails: 根据测试目的和执行人，查询测试结果.
	 * @author libin1@kjtpay.com.cn
	 * @param @param map
	 * @param @return 
	 * @return List<TestResultDetail>
	 */
	List<TestResultDetail> queryResultDetails(@SuppressWarnings("rawtypes") Map map);
	
}
