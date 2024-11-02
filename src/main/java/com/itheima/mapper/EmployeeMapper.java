package com.itheima.mapper;

import com.itheima.pojo.Employee;
import com.itheima.pojo.EmployeeQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询用户
     */
    @Select("select * from tb_employee where username = #{username} and password = #{password} and status = 1")
    Employee selectByUsernameAndPass(Employee employee);

    /**
     * 新增员工
     */
    @Insert("insert into tb_employee (username, name, email, note, status, create_time, update_time) " +
            "values (#{username}, #{name},  #{email}, #{note}, #{status}, #{createTime}, #{updateTime})")
    void insert(Employee employee);

    /**
     * 动态条件查询
     */
    List<Employee> list(EmployeeQueryParam queryParam);

    /**
     * 更新员工
     */
    void update(Employee employee);

    /**
     * 根据ID查询员工信息
     */
    @Select("select id, username, name, password, email, note, status, create_time, update_time from tb_employee where id = #{id}")
    Employee getById(Integer id);

    /**
     * 根据ID删除员工信息
     */
    @Delete("delete from tb_employee where id = #{id}")
    void deleteById(Integer id);
}
