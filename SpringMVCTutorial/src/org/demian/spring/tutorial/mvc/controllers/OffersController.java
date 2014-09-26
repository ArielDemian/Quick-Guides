package org.demian.spring.tutorial.mvc.controllers;

import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import org.demian.spring.tutorial.mvc.dao.Offer;
import org.demian.spring.tutorial.mvc.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OffersController {
	private OffersService offersService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Model model) {
		return "index";
	}

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping(value = "/offers", method = RequestMethod.GET)
	public String showOffers(Model model) {
		List<Offer> offers = offersService.getCurrentOffers();
		model.addAttribute("offers", offers);
		return "offers";
	}

	@RequestMapping(value = "/create_offer", method = RequestMethod.GET)
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createOffer";
	}

	@RequestMapping(value = "/do_create", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errorMessages = new LinkedList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorMessages.add(error.getDefaultMessage());
			}
			model.addAttribute("errors", errorMessages);
			return "createOffer";
		}
		System.out.println(offer);
		if (offersService.createOffer(offer)) {
			return "do_create";
		} else {
			List<String> errorMessages = new LinkedList<String>();
			errorMessages.add("Could not insert offer object into the database.");
			return "createOffer";
		}
	}
}