package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {

    String result = getString();

    result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
    result += "You earned " + String.valueOf(getFrequentRenterPoints())
        + " frequent renter points";
    return result;
  }


  private int getFrequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental each : rentals) {
      frequentRenterPoints += each.getFrequentRenterPoints();
    }
    return frequentRenterPoints;
  }


  private String getString() {
    String result = "Rental Record for " + getName() + "\n";
    for (Rental each : rentals) {
      result += each.getLineItem();
    }
    return result;
  }


  private double getTotalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.getTotalAmount();
    }
    return totalAmount;
  }


}

