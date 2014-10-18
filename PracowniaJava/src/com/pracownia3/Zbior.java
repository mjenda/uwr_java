package com.pracownia3;

public class Zbior {
	public Zbior()
	{
		m_pojemnoscZbioru = 200;
		m_iloscElem       = 0;
		m_pary            = new Para[m_pojemnoscZbioru];
	}
	
	public void wstaw(String  p_klucz, double p_wartosc)
	{
		m_pary[m_iloscElem++] = new Para(p_klucz, p_wartosc);
	}

	public double czytaj(String p_klucz)  throws IllegalArgumentException
	{
		return szukajWartosci(p_klucz);
	}
	
	public void usun(int p_ileElemZostawic)
	{	
		if (p_ileElemZostawic < 0 || p_ileElemZostawic > ile())
		{
			throw new IllegalArgumentException("Nie mozna usunac!");
		}
		
		m_iloscElem = p_ileElemZostawic;
	}
	
	public void usun()  throws IllegalArgumentException
	{	
		usun(ile()-1);
	}
	
	public int ile()  throws IllegalArgumentException
	{
		return m_iloscElem;
	}
	
	
	
	
	
	private double szukajWartosci(String p_klucz) throws IllegalArgumentException
	{
		for (int l_numerPary = 0; l_numerPary < m_iloscElem; ++l_numerPary)
		{
			if (m_pary[l_numerPary].m_klucz == p_klucz)
				return m_pary[l_numerPary].getWartosc();
		}
		
		throw new IllegalArgumentException("Klucz " + p_klucz + " nie istnieje!");
	}
	
	private Para[] m_pary;
	private int m_pojemnoscZbioru;
	private int m_iloscElem;
}