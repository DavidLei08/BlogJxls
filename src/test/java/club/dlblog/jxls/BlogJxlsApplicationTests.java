package club.dlblog.jxls;

import club.dlblog.jxls.service.ExcelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.HandlerAdapter;

import java.io.File;
import java.util.*;

@SpringBootTest
class BlogJxlsApplicationTests {

    @Autowired
    ExcelService excelService;

    @Test
    void contextLoads() {
        Map<String, Object> params = new HashMap();
        List<UserModel> list = new ArrayList<>();
        list.add(new UserModel(1, "test01", "男", 25, "tttttttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(2, "test02", "男", 20, "tttttttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(3, "test04", "女", 25, "ttttddddasdadatttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(4, "test08", "男", 20, "ttttttdasdatttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(5, "test021", "女", 25, "ttttdatttttt",new Date(),"htpp://wwww.baidu.com"));
        list.add(new UserModel(7, "test041", "男", 25, "ttdadatttttttt",new Date(),"htpp://wwww.baidu.com"));

		params.put("list", list);
        excelService.getExcel("t1.xlsx", params, new File("D:\\test05.xlsx"));
    }

}
