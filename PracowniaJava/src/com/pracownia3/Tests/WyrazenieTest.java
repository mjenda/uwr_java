package com.pracownia3.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pracownia3.Arctan;
import com.pracownia3.Cosinus;
import com.pracownia3.Dodaj;
import com.pracownia3.Dziel;
import com.pracownia3.Logarytm;
import com.pracownia3.Mnoz;
import com.pracownia3.Odejmij;
import com.pracownia3.Odwrotnosc;
import com.pracownia3.PrzeciwnyZnak;
import com.pracownia3.Sinus;
import com.pracownia3.Stala;
import com.pracownia3.WartBezwzgl;
import com.pracownia3.Zmienna;

public class WyrazenieTest {
	@Test
	public void StalaJestPoprawnieZwracana()
	{
		double l_wartosc = 1.2;
		Stala l_stala = new Stala(l_wartosc);
		assertEquals(l_wartosc, l_stala.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void ZmiennaJestPoprawnieZwracana()
	{
		String  l_idZmiennej1 = "ID1";
		String  l_idZmiennej2 = "ID2";
		double l_wartosc1 = 0.0;
		double l_wartosc2 = 1.2;
		Zmienna l_zmienna1 = new Zmienna(l_idZmiennej1);
		Zmienna l_zmienna2 = new Zmienna(l_idZmiennej2, 1.2);
		assertEquals(l_wartosc1, l_zmienna1.oblicz(), m_deltaDlaAsercji);
		assertEquals(l_wartosc2, l_zmienna2.oblicz(), m_deltaDlaAsercji);
		
	}
	
	@Test
	public void PoprawnieObliczanyJestMinusStalej()
	{
		double l_wartosc = 1.2;
		PrzeciwnyZnak l_minus = new PrzeciwnyZnak(new Stala(l_wartosc));
		assertEquals(-l_wartosc, l_minus.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanyJestMinusZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		PrzeciwnyZnak l_minus = new PrzeciwnyZnak(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(-l_wartosc, l_minus.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanaJestWartBezezglStalej()
	{
		double l_wartosc1 = -1.2;
		WartBezwzgl l_abs1 = new WartBezwzgl(new Stala(l_wartosc1));
		assertEquals(-l_wartosc1, l_abs1.oblicz(), m_deltaDlaAsercji);
		
		double l_wartosc2 = 1.2;
		WartBezwzgl l_abs2 = new WartBezwzgl(new Stala(l_wartosc2));
		assertEquals(l_wartosc2, l_abs2.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanyJestSinusZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Sinus l_sinus = new Sinus(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.sin(l_wartosc), l_sinus.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanyJestCosinusZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Cosinus l_cosinus = new Cosinus(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.cos(l_wartosc), l_cosinus.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanyJestArctanZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Arctan l_arctan = new Arctan(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.atan(l_wartosc), l_arctan.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanaJestOdwrotnoscZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Odwrotnosc l_odwr = new Odwrotnosc(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.pow(l_wartosc, -1), l_odwr.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanaJestWartBezwzglDlaZmiennej()
	{
		double l_wartosc     = -1.2;
		String  l_idZmiennej  = "ID";
		WartBezwzgl l_minus = new WartBezwzgl(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(-l_wartosc, l_minus.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanyJestLogarytmDlaZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Logarytm l_log = new Logarytm(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.log(l_wartosc), l_log.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanaJestSumaStalejIZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Dodaj l_dodaj = new Dodaj(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(l_wartosc + l_wartosc, l_dodaj.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanaJestRoznicaStalejIZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Odejmij l_odejmij = new Odejmij(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(l_wartosc - l_wartosc, l_odejmij.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanyJestIloczynStalejIZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Mnoz l_mnoz = new Mnoz(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(l_wartosc * l_wartosc, l_mnoz.oblicz(), m_deltaDlaAsercji);
	}
	
	@Test
	public void PoprawnieObliczanyJestIlorazStalejIZmiennej()
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Dziel l_dziel = new Dziel(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(l_wartosc / l_wartosc, l_dziel.oblicz(), m_deltaDlaAsercji);
	}

	private final double m_deltaDlaAsercji = 0.001;

}
