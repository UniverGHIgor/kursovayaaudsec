package ru.mirea.osintkurs ;

public class Main {

    public static void main(String[] args) {
	/*
	* Приложение для аудита конфиденциальности личных данных.
	* Цель: Создать приложение для обработки свободной информации, находящейся в сети Интернет, с целью поиска утечки личных данных пользователя.
	* Приложение созданно для ознакомления и аудита безопасности персональных данных, берёт информацию из открытых источников и не записывает полученные данные для последующего использования.
	* !Авторы категорически против использования данного приложения в любых незаконных целях и не несут ответственности за Ваши действия!
	* */
		System.setProperty("java.net.preferIPv4Stack" , "true");

		sqlconnect A = new sqlconnect();
		A.main();

		Employee.SQLInsert B = new Employee.SQLInsert();
		B.main();
    }

}
