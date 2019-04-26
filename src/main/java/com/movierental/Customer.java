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

    String result = "Rental Record for " + getName() + "\n";

    for (Rental each : rentals) {
      result += each.getLineItem();
    }

    result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
    result += "You earned " + String.valueOf(getFrequentRenterPoints())
        + " frequent renter points";
    return result;
  }



  public String htmlStatement() {

    String result = "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>";

    for (Rental each : rentals) {
      result += each.getLineItem();
    }

    result += "Amount owed is <b>" + String.valueOf(getTotalAmount()) + "</b><br/>";
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



  private double getTotalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.getTotalAmount();
    }
    return totalAmount;
  }


}

