package sk.paz1a.practicals.Hra15;

import java.time.LocalTime;
import java.util.Date;

public class Cas {
	// tato metoda spocita kolko hral pouzivatel
	public static int spocitajCasHry() {
		int hodiny = 0;
		int minuty = 0;
		int sekundy = 0;
		//date
		Date d = new Date();
		hodiny = LocalTime.now().getHour();
	//	System.out.println(hodiny);
		minuty = LocalTime.now().getMinute();
	//	System.out.println(minuty);
		sekundy = LocalTime.now().getSecond();
		//System.out.println(sekundy);
		return hodiny * 3600 + minuty * 60 + sekundy;
	}
}
