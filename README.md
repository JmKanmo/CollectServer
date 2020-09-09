## 수집 서버(Collect Server)

* 개발 기간 (2주 ~ 3주)
* 개발 언어 및 빌드 툴: JAVA,Gradle 
* author: JmKanmo 

<br>

### 실행 방법 
- 빌드결과 jar파일을 실행시킨다.
<br>

### 기능 및 요구사항 처리   
- IO Socket 통신을 이용해 수집 에이전트와 통신 
- String Json 데이터를 json,gson 라이브러리를 이용해 변환 
- 변환 된 데이터를 파싱한 뒤 JDBC API를 이용해 postgresql DB에 저장
<br>
