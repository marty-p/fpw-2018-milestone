/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marty
 */
public class NewsFactory {
	private static NewsFactory singleton;
	public static NewsFactory getInstance(){
		if(singleton == null)
			singleton = new NewsFactory();
		return singleton;
	}

	public List<News> getNews() {
		// just for milestone2 (list of news)
		ArrayList<News> list = new ArrayList<>();

		// pinco pallino news
		News news = new News();
		User user = new User(); // only id, name, surname
		user.setId(1);
		user.setName("Pinco");
		user.setSurname("Pallino");
		news.setAuthor(user);
		news.setDate("2/3/18");
		news.setCategory(fpw.milestone.model.News.Category.CRONACA);
		news.setTitle("Autostrada A1 chiusa per neve");
		news.setDesc("Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		news.setImageUrl("pics/snowman.png");
		news.setImageDesc("Pupazzi in autostrada");
		list.add(news);

		// pinco pallone news
		news = new News();
		user = new User(); // only id, name, surname
		user.setId(2);
		user.setName("Pinco");
		user.setSurname("Pallone");
		news.setAuthor(user);
		news.setDate("3/4/18");
		news.setCategory(fpw.milestone.model.News.Category.SPORT);
		news.setTitle("Tangenziale CC chiusa per palle");
		news.setDesc("LE PALLE CI STANNO INVADENDO");
		news.setImageUrl("pics/palleintangenziale.png");
		news.setImageDesc("Palle in tangenziale");
		list.add(news);

		// pinco palloncino news
		news = new News();
		user = new User(); // only id, name, surname
		user.setId(2);
		user.setName("Pinco");
		user.setSurname("Palloncino");
		news.setAuthor(user);
		news.setDate("4/5/18");
		news.setCategory(fpw.milestone.model.News.Category.CULTURA);
		news.setTitle("Festa delle feste annunciata");
		news.setDesc("desc2");
		news.setImageUrl("pics/partyhard.png");
		news.setImageDesc("Party Hard");
		list.add(news);

		return list;
	}

	News getNewsById(int id) {
		return null;
	}

	List<News> getNewsByAuthor(User usr) {
		return null;
	}

	List<News> getNewsByCategory(fpw.milestone.model.News.Category c) {
		return null;
	}
}
