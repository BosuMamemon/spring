package com.example.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class MemberTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    tbl_member 테이블에 데이터 추가
    @Test
    public void testInsertMember() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO tbl_member(userid, userpw, username) VALUES(?, ?, ?)";
        for(int i = 0; i < 100; i++) {
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(2, passwordEncoder.encode("pw" + i));  // userpw(암호화)
                if(i < 80) {
                    preparedStatement.setString(1, "user" + i);
                    preparedStatement.setString(3, "일반사용자" + i);
                } else if(i < 90) {
                    preparedStatement.setString(1, "manager" + i);
                    preparedStatement.setString(3, "운영자" + i);
                } else {
                    preparedStatement.setString(1, "admin" + i);
                    preparedStatement.setString(3, "관리자" + i);
                }
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(preparedStatement != null) preparedStatement.close();
                    if(connection != null) connection.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    tbl_member_auth 테이블에 데이터 추가
    @Test
    public void testInsertAuth() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO tbl_member_auth VALUES(?, ?)";
        for(int i = 0; i < 100; i++) {
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                if(i < 80) {
                    preparedStatement.setString(1, "user" + i);
                    preparedStatement.setString(2, "ROLE_USER");
                } else if(i < 90) {
                    preparedStatement.setString(1, "manager" + i);
                    preparedStatement.setString(2, "ROLE_MANEGER");
                } else {
                    preparedStatement.setString(1, "admin" + i);
                    preparedStatement.setString(2, "ROLE_ADMIN");
                }
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(preparedStatement != null) preparedStatement.close();
                    if(connection != null) connection.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
