package com.haier.wetestgo.service;

import com.haier.wetestgo.util.DateFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

import static freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

/**
 * The type Report word servlet.
 *
 * @author libin1@kjtpay.com
 * @date 2018/2/8
 */
@WebServlet(name = "ReportWordServlet")
public class ReportWordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String testId = request.getParameter("testId");

        List<Map<String, Object>> arrayList = new ArrayList<>();
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
        arrayList.add(mapTest);
        //TODO 在调用工具类生成Word文档之前应当检查所有字段是否完整，否则Freemarker的模板在处理时可能会因为找不到值而报错
        File file = null;
        InputStream fin = null;
        OutputStream out = null;
        try {
            Map root = new HashMap<String, Object>();
            root.put("questTitle", "测试报告word文档导出");
            root.put("exams", arrayList);

            Configuration configuration = new Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            configuration.setDefaultEncoding("utf-8");

            String templatePath = request.getSession().getServletContext().getRealPath("/view/");
            configuration.setDirectoryForTemplateLoading(new File(templatePath));

            String name = "temp" + (new Random().nextInt() * 100000) + ".doc";

            file = new File(name);
            Template t = configuration.getTemplate("wordReportTemplate.ftl");

            Writer w = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            t.process(root, w);
            w.flush();
            w.close();

            fin = new FileInputStream(file);
            response.setContentType("application/ms-word;charset=utf-8");
            // 设置浏览器以下载的方式处理该文件
            response.addHeader("Content-Disposition", "attachment;filename=Report_"+ DateFormat.getCurrentTime("yyyyMMdd_HHmmss")+".doc");

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
