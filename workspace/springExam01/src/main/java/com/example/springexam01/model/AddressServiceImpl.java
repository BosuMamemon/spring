package com.example.springexam01.model;

import com.example.springexam01.dto.Address;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    SqlSession sqlMapper;

    @Override
    public void aInsert(Address address) {
        sqlMapper.insert("addressInsert", address);
    }

    @Override
    public List<Address> aList() {
        List<Address> result = sqlMapper.selectList("addressList");
        return result;
    }

    @Override
    public Address aView(int num) {
        Address result = sqlMapper.selectOne("addressView", num);
        return result;
    }

    @Override
    public void aUpdate(Address address) {
        sqlMapper.update("addressUpdate", address);
    }

    @Override
    public void aDelete(int num) {
        sqlMapper.delete("addressDelete", num);
    }

    @Override
    public int aCount() {
        int result = sqlMapper.selectOne("addressCount");
        return result;
    }

}
