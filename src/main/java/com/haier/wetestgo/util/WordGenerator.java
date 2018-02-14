package com.haier.wetestgo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

/**
 * The type Word generator.
 *
 * @author libin1@kjtpay.com
 * @date 2018/2/13
 */
public class WordGenerator {
    /**
     * The All templates.
     */
    private Map<String, Template> allTemplates;
    private String templateName;

    /**
     * Instantiates a new Word generator.
     *
     * @param templatePath the template path
     * @param templateName the template name
     */
    public WordGenerator(String templatePath, String templateName) {
        this.templateName = templateName;
        Configuration configuration = new Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding("utf-8");
//        configuration.setClassForTemplateLoading(WordGenerator.class, "");
        try {
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        allTemplates = new HashMap<>();
        try {
            allTemplates.put(templateName, configuration.getTemplate(templateName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Instantiates a new Word generator.
     */
    private WordGenerator() {
        throw new AssertionError();
    }

    /**
     * Create doc file.
     *
     * @param dataMap      the data map
     * @param templateName the template name
     * @param document     the document
     * @return the file
     */
    public File createDoc(Map dataMap, File document) {
        Template template = allTemplates.get(templateName);
        try {
            //这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer writer = new OutputStreamWriter(new FileOutputStream(document), "utf-8");
            template.process(dataMap, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return document;
    }

    /**
     * 将图片转换成BASE64字符串.
     *
     * @param in the in
     * @return the image string
     * @throws IOException the io exception
     */
    public String getImageString(InputStream in) throws IOException {
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


    /**
     * Inputstreamtofile.
     *
     * @param ins  the ins
     * @param file the file
     */
    public void inputstreamtofile(InputStream ins, File file) {
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
