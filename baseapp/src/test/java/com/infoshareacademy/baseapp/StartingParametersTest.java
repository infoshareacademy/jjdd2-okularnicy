package com.infoshareacademy.baseapp;

import org.junit.Test;

import java.net.URL;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartingParametersTest {

    private final static String FILENAME = "/omegafuntest.lst";

    @Test
    public void isReadFoundIntoListIsCorrect() {

        URL url = this.getClass().getResource(FILENAME);
        String absolutePath = url.getPath();
        String[] tablica = {absolutePath};

        StartingParameters startingParameters = new StartingParameters();
        Map<String, String> resultMap = startingParameters.startingParametersIntoMap(tablica);

        assertThat(resultMap.size(), is(4));
        assertTrue(resultMap.containsKey("NOVO Akcji"));

    }
}

