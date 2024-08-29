## Окружение

- Java версии 11 или выше.
- Установленные Maven и Google Chrome.

## Запуск

Инициализация раннера, запускающего Cucumber-тесты для Chrome (по умолчанию):

```bash
mvn test -Dtest=TestRunner
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


