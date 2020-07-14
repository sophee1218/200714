package test;

import org.apache.commons.lang.StringUtils;

public class StringUtilTest
{

	public static void main(String[] args)
	{
		String str = "1";
		str = StringUtils.leftPad(str, 3, "0");
		System.out.println(str);
	}

}
