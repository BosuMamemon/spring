package com.example.springexam01.model;

import com.example.springexam01.dto.Address;

import java.util.List;

public interface AddressService {
    
//    추가
    public void aInsert(Address address);

//    전체보기
    public List<Address> aList();

//    상세보기
    public Address aView(int num);

//    수정
    public void aUpdate(Address address);

//    삭제
    public void aDelete(int num);

//    개수
    public int aCount();
    
}
