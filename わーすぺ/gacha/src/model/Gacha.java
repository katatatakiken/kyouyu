package model;
import java.io.Serializable;

public class Gacha implements Serializable {

	private String userName;
	private String gacha;
	public Gacha() {}
	public Gacha(String userName, String gacha) {
		this.userName = userName;
		this.gacha = gacha;
	}
	public String getUserName(){return userName;}
	public String getGacha(){return gacha; }
}
