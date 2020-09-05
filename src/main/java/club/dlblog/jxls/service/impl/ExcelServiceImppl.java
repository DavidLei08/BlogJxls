package club.dlblog.jxls.service.impl;

import club.dlblog.jxls.service.ExcelService;
import club.dlblog.jxls.util.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * excel用serviceImpl
 */
@Service
public class ExcelServiceImppl implements ExcelService {

    private static final Logger logger = LoggerFactory.getLogger(ExcelServiceImppl.class);

    /**
     * 模板文件的基础路径
     */
    @Value("${jxls.template.path}")
    private String templatePath;

    @Override
    public boolean getExcel(String templateFile, Map<String, Object> params, OutputStream os) {
        FileInputStream inputStream = null;
        try {
            //获取模板文件的输入流
            inputStream = new FileInputStream(ResourceUtils.getFile(templatePath + templateFile));
            //导出文件到输出流
            ExcelUtils.exportExcel(inputStream, params, os);
        } catch (IOException e) {
            logger.error("excel export has error" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean getExcel(String templateFile, String fileName, Map<String, Object> params, HttpServletResponse response) {
        FileInputStream inputStream = null;
        try {
            //获取模板文件的输入流
            inputStream = new FileInputStream(ResourceUtils.getFile(templatePath + templateFile));
            //导出文件到response
            ExcelUtils.exportExcel(fileName,inputStream,params,response);
        } catch (IOException e) {
            logger.error("excel export has error" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean getExcel(String templateFile, Map<String, Object> params, File outputFile) {
        FileInputStream inputStream = null;
        try {
            //获取模板文件的输入流
            inputStream = new FileInputStream(ResourceUtils.getFile(templatePath + templateFile));
            File dFile = outputFile.getParentFile();
            //文件夹不存在时创建文件夹
            if(dFile.isDirectory()){
                if(!dFile.exists()){
                    dFile.mkdir();
                }
            }
            //文件不存在时创建文件
            if(!outputFile.exists()){
                outputFile.createNewFile();
            }
            //导出excel文件
            ExcelUtils.exportExcel(inputStream, params, new FileOutputStream(outputFile));
        } catch (IOException e) {
            logger.error("excel export has error" + e);
            return false;
        }
        return true;
    }


}
