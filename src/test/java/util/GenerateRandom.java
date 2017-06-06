package util;

import java.util.Random;

public class GenerateRandom {
public static Double GenRandom(){
	 double min=2.60;
	 double max=5.00;
	 Random r = new Random();
	    double rand=( (r.nextInt((int)((max-min)*100+1))+min*100) / 100.00);
	    String value=Double.toString(rand);
	    return rand;
}
}
