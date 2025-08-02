# Задача «Безопасные методы»

## Описание

Сегодня вы попрактикуетесь в обеспечении безопасности для приложений на уровне методов.

1. Возьмите приложением из [прошлого домашнего задания](../../spring_security/task1/README.md).

2. Добавьте несколько пользователей с разными набором ролей: "READ", "WRITE", "DELETE".

3. Добавьте возможность ограничивать безопасность на уровне методов с помощью всех трёх типов аннотаций.

4. Напишите новый контроллер, в котором:

- один из методов возвращает значения только для пользователей с ролью "READ" (используйте `@Secured`);
- один из методов возвращает значения только для пользователей с ролью "WRITE" (используйте `@RolesAllowed`);
- один из методов возвращает значения, если у пользователя есть хотя бы одна из ролей из "WRITE", "DELETE" (используйте `pre`/`post` аннотации);
- один из методов, который принимает в качестве query-параметра имя пользователя (`username`), должен возвращает значения, только если у пользователя `username` совпадает с именем пользователя в вашем объекте `Authentication`, который `Spring security` сохраняет в `SecurityContextHolder` после успешной аутентификации.

5. Запуште изменения в репозиторий и прикрепите ссылку на него в комментарий к домашнему заданию.


## Проверочные URLs:

- http://localhost:8080/logout

### С авторизацией:
#### Новое решение:
- http://localhost:8080/secured_methods/user/greetings (проверка username)
- http://localhost:8080/secured_methods/city/Moscow (@PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')"))
- http://localhost:8080/secured_methods/age/38 (@Secured("ROLE_READ"))
- http://localhost:8080/secured_methods/delete/80 (@RolesAllowed("ROLE_DELETE"))

#### Старое решение:
1. Без авторизации
- http://localhost:8080/persons/by-city?city=Moscow
2. С Авторизацией:
- http://localhost:8080/persons/less-age?age=38 (требуется роль на чтение)
- http://localhost:8080/persons/by-name-surname?name=John&surname=Snow (требуется роль на запись)
- http://localhost:8080/persons/getmyname (требуется роль "super")