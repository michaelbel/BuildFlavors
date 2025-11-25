<div align="center">
    <img src=".github/cover.png" alt="Cover">
</div>

[![](https://img.shields.io/badge/Пост_в_Telegram-24A1DE?&style=for-the-badge&logo=data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNDciIGhlaWdodD0iMzkiIHZpZXdCb3g9IjAgMCA0NyAzOSIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0zLjE3MjkyIDE2LjQ2NjRDMTUuNTYyNSAxMS4wNjg0IDIzLjgyNDIgNy41MDk3NSAyNy45NTggNS43OTAzOEMzOS43NjA3IDAuODgxMjMxIDQyLjIxMzIgMC4wMjg0NTkzIDQzLjgxMTcgMC4wMDAzMDAyMzhDNDQuMTYzMiAtMC4wMDU4OTMwMyA0NC45NDkzIDAuMDgxMjM3OSA0NS40NTg1IDAuNDk0NDJDNDUuODg4NSAwLjg0MzMwMyA0Ni4wMDY4IDEuMzE0NTkgNDYuMDYzNCAxLjY0NTM3QzQ2LjEyIDEuOTc2MTUgNDYuMTkwNSAyLjcyOTY4IDQ2LjEzNDUgMy4zMTg0NkM0NS40OTQ5IDEwLjAzODcgNDIuNzI3NCAyNi4zNDcgNDEuMzE5NCAzMy44NzM4QzQwLjcyMzcgMzcuMDU4NyAzOS41NTA2IDM4LjEyNjUgMzguNDE1IDM4LjIzMUMzNS45NDY5IDM4LjQ1ODIgMzQuMDcyOCAzNi42IDMxLjY4MjMgMzUuMDMzQzI3Ljk0MTggMzIuNTgxIDI1LjgyODYgMzEuMDU0NyAyMi4xOTc4IDI4LjY2MkMxOC4wMDE3IDI1Ljg5NjggMjAuNzIxOCAyNC4zNzcxIDIzLjExMzIgMjEuODkzM0MyMy43MzkgMjEuMjQzMyAzNC42MTMzIDExLjM1MjMgMzQuODIzOCAxMC40NTVDMzQuODUwMSAxMC4zNDI4IDM0Ljg3NDUgOS45MjQ1MSAzNC42MjYgOS43MDM2NEMzNC4zNzc1IDkuNDgyNzYgMzQuMDEwNyA5LjU1ODI5IDMzLjc0NjEgOS42MTgzNkMzMy4zNzA5IDkuNzAzNTEgMjcuMzk1MyAxMy42NTMxIDE1LjgxOTMgMjEuNDY3M0MxNC4xMjMyIDIyLjYzMiAxMi41ODY4IDIzLjE5OTUgMTEuMjEwNCAyMy4xNjk3QzkuNjkyODkgMjMuMTM2OSA2Ljc3Mzg4IDIyLjMxMTcgNC42MDM5MSAyMS42MDY0QzEuOTQyMzQgMjAuNzQxMiAtMC4xNzMwMTkgMjAuMjgzOCAwLjAxMTE4MTUgMTguODE0NEMwLjEwNzEyNCAxOC4wNDkxIDEuMTYxMDQgMTcuMjY2NCAzLjE3MjkyIDE2LjQ2NjRaIiBmaWxsPSJ3aGl0ZSIvPgo8L3N2Zz4K)](https://t.me/michaelbel/306)
[![](https://img.shields.io/badge/Пост_на_Boosty-F15F2C?style=for-the-badge&logo=boosty&logoColor=F6F6F6)](https://boosty.to/michaelbel/posts/b100d648-e7f1-4d0d-b30a-37f7777b277f)
[![](https://img.shields.io/badge/Видео_на_YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://youtu.be/Oy2aJm2RsJg)


BuildFlavors
=

[![workflow-status](https://img.shields.io/github/actions/workflow/status/michaelbel/buildflavors/ci.yml?style=for-the-badge&logo=github&labelColor=3F464F)](https://github.com/michaelbel/buildflavors/actions)
[![last-commit](https://img.shields.io/github/last-commit/michaelbel/buildflavors?style=for-the-badge&logo=github&labelColor=3F464F)](https://github.com/michaelbel/buildflavors/commits)

Элегантное разделение проекта на отдельные сборки для магазинов Google Play, Huawei AppGallery и F-Droid, используя механизм Product Flavors. Он позволяет в рамках одной кодовой базы собирать APK с разными SDK, конфигурациями и зависимостями.

Код разнесен по платформенным модулям :gms, :hms и :foss. Все они реализуют общий контракт из :common, где описан интерфейс AppInteractor. Благодаря этому основной код приложения работает с единой абстракцией, не зная, какой именно сервис подключён – Google или Huawei.

Каждая реализация живет в своём модуле и подключает нужные зависимости: FirebaseAnalytics для Google и HiAnalytics для Huawei. В FOSS-вариант не подключается ничего. Связывание выполняется через модуль :inject, где с помощью Hilt определяется, какая реализация будет подставлена в зависимости от активного flavor.

В приложении задаются три flavors: gms, hms и foss. implementation-конфигурации гарантируют, что в сборку попадет только нужный код. Для плагинов добавлены переменные, вынесенные в buildSrc, чтобы подключать их условно.

Результат – три полностью автономных APK: один использует сервисы Google, другой – Huawei, а третий подходит для F-Droid и устройств без проприетарных SDK. Такой подход даёт гибкость и минимум дублирования, а главное – позволяет поддерживать все экосистемы Android-устройств из одной кодовой базы.