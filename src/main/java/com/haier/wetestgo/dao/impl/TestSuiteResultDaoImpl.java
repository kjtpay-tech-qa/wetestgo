package com.haier.wetestgo.dao.impl;

import java.util.List;
import java.util.Map;

import com.haier.wetestgo.bean.TestResultDetail;
import com.haier.wetestgo.dao.TestSuiteResultDao;
import com.haier.wetestgo.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class TestSuiteResultDaoImpl implements TestSuiteResultDao {
	@Override
	public List<TestResultDetail> queryResultDetailsByTestPurposeAndOperator(@SuppressWarnings("rawtypes") Map map) {
		MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;

		SqlSession session = null;  
        try{
            session= MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "com.haier.wetestgo.bean.TestSuiteResultMapper.queryResultDetailsByTestPurposeAndOperator";
            List<TestResultDetail> testResultDetails = session.selectList(statement, map);
            session.commit();
            return testResultDetails;
        }catch(Exception e){
            e.printStackTrace();
            if(session != null) {
            	session.rollback();
            }
        }finally{
            if(session != null){
                session.close();
            }
        }
        return null;
	}
	

}
