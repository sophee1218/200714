package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Execute
{
	public static void main(String[] args)
	{
		List<Person> pList = new ArrayList<>();
		pList.add(new Person("송희",22,43));
		pList.add(new Person("송송",12,33));
		pList.add(new Person("송이",62,44));
		Collections.sort(pList);
		System.out.print(pList);
	}
}
