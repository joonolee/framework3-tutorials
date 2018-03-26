# framework3-education

## ch0. 개발환경 설정

1) Java 1.8
2) Spring Tool Suite(STS)
  - http://spring.io/tools
3) Eclipse Marketplace
  - Subversive
  - JRebel
4) Window – Preferences 변경
  - General–Workspace–Text file encoding : UTF-8 변경
  - General–Editors–Text Editors–Spelling : Enable 체크해제
  - Validation-Disable All 버튼 클릭
  - Web-JSP Files : Encoding -> UTF-8 변경
  - Web-HTML Files : Encoding -> UTF-8 변경
  - Java-Code Style-Formatter : Eclipse [build-in] Edit
    => Line Wrapping 탭(Maximum line width: 1000)
    => Comments 탭(모두 체크해제)
5) Window – Web Browser
  - Chrome 선택
---

## ch1. QuickStart 설치

1) Download
  - https://github.com/joonolee/framework3-quickstart
2) Import Project
  - Import – General – Existing Projects into Workspace – Select archive file – framework3-quickstart-master.zip
  - rename refactoring
3) HelloWorld(Controller, routes.properties) (예제)
  - HelloWorldController 생성
  - routes.properties 추가 => url 패스 = 컨트롤러.메소드
4) Run on Server
---

## ch2. web.xml 설명

- DispatcherServlet
- CharacterEncodingFilter
- CORSFilter
- GZIPFilter
- JuminMaskFilter (예제)
- MinifyFilter (예제)
- XSSFilter
- routes.properties
- views.properties
- log4j.properties: APPNAME을 찾아 프로젝트명으로 변경
---

## ch3. 컨트롤러

- params
- request
- response
- render
- redirect
- setContentType
- setAttribute
- setSessionAttribute
- setFlashAttribute
- logger
- @Before
- @After
- @Catch
- @Finally
- only, unless
---

## ch4. DataAccessObject(DAO)
- 시퀀스, 테스트 테이블 생성
- application.properties
- Controller 클래스의 DB 객체 : getDB(), getDB(“..”)
- JdbcDaoSupport
- SelectConditionObject
- select(query)
- select(query, parameterArray)
- RecordSet(RecordMap)
- (시퀀스 Dao 예제)
- SqlSessionDaoSupport
- mybatis-config.xml
- mybatis-mapper.xml
- List<RecordMap>, RecordMap
- 대용량 데이터 조회 시 mybatis ResultHandler 사용한 CSV 전송 예제
---

## ch5. 자동생성 DAO, VO

- daogen : DB테이블을 참조하여 DAO, VO를 자동생성해주는 유틸리티
- Download : https://github.com/joonolee/framework3
- db.properties : 접속할 DB 정보
- dao.xsl, vo.xsl : DAO, VO 템플릿
- generation (예제) : DaogenForXXX.java 파일을 Application 으로 실행하여 생성 _tbList = Arrays.asList("테이블1", "테이블2"), 빈리스트일 경우 모든테이블에 대한 DAO, VO가 생성됨
- insert, select, updateOnlyFields, delete
- ValueObjectArray, 대용량 배치처리 (예제)
---

## ch6. 캐시

- ehcache.xml
- memcached.properties
- Cache.set(), Cache.get() 을 사용
---

## ch7. 각종Util

- 사용법은 javadoc 문서 참조
- CryptUtil
- CsvUtil
- DataTablesUtil
- DateUtil
- EmailUtil
- ExcelUtil
- FileUtil
- GauceUtil
- HttpUtil
- ImageUtil
- JqGridUtil
- JsonUtil
- MaSaferUtil
- MiPlatformUtil
- NexacroUtil
- OAuth10aUtil
- PagingUtil
- PatternUtil
- PdfUtil
- RDUtil
- RssUtil
- StringUtil
- ValidationUtil
- VelocityUtil
- XmlUtil
