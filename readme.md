<div align="center">
    <img src=".github/cover.png" alt="Cover">
</div>

[![](https://img.shields.io/badge/Пост_в_Telegram-24A1DE?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/foundout)
[![](https://img.shields.io/badge/Пост_на_Boosty-F15F2C?style=for-the-badge&logo=boosty&logoColor=F6F6F6)](https://boosty.to/michaelbel/posts/b100d648-e7f1-4d0d-b30a-37f7777b277f)
[![](https://img.shields.io/badge/Видео_на_YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://www.youtube.com/@michaelbely)


BuildFlavors
=

[![workflow-status](https://img.shields.io/github/actions/workflow/status/michaelbel/buildflavors/ci.yml?style=for-the-badge&logo=github&labelColor=3F464F)](https://github.com/michaelbel/buildflavors/actions)
[![last-commit](https://img.shields.io/github/last-commit/michaelbel/buildflavors?style=for-the-badge&logo=github&labelColor=3F464F)](https://github.com/michaelbel/buildflavors/commits)

Элегантное разделение проекта на отдельные сборки для магазинов Google Play, Huawei AppGallery и F-Droid, используя механизм Product Flavors. Он позволяет в рамках одной кодовой базы собирать APK с разными SDK, конфигурациями и зависимостями.

Код разнесен по платформенным модулям :gms, :hms и :foss. Все они реализуют общий контракт из :common, где описан интерфейс AppInteractor. Благодаря этому основной код приложения работает с единой абстракцией, не зная, какой именно сервис подключён – Google или Huawei.

Каждая реализация живет в своём модуле и подключает нужные зависимости: FirebaseAnalytics для Google и HiAnalytics для Huawei. В FOSS-вариант не подключается ничего. Связывание выполняется через модуль :inject, где с помощью Hilt определяется, какая реализация будет подставлена в зависимости от активного flavor.

В приложении задаются три flavors: gms, hms и foss. implementation-конфигурации гарантируют, что в сборку попадет только нужный код. Для плагинов добавлены переменные, вынесенные в buildSrc, чтобы подключать их условно.

Результат – три полностью автономных APK: один использует сервисы Google, другой – Huawei, а третий подходит для F-Droid и устройств без проприетарных SDK. Такой подход даёт гибкость и минимум дублирования, а главное – позволяет поддерживать все экосистемы Android-устройств из одной кодовой базы.