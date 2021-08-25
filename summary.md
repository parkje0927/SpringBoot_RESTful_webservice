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