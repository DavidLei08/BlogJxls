package club.dlblog.jxls.service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.util.Map;

/**
 * excel用service
 */
public interface ExcelService {

    /**
     * 导出excel,写入输出流中
     * @param templateFile
     * @param params
     * @param os
     * @return
     */
    boolean getExcel(String templateFile,Map<String,Object> params, OutputStream os);

    /**
     * 导出excel，写入response中
     * @param templateFile
     * @param fileName
     * @param params
     * @param response
     * @return
     */
    boolean getExcel(String templateFile,String fileName, Map<String,Object> params, HttpServletResponse response);

    /**
     * 导出excel,写入文件中
     * @param templateFile
     * @param params
     * @param outputFile
     * @return
     */
    boolean getExcel(String templateFile, Map<String,Object> params, File outputFile);
}
