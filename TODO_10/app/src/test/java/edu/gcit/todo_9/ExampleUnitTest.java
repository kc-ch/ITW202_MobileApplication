package edu.gcit.todo_9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

//running the JUnit4 class
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    private Calculator mCalculator; //creating an object for Calculator class

    @Before
    public void setUp(){
        mCalculator = new Calculator();
    }
    @Test
    //function for checking the addition function
    public void checkAdd() {
        double resultAdd = mCalculator.addition(2d, 5d);
        assertThat(resultAdd, is(equalTo(7d)));
    }
    @Test
    //function for checking the addition function if the negative no. is present
    public void checkAddForNeg() {
        double resultAdd = mCalculator.addition(-2d, 5d);
        assertThat(resultAdd, is(equalTo(3d)));
    }
    @Test
    public void checkAddForFloat() {
        double resultAdd = mCalculator.addition(1.11f, 1.11d);
        assertThat(resultAdd, is(closeTo(2.22,0.01)));
    }

    @Test
    public void SubTwoNumbers() {
        double resultSub = mCalculator.subtraction(5d, 3d);
        assertThat(resultSub, is(equalTo(2d)));
    }
    @Test
    public void subWorksWithNegativeResults() {
        double resultSub = mCalculator.addition(-2d, 5d);
        assertThat(resultSub, is(equalTo(7d)));
    }
    @Test
    public void checkSubForFloat() {
        double resultAdd = mCalculator.addition(2.22f, 1.11d);
        assertThat(resultAdd, is(closeTo(1.22, 0.01)));
    }

    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.multiplication(5d, 3d);
        assertThat(resultMul, is(equalTo(15d)));
    }
    @Test
    public void  mulTwoNumbersZero() {
        double resultMul = mCalculator.multiplication(0d, 3d);
        assertThat(resultMul, is(equalTo(0d)));
    }
    @Test
    public void  divTwoNumbers() {
        double resultMul = mCalculator.division(15d, 3d);
        assertThat(resultMul, is(equalTo(5d)));
    }
    @Test
    public void divTwoNumbersZero() {
        double resultMul = mCalculator.division(15d, 0d);
        assertThat(resultMul, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}