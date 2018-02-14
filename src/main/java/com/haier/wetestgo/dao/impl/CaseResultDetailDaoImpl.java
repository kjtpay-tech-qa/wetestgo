package com.haier.wetestgo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.haier.wetestgo.bean.CaseResultDetail;
import com.haier.wetestgo.dao.CaseResultDetailDao;
import com.haier.wetestgo.util.MyBatisUtil;
import com.haier.wetestgo.util.MyBatisUtil.DataSourceEnvironment;

public class CaseResultDetailDaoImpl implements CaseResultDetailDao {
    @Override
    public List<CaseResultDetail> queryCaseResultDetailsByTestSuiteId(@SuppressWarnings("rawtypes") Map map) {
        DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;

        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CaseResultDetailMapper.queryCaseResultDetailsByTestSuiteId";
            List<CaseResultDetail> caseResultDetails = session.selectList(statement, map);
            session.commit();
            return caseResultDetails;
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
