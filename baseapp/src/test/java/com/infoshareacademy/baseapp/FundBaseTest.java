package com.infoshareacademy.baseapp;

import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FundBaseTest {

    private final static String FILENAME = "/OPE033.txt";

    @Test
    public void isReadFoundIntoListIsCorrect() {

        URL url = this.getClass().getResource(FILENAME);
        String absolutePath = url.getPath();

        FundBase fundBase = new FundBase();
        ArrayList<Fund> result = fundBase.readFoundIntoList(absolutePath);

        assertThat(result.get(0).getClose(), is(100.00));
    }
}

