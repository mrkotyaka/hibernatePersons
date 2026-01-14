# Secure Application Task

## Description

Today, you will practice securing applications. You will restrict access to endpoints.

1. Take any of the already implemented applications on Spring Boot that has a controller and at least one method that handles requests to different endpoints.

2. Add a dependency on `spring-boot-starter-security` to the application.

3. Implement a class that inherits from `WebSecurityConfigurerAdapter` so that:

- the user logs in using the standard Spring login form;
- at least one of your application's endpoints can be accessed without authorization, while all others can only be accessed after authorization.

4. Push the changes to the repository and attach a link to it in the comments to your homework assignment.

## Verification URLs:

1. Without authorization:
- http://localhost:8080/persons/by-city?city=Moscow
2. With authorization:
- http://localhost:8080/persons/less-age?age=38 (read role required)
- http://localhost:8080/persons/by-name-surname?name=John&surname=Snow (requires write role)
- http://localhost:8080/persons/getmyname (requires “super” role)
