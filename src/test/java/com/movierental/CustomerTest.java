package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void statement_shouldReturn0Points0Amount(){

        //Given
        Customer customer = new Customer("");

        //When
        String statement = customer.statement();

        //Then
        assertEquals("Rental Record for \n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", statement);
    }


    @Test
    public void statement_shouldReturnStatement_RegularMovieRentedOneDay() {
        //Given
        Customer customer = new Customer("");
        customer.addRental(new Rental(new Movie("A",Movie.REGULAR),1));

        //When
        String statement = customer.statement();


        //Then
        assertEquals("Rental Record for \n" +
                "\tA\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void statement_shouldReturnStatement_RegularMovieRentedTwoDay() {
        //Given
        Customer customer = new Customer("");
        customer.addRental(new Rental(new Movie("A",Movie.REGULAR),3));

        //When
        String statement = customer.statement();


        //Then
        assertEquals("Rental Record for \n" +
                "\tA\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", statement);
    }


    @Test
    public void statement_shouldReturnStatement_NewReleaseMovieRentedOneDay() {
        //Given
        Customer customer = new Customer("");
        customer.addRental(new Rental(new Movie("A",Movie.NEW_RELEASE),1));

        //When
        String statement = customer.statement();


        //Then
        assertEquals("Rental Record for \n" +
                "\tA\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void statement_shouldReturnStatement_NewReleaseMovieRentedTwoDay() {
        //Given
        Customer customer = new Customer("");
        customer.addRental(new Rental(new Movie("A",Movie.NEW_RELEASE),2));

        //When
        String statement = customer.statement();


        //Then
        assertEquals("Rental Record for \n" +
                "\tA\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void statement_shouldReturnStatement_ChildrenMovieRentedOneDay() {
        //Given
        Customer customer = new Customer("");
        customer.addRental(new Rental(new Movie("A",Movie.CHILDRENS),1));

        //When
        String statement = customer.statement();


        //Then
        assertEquals("Rental Record for \n" +
                "\tA\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void statement_shouldReturnStatement_ChildrenMovieRentedFourDay() {
        //Given
        Customer customer = new Customer("");
        customer.addRental(new Rental(new Movie("A",Movie.CHILDRENS),4));

        //When
        String statement = customer.statement();


        //Then
        assertEquals("Rental Record for \n" +
                "\tA\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

}