# Проект по автоматизации тестирования интернет-магазина «Читай-город»

![chitai-gorod.png](https://raw.githubusercontent.com/gunnclappa/chitai-gorod-test-project/141d00405fd7686c0821ddb8edc0b484b4965688/external/chitai-gorod.png)
> «Читай-город» – это самая большая в России сеть книжных магазинов и интернет-магазин.

## :bookmark_tabs: Содержание
* <a href="#description">Описание</a>
* <a href="#stack">Cтек технологий</a>
* <a href="#object">Реализованные проверки</a>
* <a href="#launch">Запуск проекта</a>
   + <a href="#gradle-command">Gradle</a>
   + <a href="#idea-config">Запуск конфигурации в IDEA</a>
* <a>Скриншоты и видео</a>
  + <a href="#selenoid">Selenoid</a>
  + <a href="#jenkins">Jenkins</a>
  + <a href="#allure">Allure</a>
  + <a href="#telegram">Telegram</a>
  
## <a name="description">Описание</a>
Проект содержит в себе тесты на UI, API и Mobile (Android)\
Список того, что было реализовано в проекте:
- [x] Реализация `Page Object` с использованием `Chain of Invocations`
- [x] Параметризованные тесты
- [x] Параллельное выполнение тестов с помощью `JUnit 5`
- [x] Генерация рандомных значений с помощью библиотеки `Faker`
- [x] Параметризованные билды `Jenkins`
- [x] Конфигурационные файлы для запуска билдов с различными параметрами
- [x] Конфиги с помощью библиотеки `Owner`
- [x] Использование `POJO` для моделей для API тестов
- [x] Objects serialization/deserialization for API requests/responses using `Jackson`
- [x] Использование Request/Response спецификаций для API тестов
- [x] Кастомный Allure listener для форматированного логирования API запросов/ответов
- [x] Интеграция с `Allure TestOps`
- [x] Autotests as test documentation
- [x] Интеграция с `Jira`


<a id="stack"></a>
## :hammer_and_wrench: Cтек технологий
<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="external/Intelij_IDEA.svg" width="50"/></a>
<a href="https://www.java.com/"><img alt="Java" height="50" src="external/Java.svg" width="50"/></a>
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="external/JUnit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="external/Selenide.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="REST Assured" height="50" src="external/Rest-Assured.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="external/Gradle.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure" height="50" src="external/Allure.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="external/Jenkins.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="external/Selenoid.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="external/GitHub.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="external/Telegram.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="external/Allure TestOps.svg" width="50/></a>
<a href="https://appium.io/"><img alt="Appium" height="45" src="external/Appium.svg" width="45"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="45" src="external/Browserstack.svg" width="45"/></a>
</div>

<a id="object"></a>
## :mag: Реализованные проверки

<a id="launch"></a>
# :computer: Запуск проекта
  
<a id="gradle-command"></a>
## Gradle
Для запуска тестов с помощью Gradle используется команда:
```bash
gradle clean <tag> -Dplatform=<platform> -Denv=<env>
```
`tag` - выбор вида тестов:
>- *api*
>- *ui*
>- *mobile*
  
`platform` - платформа:
>- *\<не задаётся\> (для API тестов)*
>- *ui*
>- *mobile*
  
`env` - окружение, на котором будут выполнятся тесты:
>- *\<не задаётся\> (для API тестов)*
>- *remote (для UI)*
>- *real (для Mobile)*
>- *browserstack (для Mobile)*
>- *local (для UI и Mobile тестов)*

В зависимости от выбранной платформы и окружения, будет использоваться определенный property file

<a id="idea-config"></a>  
## Запуск конфигурации в IDEA
Для удобства запуска тестов конфигурационные файлы IDEA добавлены в репозиторий
<p  align="center">
<img src="external/idea-conf.png" alt="IDEARunConfigurations" width="550">
</p>

<a id="selenoid"></a>
## <a href="https://selenoid.autotests.cloud/video/4a544544d069a501ee461083c9babb79.mp4"><img alt="Selenoid" height="50" src="external/Selenoid.svg" width="50"/>Selenoid</a>

<video src="https://user-images.githubusercontent.com/110110734/193814550-cef6ecdb-f702-4fa5-a6cf-4cf6cc523097.mp4"
controls="controls" style="max-width: 730px;" poster="/external/logos/Selenoid.svg">
Видео не доступно для этого браузера
</video>

<a id="jenkins"></a>
##  <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/"><img alt="Jenkins" height="50" src="external/Jenkins.svg" width="50"/>Jenkins</a>
  
<a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/">

<img src="https://user-images.githubusercontent.com/110110734/193813994-88c78b62-b6d9-4d00-ac2a-d7eae8e491b7.png" alt="Jenkins">
</a>

<a id="allure"></a>
## <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure//"><img alt="Allure" height="50" src="external/Allure.svg" width="50"/>Allure</a>

<table>
    <tr>
        <td>
        <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure/">
        <img src="https://user-images.githubusercontent.com/110110734/193815548-9ba63976-7543-438d-b4aa-51fea0db888e.png">
        </a>
        </td>
        <td>
        <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure/#suites/ef54aae4465c6d48b51f0d82b2bbde21/238f0e3250120aee/">
        <img src="https://user-images.githubusercontent.com/110110734/193815656-d60c090e-77ba-4f08-b4bb-d3860e2976a3.png">
        </a>
        </td>
    </tr>
        <tr>
        <td>
        <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure/#suites/ef54aae4465c6d48b51f0d82b2bbde21/238f0e3250120aee/">
        <img src="https://user-images.githubusercontent.com/110110734/193815846-f7c8675e-ae5c-44b4-a451-a66a32037746.png">
        </a>
        </td>
        <td>
        <a href="https://jenkins.autotests.cloud/job/Nurekenov-homework16/allure/#suites/ef54aae4465c6d48b51f0d82b2bbde21/e86211dfbb768d26/">
        <img src="https://user-images.githubusercontent.com/110110734/193815857-a19d8da8-d07f-4e2a-a4f4-893eae213dbf.png">
        </a>
        </td>
    </tr>
</table>

<a id="telegram"></a>
## <a href="https://t.me/MarketKzNotificationBot"><img alt="Telegram" height="50" src="external/Telegram.svg" width="50"/>Telegram</a>

![Telegram screenshot](https://user-images.githubusercontent.com/110110734/193813963-0e4ec16a-b6d3-45d3-bf0d-dc90eb689380.png)
