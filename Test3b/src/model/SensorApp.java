package model;

public class SensorApp extends WeatherApp {

	public SensorApp(String name, int maxWeatherStation) {
		super(name, maxWeatherStation);
	}

	public void updateMeasurements(String workStationName, int temprature, int airPressure) {
		WeatherStation matchedWeatherStation = null;
		for (int i = 0; i < this.noW; i ++) {
			if (this.arrayOfWeatherStation[i].getWorkStationName().equals(workStationName)) {
				matchedWeatherStation = this.arrayOfWeatherStation[i];
				break;
			}
		}
		
		for (int i = 0; i < matchedWeatherStation.getNoA(); i ++) {
			if (matchedWeatherStation.getArrayOfApps()[i] instanceof ForecastApp) {
				((ForecastApp) matchedWeatherStation.getArrayOfApps()[i]).addStat(workStationName, temprature, airPressure);
			}
		}
	}

	public String toString() {
		String result = "";

		String listOfWorkStation = "<";
		for (int i = 0; i < this.noW; i ++) {
			listOfWorkStation += this.arrayOfWeatherStation[i].getWorkStationName();
			if (i < this.noW - 1) {
				listOfWorkStation += ", ";
			}
		}
		listOfWorkStation += ">";

		if (this.noW == 0) {
			result = "Weather Sensor App " + this.name + " is connected to no stations.";
		}
		else {
			result = "Weather Sensor App " + this.name + " is connected to " + this.noW
					+ " stations: " + listOfWorkStation + ".";
		}

		return result;
	}


}
