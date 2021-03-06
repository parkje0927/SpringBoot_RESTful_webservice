## RESTful
### REST (Representational State Transfer)
- Resource 의 Representation 에 의한 상태 전달
- HTTP Method 를 통해 Resource 를 처리하기 위한 아키텍쳐

### RESTful
- REST API 를 제공하는 웹 서비스

```
                                      REST
                                      HTTP
  HTTP Methods(GET, PUT, POST, DELETE) | HTTP Status Codes(200, 404, ...)
```

- Resource
  + URI(Uniform Resource Identifier) : 인터넷 자원을 나타내는 유일한 주소 
  + XML, HTML, JSON

- API 설계
  + Retrieve all Users : GET /users
  + Create a User : POST /users
  + Retrieve one User : GET /users/{id}
  + Delete a User : DELETE /users/{id}
  + Retrieve all posts for a User : GET /users/{id}/posts
  + Create a posts for a User : POST /users/{id}/posts
  + Retrieve details of a User : GET /users/{id}/{post_id}

## DispatcherServlet => '/'
- 클라이언트의 모든 요청을 한 곳으로 받아서 처리
- 요청에 맞는 Handler 로 요청을 전달
- Handler 의 실행 결과를 Http Response 형태로 만들어서 반환

## RestController
- @Controller + @ResponseBody
- View 를 갖지 않는 REST Data (JSON / XML) 를 반환

## Internationalization
- 하나의 출력값을 여러가지 언어로 표시되게 해주는 기능
- 제공하고자 하는 언어로 미리 준비한 다음에 언어 설정에 따라 적절한 언어로 표시
- 기본 설정이 영어면 영어 메세지가 보임
- 다국어 처리에 필요한 bean 을 등록 

## REST API Version 관리
- api 개발 및 사용을 위해 version 관리 필요 
- 사용 가이드를 위해 버전 관리 필요

- URI : 웹 브라우저에서 실행 가능
- Request Parameter : 웹 브라우저에서 실행 가능
- header : 일반 웹 브라우저에서는 실행 불가능
- 마임타입 : 일반 웹 브라우저에서는 실행 불가능
- 과도하게 URI 에 많은 정보 주지 않기
- 적절한 parameter
- 캐시관련 주의(캐시 삭제 후 재실행 해야할 수 있음)

## HATEOAS 적용
- Hypermedia As the Engine Of Application State
- 서버가 클라이언트에게 하이퍼 미디어를 통해 정보를 동적으로 제공해주는 것
- 현재 리소스와 연관된(호출 가능한) 자원 상태 정보를 제공
- Level 0 : The Swamp of POX
- Level 1 : Resources 
- Level 2 : HTTP Verbs
- Level 3 : Hypermedia Controls