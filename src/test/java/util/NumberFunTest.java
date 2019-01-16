package util;

import org.junit.Assert;
import org.junit.Test;

class NumberFunTest {

    @Test
    public void happy1() {


        NumberFun.findNextSquare(44);

    }

    @Test
    public void notSR_expectSentinal() {

        Assert.assertEquals("expect sentinal",-1 , NumberFun.findNextSquare(44));


    }
}