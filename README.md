# 🏷️ user-service
Kafka 이벤트와 REST API를 통해 포인트·게시판 서비스와 연동되는 사용자 계정·인증 마이크로서비스입니다

## ✅ Overview
- Apache Kafka를 이용한 이벤트 발행 및 소비(컨슈머) 패턴 적용
- board-service, point-service와 Kafka 토픽을 통해 비동기 이벤트 방식으로 연동
- REST API 방식으로 point-service 포인트 적립 호출, 동기 통신과 비동기 통신 병행 운영
- 서비스 간 결합도를 낮추고 확장성을 고려한 이벤트 기반 마이크로 서비스 설계
- API Gateway와 통신하여 클라이언트 요청을 받아 내부 서비스로 라우팅하며, 서비스 간 통신을 효율적으로 관리
  
## ✅ Features
<외부>
- 회원가입
  - 사용자 정보 저장
  - 저장된 사용자 정보 기반으로 PointClient로 초기 포인트 1000점 적립
  - 회원 가입 성공 이벤트 생성하여 카프카의 토픽에 전송
  - 보드 서비스의 user 엔티티에 사용자 정보 저장
  - 포인트 서비스의 외부 API 호출로 포인트 차감

- 로그인
  - 사용자 정보 이메일 및 비밀번호 확인
  - Jwt 토큰 반환
  
<내부>
- 사용자 단건 조회
    - Id 값에 따른 단건 조회
- 사용자 목록 조회
    - 모든 사용자 목록 조회
- 활동 점수 추가
    - 게시글 작성 이벤트 수신 시 사용자 조회 후 활동 점수 적립 기능
    - Id 값에 따른 사용자 조회 후 활동 점수 추가

## ✅ Tech Stack
<div align="left">
    <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />&nbsp
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/Spring_Cloud_Gateway-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />&nbsp
    <img src="https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" />&nbsp
</div>

## ✅ etc
<img width="537" height="256" alt="Image" src="https://github.com/user-attachments/assets/0d641744-cee8-4561-a517-0017d0a39dd2" />

