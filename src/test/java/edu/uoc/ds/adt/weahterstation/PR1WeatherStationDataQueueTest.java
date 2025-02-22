package edu.uoc.ds.adt.weahterstation;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

public class PR1WeatherStationDataQueueTest {

    private static final int SIZE = 3;
    private PR1WeatherStationDataQueue pr1q;

    @Before
    public void setUp() {
        this.pr1q = new PR1WeatherStationDataQueue();
        assertNotNull(this.pr1q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr1q = null;
    }


    @org.junit.Test
    public void queueTest() {
        Assert.assertEquals(SIZE, this.pr1q.getQueue().size());

        WeatherStationData weatherData1 = this.pr1q.getQueue().poll();
        Assert.assertEquals("MANRESA", weatherData1.getStationName());
        Assert.assertEquals(0, weatherData1.getPrecipitation(), 0);
        Assert.assertEquals(18.4, weatherData1.getAvgAirTemperature(), 0);

        WeatherStationData weatherData2 = this.pr1q.getQueue().poll();
        Assert.assertEquals("MANRESA", weatherData2.getStationName());
        Assert.assertEquals(0, weatherData2.getPrecipitation(), 0);
        Assert.assertEquals(17.0, weatherData2.getAvgAirTemperature(), 0);

        Assert.assertEquals(1, pr1q.getMeanPrecipitation(), 0);
        Assert.assertEquals(15.0, pr1q.getMeanAvgAirTemperature(), 0);
    }

    private void fillQueue() {
        CSVParser csvParser = CSVReader.getCSVParser("weatherData.csv");
        for (CSVRecord record: csvParser) {
            WeatherStationData weatherData = new WeatherStationData(
                    DateUtils.getLocalDateTime(record.get("lastUpdated")),
                    record.get("weatherStation.name"),
                    record.get("weatherStation.province"),
                    Double.parseDouble(record.get("weatherStation.location.coordinates.0")),
                    Double.parseDouble(record.get("weatherStation.location.coordinates.1")),
                    Double.parseDouble(record.get("avgAirTemperature")),
                    Double.parseDouble(record.get("precipitation")),
                    Double.parseDouble(record.get("minAirTemperature")),
                    Double.parseDouble (record.get("maxAirTemperature"))
            );
            pr1q.add(weatherData);
        }
    }

    private static class CSVReader {
        static CSVParser getCSVParser(String fileName) {
            try {
                InputStream inputStream = CSVReader.class.getClassLoader().getResourceAsStream(fileName);
                return new CSVParser(new InputStreamReader(inputStream), CSVFormat.DEFAULT.withFirstRecordAsHeader());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private static class DateUtils {
        public static LocalDateTime getLocalDateTime(String date) {
            return LocalDateTime.parse(date);
        }
    }
}