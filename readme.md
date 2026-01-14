# Task: “DAO Layer with Hibernate”

## Description

Let's practice working with Hibernate through Spring, while reinforcing topics we have already covered.

You need to write an application for working with a database using Spring tools for configuration and working with Hibernate, adapting the tables from the task [“User Table”](https://github.com/netology-code/jd-homeworks/blob/master/sql-basic/task/README.md).

**What you need to do**

1. Create a Spring Boot application with dependencies on two starters — `spring-boot-starter-data-jpa` and `spring-boot-starter-web`.

2. Create an Entity that corresponds to the table from the task conditions [“User Table”](https://github.com/netology-code/jd-homeworks/blob/master/sql-basic/task/README.md).

3. Write a repository for working with the database.

- Create a class and mark it with the Repository annotation, or create a repository bean in the Java Config class.
- Inject EntityManager correctly.
- Create a method `getPersonsByCity(String city)` that will take the city name and return your Entity from the database corresponding to this `city`. This can be done, for example, by getting all users and filtering them by city.

4. Write a controller with a GET request handler method mapped to the endpoint `/persons/by-city`. The query params of the request will contain a string parameter `city`, which you will need to pass on to the repository. That is, your method must be able to handle a request of the form `localhost:8080/persons/by-city?city=Moscow`.
   The controller must return all the people it receives from the repository.

5. Post the code you wrote to a separate repository on GitHub and attach a link to it in the comments to your homework assignment.
