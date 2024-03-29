package com.pracownia2;


import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TrojkatPascalaTest {
	
	int m_wiersz = 0;
	final int m_pierwszaKolumna = 0;
	
	@Test
	public void zwracaJedenDlaPierwszegoWiersza()
	{
		m_wiersz = 0;
		assertEquals(1, TrojkatPascala.czytaj(m_wiersz,0));
		
	}
	
	@Test
	public void zwracaJedenDlaDrugiegoWiersza()
	{
		m_wiersz = 1;
		for(int l_kolumna = m_pierwszaKolumna; l_kolumna < m_wiersz+1; ++l_kolumna)
		{
			assertEquals(1, TrojkatPascala.czytaj(m_wiersz, l_kolumna));
		}
	}
	
	@Test
	public void zwracaWartosciDlaTrzeciegoWiersza()
	{
		m_wiersz = 2;
		for(int l_kolumna = m_pierwszaKolumna; l_kolumna < m_wiersz+1; ++l_kolumna)
		{
			if(l_kolumna == 1)
			{
				assertEquals(2, TrojkatPascala.czytaj(m_wiersz, l_kolumna));
			}
			else
			{
				assertEquals(1, TrojkatPascala.czytaj(m_wiersz, l_kolumna));
			}
		}
	}
	
	@Test
	public void zwracaJedenDlaPodstawyRekursji()
	{
		assertEquals(1, TrojkatPascala.czytaj(30, 0));
		assertEquals(1, TrojkatPascala.czytaj(30, 30));
	}
	
	@Test
	public void zwracaRoznePoprawneWartosci()
	{
		assertEquals(155117520, TrojkatPascala.czytaj(30, 15));
		assertEquals(480700, TrojkatPascala.czytaj(25, 18));
		assertEquals(45, TrojkatPascala.czytaj(10, 2));
		assertEquals(1, TrojkatPascala.czytaj(17, 17));
		assertEquals(37442160, TrojkatPascala.czytaj(28, 13));
		assertEquals(30, TrojkatPascala.czytaj(30, 1));
		assertEquals(10, TrojkatPascala.czytaj(5, 2));
		assertEquals(21474180, TrojkatPascala.czytaj(28, 11));
		assertEquals(12, TrojkatPascala.czytaj(12, 11));
		
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void rzucaWyjatkiemGdyKolumnaWiekszaOdWiersza()
	{
		exception.expect( IllegalArgumentException.class );
		TrojkatPascala.czytaj(20, 21);
	}
}
