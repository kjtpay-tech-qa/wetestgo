package com.haier.wetestgo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haier.wetestgo.bean.TestResultDetail;
import com.haier.wetestgo.dao.TestSuiteResultDao;
import com.haier.wetestgo.dao.impl.TestSuiteResultDaoImpl;

/**
 * The type We test servlet.
 *
 * @author libin1@kjtpay.com
 * @date 2018/2/13
 */
@WebServlet(name = "WeTestServlet")
public class WeTestServlet extends HttpServlet {
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Tsr dao.
	 */
	private TestSuiteResultDao tsrDao = new TestSuiteResultDaoImpl();

	/**
	 * Instantiates a new We test servlet.
	 *
	 * @see HttpServlet#HttpServlet() HttpServlet#HttpServlet()
	 */
	public WeTestServlet() {
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
		String test_purpose = request.getParameter("test_purpose");
		String operator = request.getParameter("operator");
		String testId = request.getParameter("testId");
		@SuppressWarnings("rawtypes")
		Map map = new HashMap<>();
		map.put("test_purpose", test_purpose);
		map.put("operator", operator);
		map.put("testId", testId);
		int pageindex = 1;
		int pagesize = 100;
		int startrow = (pageindex-1)*pagesize;
		map.put("startrow", startrow);
		map.put("pagesize", pagesize);
		List<TestResultDetail> testResultDetails = tsrDao.queryResultDetails(map);

		request.setAttribute("list",testResultDetails);

		try {
            request.getRequestDispatcher("WEB-INF/jsp/testResultDetail.jsp").forward(request,
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
