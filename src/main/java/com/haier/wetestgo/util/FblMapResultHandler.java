package com.haier.wetestgo.util;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Fbl map result handler.
 *
 * @author libin1@kjtpay.com
 * @date 2018/1/27
 */
public class FblMapResultHandler implements ResultHandler {
    /**
     * The Mapped results.
     */
    private final Map mappedResults = new HashMap();
    @Override
    public void handleResult(ResultContext resultContext) {
        Map map = (Map) resultContext.getResultObject();
        mappedResults.put(map.get("key"), map.get("value"));
    }

    /**
     * Gets mapped results.
     *
     * @return the mapped results
     */
    public Map getMappedResults() {
        return mappedResults;
    }
}
