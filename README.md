# BE_SharedOffice
Backend_SharedOfficePlatform

# **1. 기술 스택**

- **언어**: Java 17
- **개발 환경**: IntelliJ, Gradle, Spring Boot 3
- **라이브러리**: Spring Web, Spring Security, JPA, Lombok, JWT, MySQL
- **배포**: EC2, RDS(MySQL)
- **DB** : MySQL

# **2. 패키지 구조도**

```java
com.coworking_space
├── domain
│   ├── member
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── exception
│   │   ├── repository
│   │   └── service
│   ├── office
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── exception
│   │   ├── repository
│   │   └── service
│   ...
└── global
    ├── auth
    ├── common
    ├── config
    ├── error
    ├── infra
    └── util
```
