package com.qa.TMTY.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
	
	public Long packageIdGen() {
		List<Long> x = new ArrayList<>();
		int count = 0;
		
		do {
			Long y = new Random().nextLong(12);
			x.add(y);
			count++;
		}while (count < 6);
		
		Long f = x.get(0) + x.get(1) + x.get(2) + x.get(3) + x.get(4) + x.get(5);
		
		return f;
	}
	
	public String assignerGen() {
		String[] nameList = {"Greag","Geoffray","Harriot","Bedroff","Constablew","Dellerwow"};
		int x = new Random().nextInt(nameList.length);
		return nameList[x];
	}
	
	public String driverGen() {
		String[] nameList = {"Hophman","Peonit","Shwowman","Cantact","Williamlow","Herfrey"};
		int x = new Random().nextInt(nameList.length);
		return nameList[x];
	}

}
