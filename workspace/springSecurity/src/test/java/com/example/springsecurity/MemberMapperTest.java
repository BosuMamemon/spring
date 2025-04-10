package com.example.springsecurity;

import com.example.springsecurity.dto.MemberDTO;
import com.example.springsecurity.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j2
public class MemberMapperTest {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testRead() {
        MemberDTO memberDTO = memberMapper.read("admin90");
        log.info(memberDTO);
    }
}
