package com.wmp.exception;

public class DomainNameException extends IllegalArgumentException {

    public DomainNameException(){
        super("도메인 이름이 잘못되었습니다.");
    }
}
