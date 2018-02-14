package com.haier.wetestgo.dao.impl;

import com.haier.wetestgo.bean.DatabaseCfg;
import com.haier.wetestgo.bean.FunctionCfg;
import com.haier.wetestgo.bean.ServiceCfg;
import com.haier.wetestgo.dao.CommConfigDao;
import com.haier.wetestgo.util.FblMapResultHandler;
import com.haier.wetestgo.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取公共配置接口实现.
 *
 * @author libin1@kjtpay.com
 * @date 2018/1/31
 */
public class CommConfigDaoImpl implements CommConfigDao {
    @Override
    public Map<Integer, String> getTeamNameMap(Integer teamId) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;
        Map map = new HashMap();
        SqlSession session = null;
        try {
            FblMapResultHandler fbl = new FblMapResultHandler();
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CommConfigMapper.getTeamNameMap";
            session.select(statement, teamId, fbl);
            map = fbl.getMappedResults();
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
        return map;
    }

    @Override
    public Map<Integer, DatabaseCfg> getDatabaseMap(Integer databaseId) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;
        Map map = new HashMap();
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CommConfigMapper.getDatabaseMap";
            List<DatabaseCfg> databaseCfgs = session.selectList(statement, databaseId);
            for(DatabaseCfg databaseCfg : databaseCfgs) {
                map.put(databaseCfg.getDatabaseId(), databaseCfg);
            }
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
        return map;
    }

    @Override
    public Map<String, String> getEnvironmentMap(String... env) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;
        Map map = new HashMap();
        SqlSession session = null;
        try {
            FblMapResultHandler fbl = new FblMapResultHandler();
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CommConfigMapper.getEnvironmentMap";
            if(env.length == 0) {
                session.select(statement, null, fbl);
                map = fbl.getMappedResults();
            }else if(env.length == 1) {
                session.select(statement, env[0], fbl);
                map = fbl.getMappedResults();
            }
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
        return map;
    }

    @Override
    public Map<Integer, ServiceCfg> getServiceMap(Integer serviceId) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;
        Map map = new HashMap();
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CommConfigMapper.getServiceMap";
            List<ServiceCfg> serviceCfgs = session.selectList(statement, serviceId);
            for(ServiceCfg serviceCfg : serviceCfgs) {
                map.put(serviceCfg.getServiceId(), serviceCfg);
            }
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
        return map;
    }

    @Override
    public Map<String, String> getServiceNameMap(String... serviceName) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;
        Map map = new HashMap();
        SqlSession session = null;
        try {
            FblMapResultHandler fbl = new FblMapResultHandler();
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CommConfigMapper.getServiceNameMap";
            if(serviceName.length == 0) {
                session.select(statement, null, fbl);
                map = fbl.getMappedResults();
            }else if(serviceName.length == 1) {
                session.select(statement, serviceName[0], fbl);
                map = fbl.getMappedResults();
            }
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
        return map;
    }

    @Override
    public Map<Integer, FunctionCfg> getFunctionMap(Integer functionId) {
        MyBatisUtil.DataSourceEnvironment environment = MyBatisUtil.DataSourceEnvironment.WETEST;
        Map map = new HashMap();
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory(environment).openSession();
            String statement = "CommConfigMapper.getFunctionMap";
            List<FunctionCfg> functionCfgs = session.selectList(statement, functionId);
            for(FunctionCfg functionCfg : functionCfgs) {
                map.put(functionCfg.getFunctionId(), functionCfg);
            }
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
        return map;
    }
}
