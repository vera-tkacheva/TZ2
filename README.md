# Техническое задание 2

__Текущий статус прохождения тестов__:

![Java CI with Maven](https://github.com/vera-tkacheva/TZ2/actions/workflows/maven.yml/badge.svg)


## Условие
> Реализуйте программу, которая считывает из файла числа, а далее ищет минимум, максимум, считает общую сумму и произведение.
> 
> Числа в файле записаны в одной строке, друг от друга отделены пробелами. В файле есть *минимум одно число*. Максимально возможное количество чисел в файле - 1 млн.
> 
> Для этой программы подготовьте тесты:
>  - проверяющие корректность работы функций поиска минимума и максимума,
>  - проверяющие корректность работы функций сложения и умножения,
>  - выводящие скорость работы функций.



## Функционал
### Класс NumericalFunctions
- Чтение из файла с помощью `Scanner`
- Поиск минимального числа - `min()`
- Поиск максимального числа - `max()`
- Сложение всех чисел - `sum()`
- Умножение всех чисел - `mult()`
### Класс NumericalFunctionsTest
- Тесты для проверки корректности функций с помощью метода `assertEquals(ожидаемое_значение, фактическое_значение)`:
  - `minTest`
  - `maxTest`
  - `sumTest`
  - `multTest`
- Падающий тест `timeCheck()`, над которым стоит аннотация *@Disabled* (для понимания, что падает только этот тест, а все остальные прошли)
### Класс Benchmarking
- Методы, чтобы замерять производительность функций:
  - `minTime()`
  - `maxTime()`
  - `sumTime()`
  - `multTime()`
- Методы применяются ко всем тестовым файлам с помощью перебора. В консоль выводится время работы каждой функции для каждого файла.
-------
Построен график зависимости времени выполнения (*в миллисекундах*) функции `max()` от кол-ва чисел в файле по данным в таблице, полученным с помощью работы класса *Benchmarking*.
### Таблица данных
| Количество чисел в файле | Время работы max, нс 
|:-------------------------|:--------------------
10	| 0,000416
50	| 0,000458
100	| 0,000459
500	| 0,000458
1000 | 0,000375
2000 |	0,0005
5000 |	0,000583
10000	| 0,542333
15000	| 0,000625
20000	| 0,0025

### График

![график](graphic.png)

На графике видна линейная зависимость (с погрешностью). Ассимптотика функции `max()` = *O(n)*, где n - количество чисел в файле. 

__Объяснение:__ Функция реализована так, что максимум находится перебором всех элементов массива, содержащего числа из файла.


## Как запускать проект?
С помощью команды в терминале в корневой директории проекта:
```
mvn test
```
Эта команда выполнит все тесты каталога `src/test/java/com.test`.

## Интеграция CI и Telegram (maven.yml)
С помощью действия `appleboy/telegram-action@master` отправляются уведомления в Telegram.

- При успешном прохождении тестов бот присылает сообщение `Всё ок`.
- При неуспешном прохождении тестов:
  - создается отчет о не пройденных тестах в формате XML `failed-test-report.xml`
  - бот присылает сообщение `Некоторые тесты не пройдены:` и отчет
-----
