package com.haier.wetestgo.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.haier.wetestgo.bean.TestResult;
import com.haier.wetestgo.bean.TestResultDetail;
import com.haier.wetestgo.dao.CommConfigDao;
import com.haier.wetestgo.dao.TestResultDao;
import com.haier.wetestgo.dao.TestSuiteResultDao;
import com.haier.wetestgo.dao.impl.CommConfigDaoImpl;
import com.haier.wetestgo.dao.impl.TestResultDaoImpl;
import com.haier.wetestgo.dao.impl.TestSuiteResultDaoImpl;
import com.haier.wetestgo.util.DateFormat;
import com.haier.wetestgo.util.WordGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/caseResult")
public class CaseResultController {
    @ResponseBody
    @RequestMapping(value = "recordTable.do", method = RequestMethod.GET)
    public String recordTable() {
        return "请求参数填写出错或必填参数未填写";
    }

    @RequestMapping(value = "upload.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void upload(MultipartFile file) throws IOException {

        File f = new File(file.getName());
        if (!f.exists()) {
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(f));
            stream.write(file.getBytes());
            stream.flush();
            stream.close();

        } else {

        }
    }

    @RequestMapping(value = "welcome.do", method = RequestMethod.GET)
    public ModelAndView getFirstPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("welcom");
        modelAndView.addObject("name", "FreeMarkerView");
        return modelAndView;
    }

    @RequestMapping(value = "report2word.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView report2word(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView("wordReportTemplate");
        Map mapTest = new HashMap();
        mapTest.put("testId", "123");
        mapTest.put("series", "范围");
        mapTest.put("environment", "准生产");
        mapTest.put("service", "网关");
        mapTest.put("interfaceName", "query");
        mapTest.put("operator", "libin");
        mapTest.put("date", "20180211");
        mapTest.put("testResult", "pass");
        mapTest.put("result", "pass");
        List<Map<String, Object>> arrayList = new ArrayList<>();
        arrayList.add(mapTest);

        modelAndView.addObject("exams", arrayList);

        return modelAndView;
    }

    @RequestMapping(value = "sendReport.do", method = RequestMethod.GET)
    public void sendReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");

        String testId = request.getParameter("testId");
        Map map = new HashMap<String, Object>();
        map.put("testId", testId);
        TestSuiteResultDao testSuiteResultDao = new TestSuiteResultDaoImpl();
        List<TestResultDetail> testResultDetails = testSuiteResultDao.queryResultDetails(map);

        TestResultDao testResultDao = new TestResultDaoImpl();
        TestResult testResult =  testResultDao.queryTestResult(Integer.valueOf(testId));

        map.put("operator", testResult.getOperator());
        map.put("date", DateFormat.Date2String(testResult.getGmtCreate(), "yyyy-MM-dd HH:mm:ss"));
        map.put("testResult", testResult.getResult());

        List<Map<String, Object>> sets = new ArrayList<>();
        Map set = new HashMap<String, Object>();

        CommConfigDao commConfigDao = new CommConfigDaoImpl();
        Map serviceNameMap = commConfigDao.getServiceNameMap();
        Map environmentMap = commConfigDao.getEnvironmentMap();

        StringBuilder stringBuilder = new StringBuilder();

        Map interfaceMap = new HashMap();
        for(TestResultDetail testResultDetail : testResultDetails) {
            stringBuilder.append(testResultDetail.getInterfaceName() + ",");
            interfaceMap.put(testResultDetail.getServiceName(), stringBuilder);
        }

        for(TestResultDetail testResultDetail : testResultDetails) {
            if(!set.containsValue(testResultDetail.getServiceName())) {
                String serviceName = testResultDetail.getServiceName();
                set.put("serviceName", serviceName);
                set.put("comment", serviceNameMap.get(serviceName));
                set.put("environment", environmentMap.get(testResultDetail.getEnvironment()));
                set.put("result", testResultDetail.getResult());

                set.put("interfaceName", interfaceMap.get(serviceName));


                sets.add(set);
            }
        }
        map.put("sets", sets);


        File file = null;
        InputStream fin = null;
        OutputStream out = null;
        try {

            String templatePath = request.getSession().getServletContext().getRealPath("/view/");

            WordGenerator wordGenerator = new WordGenerator(templatePath, "wordReportTemplate.ftl");

            String name = "Report_" + DateFormat.getCurrentTime("yyyyMMdd_HHmmss") + ".doc";
            file = new File(name);
            file = wordGenerator.createDoc(map, file);

            fin = new FileInputStream(file);
            response.setContentType("application/ms-word;charset=utf-8");
            // 设置浏览器以下载的方式处理该文件
            response.addHeader("Content-Disposition", "attachment;filename="+name);

            out = response.getOutputStream();
            // 缓冲区
            byte[] buffer = new byte[512];
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (fin != null) {
                fin.close();
            }
            if (out != null) {
                out.close();
            }
            if (file != null) {
                file.delete();
            }
        }



    }


    @RequestMapping(value = "downloadReport.do", method = RequestMethod.GET)
    @ResponseBody
    public void downloadReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");

        String testId = request.getParameter("testId");

        List<Map<String, Object>> arrayList = new ArrayList<>();
        Map mapTest = new HashMap();
        mapTest.put("testId", testId);
        mapTest.put("series", "范围");
        mapTest.put("environment", "准生产");
        mapTest.put("service", "网关");
        mapTest.put("interfaceName", "query");
        mapTest.put("operator", "libin");
        mapTest.put("date", "20180211");
        mapTest.put("testResult", "pass");
        mapTest.put("result", "pass");
        arrayList.add(mapTest);
        //TODO 在调用工具类生成Word文档之前应当检查所有字段是否完整，否则Freemarker的模板在处理时可能会因为找不到值而报错
        File file = null;
        InputStream fin = null;
        OutputStream out = null;
        try {
            Map root = new HashMap<String, Object>();
            root.put("questTitle", "测试报告word文档导出");
            root.put("exams", arrayList);

            String templatePath = request.getSession().getServletContext().getRealPath("/view/");

            WordGenerator wordGenerator = new WordGenerator(templatePath, "wordReportTemplate.ftl");

            String name = "Report_" + DateFormat.getCurrentTime("yyyyMMdd_HHmmss") + ".doc";
            file = new File(name);
            file = wordGenerator.createDoc(root, file);

            fin = new FileInputStream(file);
            response.setContentType("application/ms-word;charset=utf-8");
            // 设置浏览器以下载的方式处理该文件
            response.addHeader("Content-Disposition", "attachment;filename="+name);

            out = response.getOutputStream();
            // 缓冲区
            byte[] buffer = new byte[512];
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (fin != null) {
                fin.close();
            }
            if (out != null) {
                out.close();
            }
            if (file != null) {
                file.delete();
            }
        }
    }
}
