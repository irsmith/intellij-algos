package util;

import fizzbuzzEtc.FindNextSquare;
import org.junit.Assert;
import org.junit.Test;

class NumberFunTest {

    @Test
    public void happy1() {


        FindNextSquare.findNextSquare(44);

    }

    @Test
    public void notSR_expectSentinal() {

        Assert.assertEquals("expect sentinal",-1 , FindNextSquare.findNextSquare(44));


    }
}