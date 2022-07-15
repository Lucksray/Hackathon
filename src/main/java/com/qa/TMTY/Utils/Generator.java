package com.qa.TMTY.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

	public Long packageIdGen() {
		List<Long> x = new ArrayList<>();
		int count = 0;
		String incato = "";

		do {
			Long y = new Random().nextLong(12);
			x.add(y);
			count++;
		}while (count < 6);

		for (Long num : x) {
			incato += num + "";

		}
		Long f = Long.parseLong(incato);

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
