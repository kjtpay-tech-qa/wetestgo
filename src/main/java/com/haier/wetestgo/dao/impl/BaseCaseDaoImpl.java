package com.haier.wetestgo.dao.impl;

import com.haier.wetestgo.bean.BaseCase;
import com.haier.wetestgo.dao.BaseCaseDao;
import com.haier.wetestgo.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 操作基线测试用例接口实现.
 *
 * @author libin1@kjtpay.com
 * @date 2018/1/29
 */
public class BaseCaseDaoImpl implements BaseCaseDao {
    @Override
    public List<BaseCase> getBaseCase(String sqlStatement) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;
        List<BaseCase> baseCaseList = new ArrayList<>();
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CaseUseageMapper.getBaseCase";
            baseCaseList = session.selectList(statement, sqlStatement);
            session.commit();
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
        return baseCaseList;
    }

    @Override
    public List<BaseCase> filterBaseCase(Map map) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;
        List<BaseCase> baseCaseList = new ArrayList<>();
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CaseUseageMapper.filterBaseCase";
            baseCaseList = session.selectList(statement, map);
            session.commit();
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
        return baseCaseList;
    }


}
