package club.dlblog.jxls.util;

import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.WritableCellValue;
import org.jxls.transform.poi.WritableHyperlink;
import org.jxls.util.TransformerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author machenike
 */
public class ExcelUtils {


    /***
     * excel导出到response
     * @param fileName      导出文件名
     * @param templateFile  模板文件地址
     * @param params          数据集合
     * @param response      response
     */
    public static void exportExcel(String fileName, InputStream templateFile, Map<String, Object> params,
                                   HttpServletResponse response) throws IOException {
        response.reset();
        response.setHeader("Accept-Ranges", "bytes");
        OutputStream os = null;
        response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", fileName));
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            os = response.getOutputStream();
            exportExcel(templateFile, params, os);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * 导出excel到输出流中
     * @param templateFile 模板文件
     * @param params 传入参数
     * @param os 输出流
     * @throws IOException
     */
    public static void exportExcel(InputStream templateFile, Map<String, Object> params, OutputStream os) throws IOException {
        try {
            Context context = new Context();
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                //设置参数变量
                context.putVar(key, params.get(key));
            }
            Map<String, Object> myFunction = new HashMap<>();
            myFunction.put("fun", new ExcelUtils());
            // 启动新的jxls-api 加载自定义方法
            Transformer trans = TransformerFactory.createTransformer(templateFile, os);
            JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator) trans.getTransformationConfig().getExpressionEvaluator();
            evaluator.getJexlEngine().setFunctions(myFunction);

            // 载入模板、处理导出
            AreaBuilder areaBuilder = new XlsCommentAreaBuilder(trans);
            List<Area> areaList = areaBuilder.build();
            areaList.get(0).applyAt(new CellRef("sheet1!A1"), context);
            trans.write();
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (os != null) {
                    os.flush();
                    os.close();
                }
                if (templateFile != null) {
                    templateFile.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }
    }

    /**
     * 格式化时间
     */
    public Object formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(date);
            return dateStr;
        }
        return "--";
    }


    /**
     * 设置超链接方法
     */
    public WritableCellValue getLink(String address, String title) {
        return new WritableHyperlink(address, title);
    }

}
