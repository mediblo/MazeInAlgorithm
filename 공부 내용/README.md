# jQuery
- 일종의 JS 라이브러리
- JS 프로그래밍 양을 상당히 줄일 수 있음
- Learn Easy!
- 사용법 : $(selector).action(a, b); [ b는 보통 콜백 함수가 옴 ]
- 선택자 [ css의 선택자 형식과 유사 ]  

|형식|설명|
|---|---|
|\*|모든 요소|
|this|현재 요소|
|p.myclass|\<p> 요소에서 class가 myclass인 요소|
|p.first|첫 번째 \<p> 요소|
|div span| \<div> 요소의 자식 \<span>|
|:button|button 모두 <br> \<input type="button"\> 모두|

- 보통 사용은 $(document).ready( function() {} ); 으로 시작하며 이는 DOM이 로딩되어 준비가 되면 작업을 시작한다는 것

- 애니메이션 효과는 지정 속도로 나타남, 이는 동시에 실행되는 것이 아니라 차례대로 실행됨 [ FIFO ]  
![메소드 체인](https://i.imgur.com/VzZX6AP.png)

# Ajax
- 서버와 데이터를 교환하는 기술 하나
- 전체 web page를 다시 load하지 않고 web page의 일부분을 동적으로 갱신 가능
- 동작 원리
	- 유저가 event 발생시 JS 함수가 호출  
	- XMLHttpRequest 객체의 인스턴스 생성  
	- 서버 내에서 내부 처리 후 XML Data 생성  
	- Response 메시지에 XML Data 포함 전송  
	- XML Data를 파싱하여 웹문서의 DOM 객체를 업데이트
- 진행 과정 [ 영어로 씀 ]  
	- make XMLHttpRequest Object  
	- make callback function  
	- Open a request  
	- send the request

![Ajax 동작 설명](https://i.imgur.com/WcTWjhA.png)

- jQuery를 사용 시 쉽게 Ajax를 사용할 수 있다.

|메소드|설명|
|---|---|
|$.ajax()|비동기식 Ajax를 이용하여 HTTP요청을 전송|
|$.get()|전달받은 주소로 GET방식의 HTTP요청을 전송|
|$.post()|전달받은 주소로 POST방식의 HTTP요청을 전송|
|$.getScript()|웹 페이지에 스크립트로 추가|
|$.getJSON()|전달받은 주소로 GET 방식의 HTTP요청을 전송하여, 응답으로 JSON 파일을 전송받음|
|.load()|서버에서 데이터를 읽은 후, 읽어들인 HTML코드를 선택한 요소에 배치|

## JSON [ JavaScript Object Notation ]  
- 텍스트 - 기반의 데이터 교환 형식
- JS에서 유래
- Data를 key : value형식으로 표현
	
## HTTP ( HyperText Transfer Protocol )
- Web Client와 Web Server 사이에 대화하는 방법 및 Data 정보를 Web Server에서 Web Client로 전송하는 방법을 정희하는 표준 프로토콜
- 하부에서 데이터의 올바른 전송을 위해 TCP/IP 사용
- URL[Uniform Resource Locator] 로 웹 서버의 데이터 정보를 획득 <p>
- 무상태[Stateless] 프로토콜
	- Server는 Client의 요청에 응답한 후, Client의 State에 대한 정보를 Server에 따로 저장하지 않는 대신 외부 DB를 이용하여 저장 및 관리가 가능함. <p>
- 정적 Vs 동적 Web Page
	- 정적 : Client < - > Server
	- 동적 : Client < - > Server < - > JSP

![정적vs동적](https://i.imgur.com/dOoN8fd.png)

### 전통적인 CGI 방식의 동적 웹 페이지
- CGI란? [ Common Gateway Interface ]
	- 정식 프로그래밍 언어나 스크립트가 아닌 웹 서버와 서버에서 수행중인 일반 프로세스 사이에 정보를 주고받는 규칙
	- Perl, C, C++ 등의 언어를 지원
	- 프로그램이 호출되면 개별 프로세스를 생성
	- 단점 : 사용자가 증가시 급격히 성능 저하

![CGI방식](https://i.imgur.com/IFZFPLP.png)

### Application Server 방식의 동적 웹 페이지 작성 기술 [ 이하 App Server ]
- App Server를 통하여 간접저그올 관련 스크립트를 호출하여 수행
- Tomcat [ JSP Script 엔진을 포함하는 App Server의 대표적인 SW ]
- CGI에 비해 가지는 장점
	- 각 웹 요청에 대해서 App Server는 Thread로서 처리
	- 다수의 웹 브라우저가 같은 요청을 하더라도 App Server는 관련된 스크립트에 대한 프로세스를 하나만 수행
	- 동시에 더 많은 웹 브라우저의 요청을 처리할 수 있다는 것을 의미하며 이는 곧 안정적인 웹 서비스를 제공할 수 있는 기반
	- CGI 방식에 비하여 CPU 점유도나 메모리 점유도에 있어서 상당히 효율적

![App Server](https://i.imgur.com/zCcziFJ.png)

## Web Programming Language
#### Compile Code Vs Scripting Code
||Compile|Scripting|
|---|---|---|
|종류|CGI 관련 프로그램과 Servlet 프로그램| JSP, PHP, ASP|
|코드 형태|컴파일된 Binary Code 또는 Byte COde|컴파일되기 전 일반적인 Script Code|
|컴파일 방법|구현 이후 컴파일 과정을 직접 수행|구현 이후 컴파일 과정은 웹 요청시 자동 수행|
|코드 변경|직접 다시 재컴파일해야 함|스크립트 내 코드만 수정하면 되며 웹 요청시 자동으로 재컴파일 수행|

#### Client-Side Scripting 기술
- 요청하는 파일을 그대로 브라우저로 전송하고 그 파일 내에 있는 스크립트 언어를 해석하여 페이지 자체를 동적으로 만들어주는 기술
- 종류
	- 자바스크립트 [ JavaScript ]
	- DHTML [ Dynamic HTML ]
	- CSS [ Cascading Style Sheet ]
	- Flash와 관련된 ActionScript
	- Ajax [ Asynchronous JavaScript and XML ]

#### Server-Side Scripting 기술
- 웹 서버 내에 코딩해 놓은 파일을 서버 측에서 동작하는 어플리케이션 서버가 직접 실행하여 그 결과를 브라우저로 보내주는 기술
- ASP [ Active Server Page ]
	- Microsoft의 대표적 기술
	- VBScript를 이용해서 매우 쉽게 학습 및 적응 가능
	- 기존에 이미 개발되어 있는 COM 객체를 활용함으로써 개발자들은 필요한 프로그램을 코딩하는 시간을 줄일 수 있음
	- .NET platform
		- ASP.NET
	- 단점
		- Microsoft에서 개발한 OS 및 개발 환경에 종속
		- 값비싼 Microsoft 계열 OS 및 DB와 IDE를 사용

#### PHP [ Profrssional Hypertext Preprocessor ] 전문적인 하이퍼텍스트 전처리기
- Open Source Model 기반 언어
- Windows, Unix, Linux OS에서 가장 빠르게 동작하는웹 사이트 구성 가능
- 소규모 개발자들에게 매우 쉽게 접근
- 가볍고 사용하기 쉬움
- 풍부한 DB 지원 기능을 제공
- 단점
	- 일반적인 프로그래밍 언어가 가지고 있는 풍부한 기능이 부족
	- 객체지향[ Object-oriented ] 프로그래밍 언어가 가지고 있는 캡슐화, 상속성, 재사용성, 모듈화 특성이 부족
	- 중대형급 규모의 웹 어플리케이션 개발에 적합하지 않음

#### JSP [ Java Server Page ]
- Java 언어 기반의 웹 스크립트 언어
- Script 기반의 웹 프로그래을 지원
	- Compile Code 방식인 Java Servlet은 웹 개발자 및 운영에 불편
- Java의 객체지향 언어의 여러 가지 기능을 사용
	- Class Libraries, 객체 지향적 코딩, 높은 보안 지원
- 효율적인 처리
	- 웹 요청 시 이미 메모리에 적재된 서블릿 코드에서 바로 응답이 가능
- 코드 유지관리 보수
	- MVC [ Model-View-Controller ] 모델
- 많은 Class Libraries 사용 가능

### JSP/Servlet 웹 프로그래밍을 위한 필수 사전 지식
||Compile Code|Scripting Code|
|---|---|---|
|Java|자바 언어 기본, 객체지향, 상속,<br>오버로딩, 오버라이딩,<br>인터페이스 구현, Reflection,<br>java.util, java.io 패키지,<br>쓰레드, 에외 처리 핸들링|Annotation<br>서블릿 기초 프로그래밍<br>request, response 처리<br>GET/POST 처리|
|JDBC| JDBC 드라이버 세팅, Resulset<br>PreparedStatement, 데이터 핸들링|오라클, MySQL등 원격지 DB 연결 처리 경험|
|Servlet|서블릿 기초 프로그래밍<br>request, response 처리<br>GET/POST 처리|서블릿 생명주기 이해|


# HTTP 프로토콜
#### HTTP 프로토콜이란?
- TCP/IP를 기반으로 하여 웹에서 사용하는 프로토콜로서 요청[Request]과 응답[Response] 데이터를 전송하는 방식

#### HTTP Request와 HTTP Response
- HTTP Request 주요 구성요소
	- HTTP method [ 실행할 액션 [ GET/POST ]]
	- 접근하고자 하는 URL 주소
	- 폼 파라미터 [ 메소드의 매개변수와 비슷함 ]
- HTTP Response 주요 구성요소
	- State Code [ 요청 처리에 대한 성공여부 ]
	- 컨텐츠 타입 [ Text, Picture, HTML 등 ]
	- 컨텐츠 [ HTML Code, Image 등 ]

#### HTTP method
- HTTP 요청의 종류 및 폼 파라미터의 포맷을 정의
- 주 사용 메소드는 GET, POST

![GET Ex](https://imgur.com/6MlZWjW.png)
![POST Ex](https://imgur.com/0wHgJxJ.png)

#### GET 메소드
- 단순한 자원 [ HTML 문서, Image 등 ] 요청
- 서버로의 데이터 전달
	- 간단한 파라미터 정도만 HTTP 요청 시 사용
	- QUERY_STRING 환경변수[Maximum 240byte]
		- 요청 URL에 '?' 이후의 값들
		- '속성 = 값' 형태로 사용됨, 여러 속성 값 전달 시 '&' 문자로 연결

![GET Ex2](https://imgur.com/imPKEdz.png)

#### POST 메소드
- 사용자의 입력 값을 HTTP 요청 시 서버에 전달
- 복잡한 파라미터 사용 가능
	- 데이터 크기는 제한이 없음
	- URL에 전달하려는 정보 값이 표시되지 않음

![POST Ex2](https://imgur.com/TOEBIma.png)

#### HTTP 응답
- Header
	- 사용된 프로토콜 종류, 요청의 성공 여부[State Code]
	- 몸체에 포함된 컨텐츠의 종류는 무엇인지 등
- Body
	- HTML과 같은 컨텐츠

![HTTP Response](https://imgur.com/gj8vSJq.png)

# Servlet
#### Servlet
- 자바 플랫폼에서 컴포넌트 기반의 서버 웹 어플리케이션 개발 기술
- 서블릿 컨테이너에 의해 생성, 호출, 소멸

#### Servlet Container
- HTTP 요청에 의한 서블릿 실행 및 생명주기 관리하는 프로그램
	- 서블릿, 자바 서버 페이지[JSP]  파일, 서버-사이드 코드가 포함된 다른 타입의 파일들에 대한 요청 처리
- 자바 가상 머신을 포함한 서블릿 운영 환경 제공
	1. 서블릿 객체 생성
	1. 서블릿 로드 및 언로드
	1. 요청과 응답 객체 생성 및 관리
	1. 다른 서블릿 관리 작업 수행
- 자체 웹 서버 기능도 있으나 웹 서버와 분리하기도 함
	- Apache Tomcat, Resin, Wildfly[Jboss], JEUS, WebLogic 등

#### 서블릿 장점
- 쓰레드를 기반으로 웹 어플리케이션 운영에 효율
- 자바 기반으로 자바 API 모두 사용 가능
- OS나 HW에 독립적이라 한 번 개발된 애플리케이션은 다양한 서버 환경에서도 실행 가능
- 웹 애플리케이션에서 효율적인 자료 공유

#### 웹 애플리케이션 개발 시 이점
- 컨텐츠와 비즈니스 로직을 분리 가능
- 컨트롤러와 뷰 역할 분담하여 웹 디자이너와 개발자 간 원활한 공동작업이 가능
- 유지보수 수월
- 기능의 확장 용이
- 프로그래머가 HTML, 자바스크립트 스타일시트 등 복잡한 기술을 모두 알아야 할 필요가 없음

### 서블릿 컨테이너 동작 흐름
Request Flow  
![Request Flow](https://imgur.com/PD5EZf5.png)  
Response Flow  
![Response Flow](https://imgur.com/tjtmZNx.png)  
Request 1 - HTTP  
![Request HTTP](https://imgur.com/RFktadR.png)  
Request 2 - Servlet  
![Request Servlet 1](https://imgur.com/Dsks1ra.png)  
![Request Servlet 2](https://imgur.com/rs8q0vX.png)  
Request 3 - Servlet  
![Request Servlet 3](https://imgur.com/yJ7NtHn.png)  

#### 서블릿 작성
- 자바 클래스로 제작
	- javax.servlet.GenericServlet or javax.servlet.http.HttpServlet 상속 구현
- 컴파일 과정 필요

#### 서블릿에 대한 사용자 요청 처리 과정
- web.xml 파일을 참조해 URL 매핑을 확인
- 요청된 'Servlet 인스턴스'로부터 스레드를 생성
- service() 메소드 호출
	- 모든 사용자 요청에 대해 개별적인 service() 메소드 호출
- GET 요청은 doGet(), POST 요청은 doPost() 메소드 호출
	- Servlet 개발자는 doGet() 또는 doPost() 메소드에 필요한 기능을 구현
	- doGet()에서 다시 doPost()를 호출 가능
	- doPost() 내부에만 관련 처리 과정을 코딩

#### 서블릿의 생명주기
- 컨테이너 시작 시
	- 배포된 웹 애플리케이션 및 서블릿 목록 확인
- 로딩
	- 컨테이너 시작 시 로딩 또는 최초 클라이언트의 요청 시 로딩
- 서블릿 초기화 : init()
	- 컨테이너에서 서블릿 객체 생성(로딩) 후 호출
	- 한번만 실행되기 때문에 공통적으로 사용하기 위해 필요한 작업 설정
	- 실행중 서블릿 변경 시 기존 서블릿은 파괴 후 다시 init() 호출
- 요청 처리 : service()
	- 컨테이너에 의해 호출됨
	- 사용자 요청은 request로, 응답 처리는 response 객체로 처리
	- 실제 요청 수행은 doGet(), doPost() 메서드 내부 코드로 작성
	- overriding 하지 않음
- 요청 수행 : doGet() 또는 doPost()
	- service() 메소드에서 HTTP 메소드[GET, POST]를 참조하여 호출
	- 비즈니스 로직을 구현 또는 호출
	- 두 메소드 중 하나는 반드시 overriding하여 구현
- 서블릿 종료 : destory()
	- 한번만 실행되기 때문에 정리할 작업 설정

![Servlet Flow](https://imgur.com/zjcPw5Y.png)

#### 컨테이너 내에서 서블릿 동작흐름
![Container Servlet](https://imgur.com/lfmJRP0.png)

# HttpServlet
#### HttpServlet 구조
- 일반적으로 javax.servlet.http.HttpServlet을 상속
- 메서드
	- service() : 컨테이너에서 호출
	- doGet(), doPost() : override로 필요한 기능 구현
	- GET, POST에 상관없이 request.getParameter() 이용

![HttpServlet](https://imgur.com/txypXDk.png)

#### HttpServletRequest 클래스 [ 요청 ]
- 사용자 요청과 관련된 정보 제공하는 클래스
- HttpServlet 클래스의 doGet(), doPost() 메서드 호출 시 파라미터로 전달
- 키, 헤더, 세션 등 HTTP 에 대한 것들에 대한 처리 관련 메소드 포함
- HTTP 프로토콜에 관련된 메소드들이 추가 되어 있음
- HTML 폼 입력값을 가져옴
- 쿠키, 세션정보에 접근 가능
- 클라이언트 IP주소를 알 수 있음

|method|Description|
|---|---|
|getParameterNames()|현재 요청에 포함된 파라미터 이름을 Enumeration 형태로 전달|
|getParameter(name)|문자열 name과 같은 이름을 가진 파라미터의 값을 가져옴|
|getParameterValues(name)|문자열 name과 같은 이름을 가진 파라미터의 값을 배열<br>형태로 가져옴, checkbox, multiple list 등에 주로 사용|
|getCookies()|모든 쿠키 값을 javax.servlect.http.Cookies의 배열형태로 가져옴|
|getMethod()|현재 요청이 GET, POST인지 가져옴|
|getSession()|현재 세션 객체를 가져옴|
|getRemoteAddr()|클라이언트의 IP 주소를 알려줌|
|getProtocol()|현재 서버의 프로토콜을 문자열 형태로 알려줌|
|setCharacterEncoding()|현재 jsp로 전달되는 내용을 지정한 캐릭터셋으로 변환<br>html form에서 한글 입력 시 정상적으로 처리하려면 반드시 필요|

#### HttpServletRequest 클래스 [ 처리 ]
- 사용자 응답을 처리하기 위한 클래스
- HTTP에 관련된 오류, 쿠키, 헤더 정보에 대한 메소드들이 추가되어 있음
- HttpServlet 클래스의 doGet(), doPost() 메서드 호출 시 파라미터로 전달
- MIME Type 설정
- HTTP 헤더 정보 설정
- 페이지 전환

|method|Description|
|---|---|
|setContentType(type)|문자열 형태의 type에 지정됝 MIME Type으로 ContentType을 설정|
|setHeader(name, value)|문자열 name의 이름으로 문자열 value값을 헤더로 세팅|
|setDateHeader(name, date)|문자열 name의 이름으로 date에 설정된 Millisecond<br>시간값을 헤더에 설정|
|sendError(status, msg)|에러 코드를 세팅하고 메시지를 보냄|
|sendRedirect(url)|클라이언트 요청을 다른 페이지로 보냄|

사진 및 정보 출처 : [Head First Servlet & JSP] [동국대학교]