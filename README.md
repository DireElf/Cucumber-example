## Окружение

- Java версии 11 или выше.
- Установленные Maven и Google Chrome.

## Запуск

Инициализация раннера, запускающего Cucumber-тесты для Chrome:

```bash
mvn test -Dtest=TestRunner -Dbrowser=chrome
```
---

То же самое для Firefox:

```bash
mvn test -Dtest=TestRunner -Dbrowser=firefox
```
---

_Просмотреть отчет Allure после выполнения тестов:_
```bash
mvn allure:serve
```


