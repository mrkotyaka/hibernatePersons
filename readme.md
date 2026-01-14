# Task: “Secure Methods”

## Description

Today, you will practice securing applications at the method level.

1. Take the application from [the previous homework assignment](../../spring_security/task1/README.md).

2. Add several users with different sets of roles: “READ,” “WRITE,” and “DELETE.”

3. Add the ability to restrict security at the method level using all three types of annotations.

4. Write a new controller in which:

- one of the methods returns values only for users with the “READ” role (use `@Secured`);
- one of the methods returns values only for users with the “WRITE” role (use `@RolesAllowed`);
- one of the methods returns values if the user has at least one of the roles “WRITE” or “DELETE” (use `pre`/`post` annotations);
- One of the methods that accepts a username (`username`) as a query parameter should return values only if the user's `username` matches the username in your `Authentication` object, which `Spring security` stores in `SecurityContextHolder` after successful authentication.

5. Push the changes to the repository and attach a link to it in the comment to your homework assignment.


## Verification URLs:

- http://localhost:8080/logout

### Security over Methods:
#### With Authorization:
- http://localhost:8080/secured_methods/greetings?username=admin (username verification)
- http://localhost:8080/secured_methods/city/Moscow (@PreAuthorize(“hasAnyRole(‘ROLE_WRITE’, ‘ROLE_DELETE’)”))
- http://localhost:8080/secured_methods/age/38 (@Secured(“ROLE_READ”))
- http://localhost:8080/secured_methods/delete/80 (@RolesAllowed(“ROLE_DELETE”))

### Old Security solution in config:
#### Without authorization
- http://localhost:8080/persons/by-city?city=Moscow
#### With authorization:
- http://localhost:8080/persons/less-age?age=38 (read role required)
- http://localhost:8080/persons/by-name-surname?name=John&surname=Snow (requires write role)
- http://localhost:8080/persons/getmyname (requires “super” role)
