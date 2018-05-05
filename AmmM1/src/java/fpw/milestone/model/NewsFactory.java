/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;

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
		DateFormat df = new SimpleDateFormat("dd/MM/yy");

		int id = 0;
		// pinco pallino news
		User user = new User(); // only id, name, surname
		user.setId(1);
		user.setName("Pinco");
		user.setSurname("Pallino");
		News news = new News();
		news.setId(id++);
		news.setAuthor(user);
		try {
			news.setDate(df.parse("2/3/18"));
		} catch (ParseException e) {
		}
		news.setCategory(fpw.milestone.model.News.Category.CRONACA);
		news.setTitle("Autostrada A1 chiusa per neve");
		news.setDesc("Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		news.setImageUrl("pics/snowman.png");
		news.setImageDesc("Pupazzi in autostrada");
		list.add(news);

		news = new News();
		news.setId(id++);
		news.setAuthor(user);
		try {
			news.setDate(df.parse("22/3/18"));
		} catch (ParseException e) {
		}
		news.setCategory(fpw.milestone.model.News.Category.CRONACA);
		news.setTitle("title4");
		news.setDesc("desc4");
		news.setImageUrl("pics/snowman.png");
		news.setImageDesc("imagedesc4");
		list.add(news);

		news = new News();
		news.setId(id++);
		news.setAuthor(user);
		try {
			news.setDate(df.parse("22/4/18"));
		} catch (ParseException e) {
		}
		news.setCategory(fpw.milestone.model.News.Category.CRONACA);
		news.setTitle("title5");
		news.setDesc("desc5");
		news.setImageUrl("pics/snowman.png");
		news.setImageDesc("imagedesc5");
		list.add(news);

		news = new News();
		news.setId(id++);
		news.setAuthor(user);
		try {
			news.setDate(df.parse("23/1/18"));
		} catch (ParseException e) {
		}
		news.setCategory(fpw.milestone.model.News.Category.CRONACA);
		news.setTitle("I fantastici astici");
		news.setDesc("! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! !");
		news.setImageUrl("pics/snowman.png");
		news.setImageDesc("imagedesc6");
		list.add(news);

		news = new News();
		news.setId(id++);
		news.setAuthor(user);
		try {
			news.setDate(df.parse("25/2/18"));
		} catch (ParseException e) {
		}
		news.setCategory(fpw.milestone.model.News.Category.CRONACA);
		news.setTitle("I castori rosicanti");
		news.setDesc("ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK");
		news.setImageUrl("pics/snowman.png");
		news.setImageDesc("imagedesc6");
		list.add(news);

		news = new News();
		news.setId(id++);
		news.setAuthor(user);
		try {
			news.setDate(df.parse("27/3/18"));
		} catch (ParseException e) {
		}
		news.setCategory(fpw.milestone.model.News.Category.CRONACA);
		news.setTitle("Holy moly");
		news.setDesc("H O L Y M O L Y");
		news.setImageUrl("pics/snowman.png");
		news.setImageDesc("imagedesc6");
		list.add(news);

		// pinco pallone news
		user = new User(); // only id, name, surname
		user.setId(2);
		user.setName("Pinco");
		user.setSurname("Pallone");
		news = new News();
		news.setId(id++);
		news.setAuthor(user);
		try {
			news.setDate(df.parse("3/4/18"));
		} catch (ParseException e) {
		}
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
		news.setId(id++);
		news.setAuthor(user);
		try {
			news.setDate(df.parse("4/5/18"));
		} catch (ParseException e) {
		}
		news.setCategory(fpw.milestone.model.News.Category.CULTURA);
		news.setTitle("Festa delle feste annunciata");
		news.setDesc("GONNA PARTY HARD");
		news.setImageUrl("pics/partyhard.png");
		news.setImageDesc("Party Hard");
		list.add(news);

		// sort the list by desc date
		Collections.sort(list, new Comparator<News>() {
			@Override
			public int compare(News a, News b)
			{
				return -a.getDate().compareTo(b.getDate());
			}
		});
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
		return getNewsByAuthor(usr.getId());
	}

	public List<News> getNewsByAuthor(int id) {
		// just for milestone2 (list of news)
		List<News> newsList = this.getNews();
		ArrayList<News> outList = new ArrayList<>();
		for (News n : newsList) {
			if (n.getAuthor().getId() == id)
				outList.add(n);
		}
		return outList;
	}

	public List<News> getNewsByCategory(int id) {
		return getNewsByCategory(fpw.milestone.model.News.Category.fromInteger(id));
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
