# 콜버스랩 백엔드 개발자 사전 과제

- 제출자: 최윤정

## Requirements

- JDK 1.8

## Framework & Library

- spring-boot-starter-validation
- spring-boot-starter-data-jpa
- querydsl-jpa
- lombok
- h2 database

## H2 Connection

- h2 console: 127.0.0.1:8080/h2-console
- JDBC URL: jdbc:h2:mem:test
- User Name: sa
- Password: 

## Getting Test

`postman` 실행 후 `jaritalk-community.postman_collection.json` 파일을 불러와 테스트

### Requirements

- postman install url: https://www.postman.com

## Account

- 애플리케이션 실행 시 h2에 자동으로 insert 되는 계정 목록

<table>
    <tr>
        <th>계정 ID</th>
        <th>닉네임</th>
        <th>계정 타입</th>
        <th>탈퇴 여부</th>
    </tr>
    <tr>
        <th>lessorA</th>
        <th>임차인A</th>
        <th>임차인</th>
        <th>N</th>
    </tr>
    <tr>
        <th>lessorB</th>
        <th>임차인B</th>
        <th>임차인</th>
        <th>Y</th>
    </tr>
    <tr>
        <th>realtorA</th>
        <th>공인중개사A</th>
        <th>공인중개사</th>
        <th>N</th>
    </tr>
    <tr>
        <th>realtorB</th>
        <th>공인중개사B</th>
        <th>공인중개사</th>
        <th>Y</th>
    </tr>
    <tr>
        <th>lesseeA</th>
        <th>임대인A</th>
        <th>임대인</th>
        <th>N</th>
    </tr>
    <tr>
        <th>lesseeB</th>
        <th>임대인B</th>
        <th>임대인</th>
        <th>Y</th>
    </tr>
</table>

## ERD

![image](https://user-images.githubusercontent.com/98807166/217239974-cef5eacc-aeb5-4dfb-b42e-283cd8e56bed.png)
