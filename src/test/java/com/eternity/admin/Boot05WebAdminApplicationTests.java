package com.eternity.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {
//        jdbcTemplate.queryForList("select * from t_user",);
        Integer integer = jdbcTemplate.queryForObject("select count(*) from t_user", Integer.class);
        log.info("记录总数={}",integer);
        log.info("数据源类型={}",dataSource.getClass());
    }

}
