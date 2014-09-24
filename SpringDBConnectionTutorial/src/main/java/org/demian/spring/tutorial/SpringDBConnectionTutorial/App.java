package org.demian.spring.tutorial.SpringDBConnectionTutorial;

import java.util.LinkedList;
import java.util.List;
import org.demian.spring.tutorial.SpringDBConnectionTutorial.model.Offer;
import org.demian.spring.tutorial.SpringDBConnectionTutorial.model.OffersDAO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		Robot robot = (Robot) context.getBean("robot");
		robot.speak();
		OffersDAO offersDAO = (OffersDAO) context.getBean("offersDAO");
		List<Offer> offers = new LinkedList<Offer>();
		try {
			offers.add(new Offer("Buni", "buni@yahoo.com", "Salut la toată lumea!"));
			offers.add(new Offer("Tommaso", "tommaso.grotto@gmail.com", "Salve a tutti!"));
			offers.add(new Offer("Ema", "emanuele.casadio@gmail.com", "Sono Ema!"));
			offersDAO.insert(offers);
			offers = null;
			offers = offersDAO.getOffers();
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
			context.close();
			return;
		}
		for (Offer o : offers)
			System.out.println(o);
		context.close();
	}
}