package com.haier.wetestgo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.haier.wetestgo.dao.impl.CaseResultDetailDaoImpl;
import com.haier.wetestgo.bean.CaseResultDetail;
import com.haier.wetestgo.dao.CaseResultDetailDao;

/**
 * Servlet implementation class CaseResultDetailServlet
 */
@WebServlet("/caseResultDetail")
public class CaseResultDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CaseResultDetailDao crdDao = new CaseResultDetailDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaseResultDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		HttpSession session = request.getSession();
		String testSuiteId = request.getParameter("testSuiteId");
		@SuppressWarnings("rawtypes")
		Map map = new HashMap<>();
		map.put("testSuiteId", testSuiteId);
		int pageindex = 1;
		int pagesize = 100;
		int startrow = (pageindex-1)*pagesize;
		map.put("startrow", startrow);
		map.put("pagesize", pagesize);
		List<CaseResultDetail> caseResultDetails = crdDao.queryCaseResultDetailsByTestSuiteId(map);
		List<CaseResultDetail> caseResultDetailsNew = new ArrayList<>();
		for(CaseResultDetail caseResultDetail : caseResultDetails) {
			String inputParams = caseResultDetail.getInputParams();
			String outputParams = caseResultDetail.getOutputParams();
			String baselineParams = caseResultDetail.getBaselineParams();
			
			inputParams = JSON.toJSONString(JSON.parseObject(inputParams), SerializerFeature.PrettyFormat);
			outputParams = JSON.toJSONString(JSON.parseObject(outputParams), SerializerFeature.PrettyFormat);
			baselineParams = JSON.toJSONString(JSON.parseObject(baselineParams), SerializerFeature.PrettyFormat);
			
			caseResultDetail.setInputParams(inputParams);
			caseResultDetail.setBaselineParams(baselineParams);
			caseResultDetail.setOutputParams(outputParams);
			caseResultDetailsNew.add(caseResultDetail);
		}
		request.setAttribute("list",caseResultDetailsNew);
		
		try {
            request.getRequestDispatcher("caseResultDetail.jsp").forward(request,
                    response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
