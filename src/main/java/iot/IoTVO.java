package iot;

import java.sql.Date;

public class IoTVO {

	private int iot_code; 
	private float temperature, humidity;
	private String id, product_code, press, press_date, door_values, door_chk, door_date, temhum_date;
	
	
	public String getTemhum_date() {
		return temhum_date;
	}
	public void setTemhum_date(String temhum_date) {
		this.temhum_date = temhum_date;
	}
	public int getIot_code() {
		return iot_code;
	}
	public void setIot_code(int iot_code) {
		this.iot_code = iot_code;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPress_date() {
		return press_date;
	}
	public void setPress_date(String press_date) {
		this.press_date = press_date;
	}
	public String getDoor_values() {
		return door_values;
	}
	public void setDoor_values(String door_values) {
		this.door_values = door_values;
	}
	public String getDoor_chk() {
		return door_chk;
	}
	public void setDoor_chk(String door_chk) {
		this.door_chk = door_chk;
	}
	public String getDoor_date() {
		return door_date;
	}
	public void setDoor_date(String door_date) {
		this.door_date = door_date;
	}
	
	
	
}
