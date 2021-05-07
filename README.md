# Spring Security Demo

## Baza danych

Przed uruchomieniem projektu przygotuj pustą bazę danych PostgreSQL.

## Zmienne

- `spring.datasource.url` — adres bazy danych wraz z portem;
- `spring.datasource.username` — nazwa użytkownika w bazie danych;
- `spring.datasource.password` — hasło użytkownika w bazie danych;
- `my.admin.username` — login głównego administratora;
- `my.admin.password` — hasło administratora.

Przykład użycia jako argumenty JVM:

```java
-Dspring.datasource.url="jdbc:postgresql://localhost:5432/spring_security_demo" 
-Dspring.datasource.username=wsb
-Dspring.datasource.password=secret
-Dmy.admin.username=admin
-Dmy.admin.password=1234
```
