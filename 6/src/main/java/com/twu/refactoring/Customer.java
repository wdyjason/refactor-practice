package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	private final double REGULAR_MOVIE_START_PRICE = 2;
	private final double REGULAR_MOVIE_RENT_RATE = 1.5;
	private final double NEW_RELEASE_MOVIE_RENT_RATE = 3;
	private final double CHILDRENS_MOVIE_START_PRICE = 1.5;
	private final double CHILDRENS_MOVIE_RENT_RATE = 1.5;

	private String name;
	private int frequentRenterPoints;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
		this.frequentRenterPoints = 0;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		StringBuilder result = new StringBuilder();

		result.append("Rental Record for " + getName() + "\n");

		totalAmount = calculateTotal(result);

		result.append( "Amount owed is " + String.valueOf(totalAmount) + "\n");
		result.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
		return result.toString();
	}

	public double calculateTotal(StringBuilder result) {
		double totalAmount = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			switch (each.getMovie().getPriceCode()) {
				case Movie.REGULAR:
					thisAmount += REGULAR_MOVIE_START_PRICE;
					if (each.getDaysRented() > 2)
						thisAmount += (each.getDaysRented() - 2) * REGULAR_MOVIE_RENT_RATE;
					break;
				case Movie.NEW_RELEASE:
					thisAmount += each.getDaysRented() * NEW_RELEASE_MOVIE_RENT_RATE;
					break;
				case Movie.CHILDRENS:
					thisAmount += CHILDRENS_MOVIE_START_PRICE;
					if (each.getDaysRented() > 3)
						thisAmount += (each.getDaysRented() - 3) * CHILDRENS_MOVIE_RENT_RATE;
					break;

			}

			frequentRenterPoints = addFrequentRenterPoints(each);

			result.append("\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n");
			totalAmount += thisAmount;

		}
		return totalAmount;
	}

	public int addFrequentRenterPoints(Rental rental) {
		frequentRenterPoints++;
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
}
