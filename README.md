# 🏷️ user-service

## ✅ Overview
- Apache Kafka를 이용한 이벤트 발행 및 소비(컨슈머) 패턴 적용
- board-service, point-service와 Kafka 토픽을 통해 비동기 이벤트 방식으로 연동
- REST API 방식으로 point-service 포인트 적립 호출, 동기 통신과 비동기 통신 병행 운영
- 서비스 간 결합도를 낮추고 확장성을 고려한 이벤트 기반 마이크로서비스 설계
- API Gateway와 통신하여 클라이언트 요청을 받아 내부 서비스로 라우팅하며, 서비스 간 통신을 효율적으로 관리
  
## ✅ Features
- JWT 인증 기반 로그인 및 회원 가입 처리
- 사용자 단건 및 목록 조회
- 게시글 작성 이벤트 수신 시 사용자 활동 점수 적립 기능 구현
  
## ✅ Tech Stack
<div align="left">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />&nbsp
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/Spring_Cloud_Gateway-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" />&nbsp
</div>

## ✅ etc
<img width="537" height="256" alt="Image" src="https://github.com/user-attachments/assets/0d641744-cee8-4561-a517-0017d0a39dd2" />

