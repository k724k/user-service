# 🏷️ user-service

사용자 계정 관리와 인증을 담당하는 마이크로서비스입니다.  
회원가입, 로그인, 사용자 조회 기능을 제공합니다.

---

# 📌 Overview

User Service는 사용자 정보를 관리하며 게시글 작성 이벤트를 수신하여 **사용자 활동 점수**를 관리합니다.

또한 회원가입 시 **Point Service와 연동하여 초기 포인트를 지급**합니다.

---

# 🔧 Key Features

### 1️⃣ 회원 관리

- 회원가입
- 로그인 (JWT 발급)
- 사용자 조회

---

### 2️⃣ 회원가입 처리

회원가입 시

1️⃣ 사용자 저장  
2️⃣ Point Service 호출 → 초기 포인트 지급  
3️⃣ Kafka 이벤트 발행 → 다른 서비스에 사용자 생성 이벤트 전달

---

### 3️⃣ 게시글 작성 이벤트 처리

Board Service에서 게시글 작성 이벤트 발생 시 Kafka 이벤트를 수신하여

- 사용자 활동 점수 증가

로직을 처리합니다.

---

# 🏗 Architecture

<img width="537" height="256" alt="Image" src="https://github.com/user-attachments/assets/0d641744-cee8-4561-a517-0017d0a39dd2" />

---

# 🔗 Related Services

- https://github.com/k724k/api-gateway-service
- https://github.com/k724k/board-service
- https://github.com/k724k/point-serivce

---

# ⚙️ Tech Stack

Java  
Spring Boot  
Spring Data JPA  
MySQL  
Apache Kafka  
Docker  
AWS

