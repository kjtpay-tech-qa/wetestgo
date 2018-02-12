package com.haier.wetestgo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

public class WordGenerator {
    private static Map<String, Template> allTemplates = null;
//    private static InputStream inputStream = WordGenerator.class.getResourceAsStream("com/haier/wetestgo/template/wordReportTemplate.ftl");

    //    private static File file = new File("wordReportTemplate.ftl");
    static {
        Configuration configuration = new Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding("utf-8");
//        configuration.setClassForTemplateLoading(WordGenerator.class, "");
        try {
            String templatePath = WordGenerator.class.getClassLoader().getResource("/template").getPath();
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        allTemplates = new HashMap<>();
        try {
            allTemplates.put("resume", configuration.getTemplate("wordReportTemplate.ftl"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private WordGenerator() {
        throw new AssertionError();
    }

    public static File createDoc(Map<?, ?> dataMap, String type) {
        String name = "temp" + (new Random().nextInt() * 100000) + ".doc";

        File f = new File(name);
        Template t = allTemplates.get(type);
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.flush();
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }

    //将图片转换成BASE64字符串
    public static String getImageString(InputStream in) throws IOException {
        //InputStream in = null;
        byte[] data = null;
        try {
            // in = new FileInputStream(filename);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return data != null ? encoder.encode(data) : "";
    }


    public static void inputstreamtofile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];

            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
