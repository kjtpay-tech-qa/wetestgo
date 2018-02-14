package com.haier.wetestgo.dao;

import com.haier.wetestgo.bean.TestResult;

public interface TestResultDao {
    TestResult queryTestResult(Integer testId);
}
