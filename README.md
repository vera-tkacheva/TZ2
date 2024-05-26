# Техническое задание 2
![Java CI with Maven](https://github.com/vera-tkacheva/TZ2/actions/workflows/maven.yml/badge.svg)

## Условие
> Реализуйте программу, которая считывает из файла числа, а далее отдельными функциями ищет среди этих чисел минимальное число, максимальное число, считает их общую сумму и произведение.
> 
> Числа в файле записаны в одной строке, друг от друга отделены пробелами. В файле есть минимум одно число. Максимально возможное количество чисел в файле - 1 млн.
> 
> Для этой программы подготовьте тесты: проверяющие корректность работы функций поиска минимума и максимума, проверяющие корректность работы функций сложения и умножения, выводящие скорость работы функций.

## Функционал

1. Реализованы функции чтения из файла, поиска минимального числа `min()`, поиска максимального числа `max()`, сложения `sum()` и умножения `mult()`, а также функция поиска среднего арифметического `middle()` всех чисел из файла.
2. Реализованы тесты для проверки корректности функций поиска минимума, максимума, сложения и умножения с помощью метода `assertEquals(ожидаемое_значение, фактическое_значение)`.
3. Реализованы тесты для проверки скорости работы программы для каждой из функций: поиск минимума, максимума, сложение и умножение (`minTime()`, `maxTime()`, `sumTime()`, `multTime()`).
4. Реализован тест `divisionByZero()`, проверяющий деление максимума на минимум, который использует метод `assertThrows()` и выбрасывает сообщение `"Деление на 0!"` в соответствующем случае.
5. Реализован падающий тест `timeCheck()`, над которым стоит аннотация *@Disabled*, чтобы проверить, что только он падает, а все остальные тесты прошли.

-------
7. Построен график зависимости времени выполнения (*в миллисекундах*) функции `max()` от кол-ва чисел в файле по данным в таблице, полученным в результате работы функций пункта 3 с разными файлами:
### Таблица данных
| Количество чисел в файле | Время работы max, нс 
|:-------------------------|:--------------------
10	| 0,00475
50	| 0,007291
100	| 0,01025
500	| 0,040958
1000 | 0,062
2000 |	0,109417
5000 |	0,263708
10000	| 0,542333
15000	| 0,898167
20000	| 1,440334
50000 |	2,257916

### График

![график](graph.png)

На графике видна линейная зависимость. 

__Объяснение:__ Ассимптотика функции `max()` = *O(n)*, где n - количество чисел в файле. 


## Как запускать проект?
