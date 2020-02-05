package org.date.controller;

import javax.validation.Valid;

import org.date.model.Dates;
import org.date.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DateController {
	private static final String VIEW_DATE = "dates";
	private static final String VIEW_NO_OF_DAYS = "noofdays";

	@Autowired
	private DateService dateService;

	@GetMapping("/")
	public String redirectToDates(Dates dates) {
		return "redirect:/" + VIEW_DATE;
	}

	@GetMapping("/dates")
	public String showDatesForm(Dates dates) {
		return VIEW_DATE;
	}

	@PostMapping("/noofdays")
	public String calculateNoOfDays(@Valid Dates dates, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return VIEW_DATE;
		}
		long noOfDays = dateService.calculateTwoDateDifference(dates.getStartDate(), dates.getEndDate());
		model.addAttribute("noOfDays", noOfDays);
		return VIEW_NO_OF_DAYS;
	}
}
