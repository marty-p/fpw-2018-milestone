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
		User user = new User(); // only id, name, surname
		user.setId(1);
		user.setName("Pinco");
		user.setSurname("Pallino");
		News news = new News();
		news.setId(1);
		news.setAuthor(user);
		news.setDate("2/3/18");
		news.setCategory(fpw.milestone.model.News.Category.CRONACA);
		news.setTitle("Autostrada A1 chiusa per neve");
		news.setDesc("Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		news.setImageUrl("pics/snowman.png");
		news.setImageDesc("Pupazzi in autostrada");
		list.add(news);

		// pinco pallone news
		user = new User(); // only id, name, surname
		user.setId(2);
		user.setName("Pinco");
		user.setSurname("Pallone");
		news = new News();
		news.setId(2);
		news.setAuthor(user);
		news.setDate("3/4/18");
		news.setCategory(fpw.milestone.model.News.Category.SPORT);
		news.setTitle("Tangenziale CC chiusa per palle");
		news.setDesc("LE PALLE CI STANNO INVADENDO");
		news.setImageUrl("pics/palleintangenziale.png");
		news.setImageDesc("Palle in tangenziale");
		list.add(news);

		// pinco palloncino news
		user = new User(); // only id, name, surname
		user.setId(3);
		user.setName("Pinco");
		user.setSurname("Palloncino");
		news = new News();
		news.setId(3);
		news.setAuthor(user);
		news.setDate("4/5/18");
		news.setCategory(fpw.milestone.model.News.Category.CULTURA);
		news.setTitle("Festa delle feste annunciata");
		news.setDesc("GONNA PARTY HARD");
		news.setImageUrl("pics/partyhard.png");
		news.setImageDesc("Party Hard");
		list.add(news);

		return list;
	}

	public News getNewsById(int id) {
		// just for milestone2 (list of news)
		List<News> newsList = this.getNews();
		for (News n : newsList) {
			if (n.getId() == id)
				return n;
		}
		return null;
	}

	public List<News> getNewsByAuthor(User usr) {
		// just for milestone2 (list of news)
		List<News> newsList = this.getNews();
		ArrayList<News> outList = new ArrayList<>();
		for (News n : newsList) {
			if (n.getAuthor().getId() == usr.getId())
				outList.add(n);
		}
		return outList;
	}

	public List<News> getNewsByCategory(fpw.milestone.model.News.Category c) {
		// just for milestone2 (list of news)
		List<News> newsList = this.getNews();
		ArrayList<News> outList = new ArrayList<>();
		for (News n : newsList) {
			if (n.getCategory() == c)
				outList.add(n);
		}
		return outList;
	}
}
