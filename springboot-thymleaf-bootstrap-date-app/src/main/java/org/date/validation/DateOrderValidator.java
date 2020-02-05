package org.date.validation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.date.service.DateService;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class DateOrderValidator implements ConstraintValidator<DateOrderCheck, Object> {

	@Autowired
	private DateService dateService;

	private String startDate;
	private String endDate;

	@Override
	public void initialize(DateOrderCheck constraint) {
		this.startDate = constraint.startDateField();
		this.endDate = constraint.endDateField();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Date startDate = (Date) new BeanWrapperImpl(value).getPropertyValue(this.startDate);
		Date endDate = (Date) new BeanWrapperImpl(value).getPropertyValue(this.endDate);
		if (startDate == null || endDate == null) {
			return true; // Let the other validator handle this
		}
		long noOfDays = dateService.calculateTwoDateDifference(startDate, endDate);
		return (noOfDays >= 0);
	}
}
