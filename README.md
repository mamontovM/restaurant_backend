# Инструкция настройки базы данных
1. Данное приложение тестировалось на PostgreSQL 11.
2. Создайте базу даннных с именем **restaurant** и владельцем **postgres**
3. Установите пароль **postgres** для пользвателя **postgres** 
   Либо в **src/resources/application.yml** в блоке datasource указать свои данные
4. Готово

# Ресторан
Необходимо реализовать систему управления рестораном. Система должна позволять управлять снабжением ресторана и оформлять заказы. 

## Описание ядра приложения:
Системя управления рестораном дставляет собой веб-приложение с ролевым доступам к компонентам. В системе предусмотрены следующие роли:
-	Администратор (A)
-	Повар (C)
-	Официант (W)
-	Провизор (P)

В системе должны быть предусмотрены следующие функции (значение в скобках - роли, которые могут выполнять функционал):
1. (А) Регистрация в системе других пользователей
2. (А) Настройка меню. Каждое блюдо имеет следующие характеристики:
   -	Тип блюда (первое, второе, десерт и т.д.)
   -	Ингредиенты с указанием веса/количества/объема.
   -	Стоимость
3. (A, P, C) Получение информации о текущих ингредиентах, а также о необходимости закупки. Считать, что какой-либо продукт необходимо закупить если:
   -	У оставшихся продуктов срок годности меньше недели
   -	Ингридиентов недостаточно для приготовления 10 порций блюда.
4. (P) Внесение ингредиентов в систему. Каждый ингредиент имеет следующие параметры:
   -	Название
   -	Единица измерения (граммы, миллилитры, штуки и т.д.)
   -	Количество единиц
   -	Срок годности
5. (W) Составление заказа для поваров (одного или нескольких блюд)
6. (С) Взятие заказа на себя, а также пометка заказа как готового для заданного официанта
7. (W) Получение доступного меню с количеством порций. Вычислять по количеству ингредиентов минус уже заказанные порции.
8. (A) Получение информации об актуальном количестве продуктов, использованных ингредиентов, проданных блюд и выручке за произвольный период времени.
9. Ввести в приложение понятия возможного хранимого объёма:
    -	Каждый ингредиент должен иметь также параметр объёма на единицу. 
    -	В системе должен появиться ограничение на допустимый объем занимаемого ингредиентами пространства.
    -	Контролировать объем продуктов согласно ограничению на общий занимаемый объём


