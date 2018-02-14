package com.haier.wetestgo.dao.impl;

import com.haier.wetestgo.bean.TestResult;
import com.haier.wetestgo.bean.TestResultDetail;
import com.haier.wetestgo.dao.TestResultDao;
import com.haier.wetestgo.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestResultDaoImpl implements TestResultDao {
    @Override
    public TestResult queryTestResult(Integer testId) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;

        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "TestResultMapper.queryTestResult";
            TestResult testResult = session.selectOne(statement, testId);
            session.commit();
            return testResult;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
