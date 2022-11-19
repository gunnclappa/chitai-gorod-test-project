# Проект по автоматизации тестирования интернет-магазина «Читай-город»

![chitai-gorod.png](https://raw.githubusercontent.com/gunnclappa/chitai-gorod-test-project/141d00405fd7686c0821ddb8edc0b484b4965688/external/chitai-gorod.png)
> «Читай-город» – это самая большая в России сеть книжных магазинов и интернет-магазин.

## :bookmark_tabs: Содержание
* <a href="#description">Описание</a>
* <a href="#stack">Cтек технологий</a>
* <a href="#object">Реализованные проверки</a>
* <a href="#gradle-launch">Запуск проекта с помощью терминала</a>
* <a href="#jenkins-launch">Запуск проекта с помощью Jenkins</a>
* <a>Отчётность, скриншоты и видео</a>
  + <a href="#allure">Allure</a>
  + <a href="#allure-testops">Allure TestOps</a>
  + <a href="#selenoid">Selenoid</a>
  + <a href="#browserstack">Browserstack</a>
  + <a href="#telegram">Telegram</a>
  
## <a name="description">Описание</a>
Проект содержит в себе тесты на UI, API и Mobile (Android)\
Список того, что было реализовано в проекте:
- [x] Реализация `Page Object` с использованием `Chain of Invocations`
- [x] Параметризованные тесты
- [x] Параллельное выполнение тестов с помощью `JUnit 5`
- [x] Генерация рандомных значений с помощью библиотеки `Faker`
- [x] Параметризованные билды `Jenkins`
- [x] Конфиги с помощью библиотеки `Owner`
- [x] Использование `POJO` для моделей для API тестов
- [x] Использование Request/Response спецификаций для API тестов
- [x] Кастомный Allure listener для форматированного логирования API запросов/ответов
- [x] Интеграция с `Allure TestOps`


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

<a id="gradle-launch"></a>
## :computer: Запуск проекта с помощью терминала

Для запуска тестов с помощью Gradle используется команда:
```bash
gradle clean test -Dtag=<tag> -Dplatform=<platform> -Denv=<env>
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

<a id="jenkins-launch"></a>
##  <a href="https://jenkins.autotests.cloud/job/chitai-gorod/"><img alt="Jenkins" height="50" src="external/Jenkins.svg" width="50"/>Jenkins</a>

Страница проекта в Jenkins

<a href="https://jenkins.autotests.cloud/job/chitai-gorod/"><img src="https://user-images.githubusercontent.com/110110734/202859544-d8c8b67d-1dcf-48b0-8d80-6170ec8f19a4.png" alt="Jenkins">
</a>

Параметры сборки:
>- *`tag` - выбор вида тестов*
>- *`platform` - платформа*
>- *`env` - окружение, на котором будут выполнятся тесты*
>- *`browser` - браузер*
>- *`REMOTE_URL` - адрес Selenoid*
>- *`VIDEO_STORAGE` - адрес хранилища видео Selenoid*

<a id="allure"></a>
## <a href="https://jenkins.autotests.cloud/job/chitai-gorod/allure/"><img alt="Allure" height="50" src="external/Allure.svg" width="50"/>Allure</a>

Пример Allure отчёта

<table>
    <tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202859651-ba7db225-1307-42d1-a756-acb5ee53464a.png">
        <img src="https://user-images.githubusercontent.com/110110734/202859651-ba7db225-1307-42d1-a756-acb5ee53464a.png">
        </a>
        </td>
        </tr>
        <tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202859732-4dc2727f-69bf-4828-9d87-08ead0eb67e4.png">
        <img src="https://user-images.githubusercontent.com/110110734/202859732-4dc2727f-69bf-4828-9d87-08ead0eb67e4.png">
        </a>
        </td>
</table>

<a id="allure-testops"></a>
## <a href="https://allure.autotests.cloud/project/1687/dashboards"><img alt="Allure TestOps" height="50" src="external/Allure TestOps.svg" width="50"/>Allure TestOps</a>

Пример Allure TestOps отчёта

<table>
    <tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202862964-974dfa9d-55ef-4a77-8406-2bc6952ea790.png">
        <img src="https://user-images.githubusercontent.com/110110734/202862964-974dfa9d-55ef-4a77-8406-2bc6952ea790.png">
        </a>
        </td>
   </tr>
        <tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202862978-f86145e3-4d34-4d7e-a0bb-35af7f5115a3.png">
        <img src="https://user-images.githubusercontent.com/110110734/202862978-f86145e3-4d34-4d7e-a0bb-35af7f5115a3.png">
        </a>
        </td>
        </tr>
        <td>
        <a href="https://user-images.githubusercontent.com/110110734/202862981-42f72adc-1519-4a39-bfd6-5f011ea82552.png">
        <img src="https://user-images.githubusercontent.com/110110734/202862981-42f72adc-1519-4a39-bfd6-5f011ea82552.png">
        </a>
        </td>
</table>

<a id="selenoid"></a>
## <img alt="Selenoid" height="50" src="external/Selenoid.svg" width="50"/> Selenoid</a>

Видео-пример выполнения UI-теста с помощью Selenoid

<video src="https://user-images.githubusercontent.com/110110734/202859382-0d5509e0-a5a8-4c7f-9df0-9d8bcf16fc2f.mp4"
controls="controls" style="max-width: 730px;" poster="/external/logos/Selenoid.svg"></video>

<a id="browserstack"></a>
## <img alt="Browserstack" height="45" src="external/Browserstack.svg" width="45"/> Browserstack</a>

Видео-пример выполнения Mobile-теста с помощью Browserstack

<video src="https://user-images.githubusercontent.com/110110734/202863081-112a3796-fd9d-40ce-9684-392458f28ee8.mp4"
controls="controls" style="max-width: 730px;" poster="/external/logos/Browserstack.svg"></video>

<a id="telegram"></a>
## <a href="https://t.me/chitai_gorod_tests_bot"><img alt="Telegram" height="50" src="external/Telegram.svg" width="50"/>Telegram</a>

Пример уведомления в Telegram-бот по окончании выполнения тестов

![Telegram screenshot](https://user-images.githubusercontent.com/110110734/202859925-48e64223-96aa-41b1-9a32-2ca475a547c5.png)
