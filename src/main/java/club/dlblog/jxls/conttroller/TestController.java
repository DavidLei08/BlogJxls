package club.dlblog.jxls.conttroller;

import club.dlblog.jxls.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.util.*;

@RestController
public class TestController {
    @Autowired
    ExcelService excelService;

    @RequestMapping("test")
    public void testFile(HttpServletResponse response){
        Map<String, Object> params = new HashMap();
        List<UserModel> list = new ArrayList<>();
        list.add(new UserModel(1, "test01", "男", 25, "tttttttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(2, "test02", "男", 20, "tttttttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(3, "test04", "女", 25, "ttttddddasdadatttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(4, "test08", "男", 20, "ttttttdasdatttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(5, "test021", "女", 25, "ttttdatttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(7, "test041", "男", 25, "ttdadatttttttt",new Date(),"htpp://wwww.baidu.com"));

        params.put("list", list);
        excelService.getExcel("t1.xlsx",System.currentTimeMillis()+".xlsx", params,response);
    }
}
