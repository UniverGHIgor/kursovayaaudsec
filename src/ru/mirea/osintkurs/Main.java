package ru.mirea.osintkurs ;

public class Main {
	static String  url      = "jdbc:mysql://mysql.j06318538.myjino.ru:3306/j06318538",
			namebase = "j06318538",
			pass     = "kursovaya",
			table    = "Popular";

	public static void main(String[] args) {
		/*
		 * Приложение для аудита конфиденциальности личных данных.
		 * Цель: Создать приложение для обработки свободной информации, находящейся в сети Интернет, с целью поиска утечки личных данных пользователя.
		 * Приложение созданно для ознакомления и аудита безопасности персональных данных, берёт информацию из открытых источников и не записывает полученные данные для последующего использования.
		 * !Авторы категорически против использования данного приложения в любых незаконных целях и не несут ответственности за Ваши действия!
		 * */
		System.setProperty("java.net.preferIPv4Stack" , "true");
//		SQL AA = new SQL(url,namebase,pass);
		//SQLconnect A = new SQLconnect(url,namebase,pass,table);
		//A.Startconnect();
		//SQLInsert B = new SQLInsert(url,namebase,pass,table);
		//B.Startinsert();
		//SQLsearch C = new SQLsearch(url,namebase,pass,table);
		//C.search();
		//SQLDelete D = new SQLDelete(url,namebase,pass,table);
		//D.Startdelete();
	}

}
