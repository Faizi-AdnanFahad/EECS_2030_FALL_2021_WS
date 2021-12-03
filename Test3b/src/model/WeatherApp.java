package model;

public class WeatherApp {
	
	protected String name;
	
	protected WeatherStation[] arrayOfWeatherStation;
	protected int noW;
	
	public WeatherApp(String name, int maxWeatherStation) {
		this.name = name;
		this.arrayOfWeatherStation = new WeatherStation[maxWeatherStation];
	}
	
	protected void addWorkStation(WeatherStation w) {
		this.arrayOfWeatherStation[this.noW] = w;
		this.noW ++;
	}
	
	public String getAppName() {
		return this.name;
	}
	
	public String[] getConnectedForcastersOf(String stationName) {
		
		WeatherStation ws = null;
		for (int i = 0; i < this.noW; i ++) {
			if (this.arrayOfWeatherStation[i].getWorkStationName().equals(stationName)) {
				ws = this.arrayOfWeatherStation[i];
			}
		}
		
		String[] temp = null;
		int counter = 0;
		
		if (ws != null) {
			temp = new String[ws.getNoA()];
		}
		else {
			temp = new String[0];
		}
		
		if (ws != null && temp.length != 0) {
			for (int i = 0; i < ws.getNoA(); i ++) {
				if (ws.getArrayOfApps()[i] instanceof ForecastApp) {
					temp[counter] = ws.getArrayOfApps()[i].getAppName() + " at index " + i;
					counter ++;
				}
			}
		}
		
		
		String[] result = new String[counter];

		for (int i = 0; i < counter; i ++) {
			result[i] = temp[i];
		}
		return result;
	}
}
