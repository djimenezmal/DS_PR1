package edu.uoc.ds.adt.weahterstation;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.traversal.Iterator;

import java.util.function.Function;

public class PR1WeatherStationDataQueue {
    public static final int CAPACITY = 10;
    private Queue<WeatherStationData> queue = new QueueArrayImpl<>(CAPACITY);

    public Queue<WeatherStationData> getQueue() {
        return this.queue;
    }

    public void add(WeatherStationData data) {
        this.queue.add(data);
    }

    public WeatherStationData poll() {
        return this.queue.poll();
    }

    public double getMeanPrecipitation() {
        return calculateMean(WeatherStationData::getPrecipitation);
    }

    public double getMeanAvgAirTemperature() {
        return calculateMean(WeatherStationData::getAvgAirTemperature);
    }

    private double calculateMean(Function<WeatherStationData, Double> function) {
        double mean = 0;
        Iterator<WeatherStationData> iterator = queue.values();
        while (iterator.hasNext()) {
            Double value = function.apply(iterator.next());
            mean += value;
        }

        return mean / queue.size();
    }
}