package club.dlblog.jxls;


import java.util.Date;

public class UserModel {

    private  Integer id;

    private String name;

    private String sex;

    private Integer age;

    private String remark;

    private Date date;

    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public UserModel(Integer id, String name, String sex, Integer age, String remark) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.remark = remark;
    }

    public UserModel(Integer id, String name, String sex, Integer age, String remark, Date date, String link) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.remark = remark;
        this.date = date;
        this.link = link;
    }
}
