package com.haier.wetestgo.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "")
public class WeTestController {
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

}
