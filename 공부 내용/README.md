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
#### Compile Code Vs Scripting Code
||Compile|Scripting|
|---|---|---|
|종류|CGI 관련 프로그램과 Servlet 프로그램| JSP, PHP, ASP|
|코드 형태|컴파일된 Binary Code 또는 Byte COde|컴파일되기 전 일반적인 Script Code|
|컴파일 방법|구현 이후 컴파일 과정을 직접 수행|구현 이후 컴파일 과정은 웹 요청시 자동 수행|
|코드 변경|직접 다시 재컴파일해야 함|스크립트 내 코드만 수정하면 되며 웹 요청시 자동으로 재컴파일 수행|
