package model;

import java.util.List;


public class PostGachaLogic {
	public void execute(Gacha gacha, List<Gacha> gachaList) {
		gachaList.add(0, gacha);
	}

}
