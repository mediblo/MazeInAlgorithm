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