## Окружение

- Java версии 11 или выше.
- Установленные Maven и Google Chrome.

## Запуск

Инициализация раннера, запускающего Cucumber-тесты на Windows Chrome (64-version):

```bash
mvn test -Dtest=TestRunner
```
---

То же самое на Linux Chrome (64-version):

```bash
mvn test -Dtest=TestRunner -Dbrowser=chrome_lin
```
---

_Просмотреть отчет Allure после выполнения тестов:_
```bash
mvn allure:serve
```


