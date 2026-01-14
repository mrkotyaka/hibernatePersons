# Task: “DAO Layer with JPA Repositories”

## Description

Let's practice working with JPA Repositories by rewriting the application for working with the database [“DAO Layer with Hibernate”](https://github.com/mrkotyaka/hibernatePersons/blob/main/readme.md).

**What you need to do**

1. Rewrite the repository for working with the database based on query methods:

- Make sure your repository has the basic methods for CRUD operations.
- create a method that will accept the name of the city (`city`) and return `Entity` from the database that correspond to this `city`;
- create a method that will accept age (`age`) and return `Entity` from the database that are less than the passed `age` and sorted in ascending order;
- Create a method that will accept the first and last name (`name` and `surname`) and return `Entity` from the database that match the combination of `name` and `surname` and are `Optional`.

2. Add the missing controller methods in accordance with the new methods that appeared in the repository.

3. Upload the written code to the same repository as for task [“DAO layer with Hibernate”] (https://github.com/mrkotyaka/hibernatePersons/blob/main/readme.md) on GitHub, but create a different branch `jpa-repository` for it and attach a link to it in the comment to your homework assignment.
