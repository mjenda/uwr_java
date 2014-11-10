package tests.com.narzedzia;

import static org.junit.Assert.*;

import org.junit.Test;

import narzedzia.Para;

public class DrzewoBSTTest
{
	@Test
	public void getterZwracaWartosc()
	{
		double l_wartosc = 1.2;
		Para l_para = new Para("klucz", l_wartosc);
		assertEquals(l_wartosc, l_para.getWartosc(), 0.001);
	}
	
	
}