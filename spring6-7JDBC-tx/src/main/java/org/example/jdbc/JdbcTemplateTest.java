package org.example.jdbc;

import org.example.jdbc.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 测试jdbc 完成 CRUD 单表操作
     */
    @Test
    public void test01(){
        String sql = "insert into t_emp values (null,?,?,?)";// 修改一样 改一个sql
        //修改功能
        //String sql = "update t_emp set name=? where id=?";
        //int result = jdbcTemplate.update(sql, "张三atguigu", 1);

        //删除功能
        //String sql = "delete from t_emp where id=?";
        //int result = jdbcTemplate.update(sql, 1);
        int update = jdbcTemplate.update(sql, "李四", 10, "男");
        System.out.println(update);
    }


    /**
     * 查询单条数据用对象接收数据，打印对应
     */
    @Test
    public void test02(){
        // 写法1
        String sql = "select * from t_emp where id=?";
        Emp emp = jdbcTemplate.queryForObject(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                Emp emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setSex(rs.getString("sex"));
                return emp;
            }
        }, 1);

        // 写法2
        Emp emp1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println("写法1："+emp);
        System.out.println("写法2："+emp1);
    }

    /**
     * 查询列表 List
     */
    @Test
    public void test03(){
        String sql = "select * from t_emp";
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(query);
    }


}
