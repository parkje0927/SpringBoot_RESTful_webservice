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