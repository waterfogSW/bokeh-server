# Bokeh-Server

Real-time community based on keyword combinations

## Server Architecture
![image](https://github.com/waterfogSW/bokeh-server/assets/28651727/3e2c1889-2740-41cc-918c-7be07f4f4d23)


## Code Architecture

![alt text](https://techblog.woowahan.com/wp-content/uploads/2023/06/100-explicit-architecture-svg-1024x700.jpg)

### Domain

- Domain Layer 영역
- 비즈니스 로직을 정의
- POJO로 구현
- dependency 없음

### Application

- Application Layer 영역
- Domain Layer를 활용 UseCase를 정의
  - UseCase는 Application Layer의 Interface
- Domain Layer에 대한 의존성만을 가짐

### Adapter

- Secondary/Driven Adapter 영역
  - 외부와의 통신을 위한 Adapter, Output Port의 구현체
- 각 기술의 이름을 딴 Config파일로 ComponentScan 영역을 격리

### API

- Primary/Driver Adapter 영역
  - 외부와의 통신을 위한 Adapter, Input Port의 구현체를 포함
  - REST API, Kafka Consumer, WebSocket등
- domain, application, adapter를 통합하는 영역으로 각 영역에 있는 필요한 모듈의 Config를 선별적으로 Import  
