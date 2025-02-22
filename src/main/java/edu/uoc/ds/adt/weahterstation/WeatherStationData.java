package edu.uoc.ds.adt.weahterstation;

import java.time.LocalDateTime;

public class WeatherStationData {
    private LocalDateTime lastUpdated;
    private String stationName;
    private String province;
    private double latitude;
    private double longitude;
    private double avgAirTemperature;
    private double precipitation;
    private double minAirTemperature;
    private double maxAirTemperature;

    public WeatherStationData(LocalDateTime lastUpdated, String stationName, String province,
                              double latitude, double longitude, double avgAirTemperature,
                              double precipitation, double minAirTemperature, double maxAirTemperature) {
        this.lastUpdated = lastUpdated;
        this.stationName = stationName;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;
        this.avgAirTemperature = avgAirTemperature;
        this.precipitation = precipitation;
        this.minAirTemperature = minAirTemperature;
        this.maxAirTemperature = maxAirTemperature;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public String getStationName() {
        return stationName;
    }

    public String getProvince() {
        return province;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAvgAirTemperature() {
        return avgAirTemperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public double getMinAirTemperature() {
        return minAirTemperature;
    }

    public double getMaxAirTemperature() {
        return maxAirTemperature;
    }
}