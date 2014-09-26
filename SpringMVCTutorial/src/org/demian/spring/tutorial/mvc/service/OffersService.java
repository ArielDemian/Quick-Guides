package org.demian.spring.tutorial.mvc.service;

import java.util.List;
import org.demian.spring.tutorial.mvc.dao.Offer;
import org.demian.spring.tutorial.mvc.dao.OffersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
public class OffersService {
	private OffersDAO offersDAO;

	public OffersService() {
		System.out.println("OffersService has been created!");
	}

	public List<Offer> getCurrentOffers() {
		return offersDAO.getOffers();
	}

	public boolean createOffer(String name, String email, String text) {
		return offersDAO.insert(new Offer(name, email, text));
	}

	public boolean createOffer(Offer offer) {
		return offersDAO.insert(offer);
	}

	@Autowired
	@Required
	public void setOffersDAO(OffersDAO offersDAO) {
		this.offersDAO = offersDAO;
	}
}