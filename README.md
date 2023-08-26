# Bokeh-Server

Real-time community based on keyword combinations

## System Design

## Code Architecture

### Domain Hexagon
- 기술에 독립적인 POJO (Plain Old Java Object)로 개발
- 도메인 비즈니스 규칙을 정의
- 어떠한 의존성도 가지지 않음

### Application Hexagon
- 시스템이 가지는 기능/사례(usecase)를 정의한 집합 
- 비즈니스 로직을 위한 필수 의존성만 포함
- Domain Hexagon에 의존


### Framework Hexagon
- Infrastructure 영역으로, Application Hexagon이 소유한 outputPort (interface) 구현체들의 집합 
- Application, Domain Hexagon에 의존

### Bootstrap Hexagon
- Adapters (User Interface) 영역으로, 프로그램의 기능을 사용하는 데 필요한 시작점을 제공
- Application, Domain Hexagon, Framework Hexagon에 의존

## Reference
- https://techblog.woowahan.com/12720/
