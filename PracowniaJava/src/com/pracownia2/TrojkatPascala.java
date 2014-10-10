package com.pracownia2;

public class TrojkatPascala {
	public static long czytaj(int p_wiersz, int p_kolumna) throws IllegalArgumentException
	{
		walidujArgumenty(p_wiersz, p_kolumna);
		return czyPodstawaRekursji(p_wiersz, p_kolumna) ? 
				1 : zwrocPascala(p_wiersz, p_kolumna);
	}
	
	private static void walidujArgumenty(int p_wiersz, int p_kolumna)  throws IllegalArgumentException
	{
		if (kolumnaJestWiekszaOdWiersza(p_wiersz, p_kolumna) || wartosciWychodzaPozaZakres(p_wiersz, p_kolumna))
		{
			throw new IllegalArgumentException("n powinno być większe od k!");
		}
	}

	private static long zwrocPascala(int p_wiersz, int p_kolumna)
	{
		return tablica[p_wiersz][p_kolumna];
	}
	
	private static void wypelnijTrojkatPascala()
	{
		for (int l_wiersz = 0; l_wiersz < c_max; ++l_wiersz)
		{
			stworzNowyWiersz(l_wiersz);
			wypelnijNowyWiersz(l_wiersz);
		}
	}

	private static void wypelnijNowyWiersz(int l_wiersz) 
	{
		for (int l_kolumna = 0; l_kolumna < l_wiersz+1; ++l_kolumna)
		{
			wpiszNowaWartoscWKolumne(l_wiersz, l_kolumna);
		}
	}

	private static void wpiszNowaWartoscWKolumne(int l_wiersz, int l_kolumna) 
	{
		if (czyPodstawaRekursji(l_wiersz, l_kolumna))
		{
			tablica[l_wiersz][l_kolumna] = 1;
		}
		else
		{
			tablica[l_wiersz][l_kolumna] = tablica[l_wiersz-1][l_kolumna-1] + tablica[l_wiersz-1][l_kolumna];
		}
	}
	
	private static void stworzNowyWiersz(int p_wiersz)
	{
		tablica[p_wiersz] = new long[p_wiersz+1];
	}
	
	private static Boolean czyPodstawaRekursji(int p_wiersz, int p_kolumna)
	{
		return p_kolumna == 0 || p_kolumna == p_wiersz;
	}
	
	private static boolean kolumnaJestWiekszaOdWiersza(int p_wiersz, int p_kolumna) 
	{
		return p_kolumna > p_wiersz;
	}
	
	private static boolean wartosciWychodzaPozaZakres(int p_wiersz, int p_kolumna)
	{
		return     p_kolumna >= c_max 
				|| p_wiersz  >= c_max 
				|| p_kolumna < 0 
				|| p_wiersz  < 0;
	}
	
	private final static int c_max   = 31;
	private static long[][]  tablica = new long[c_max][];
	
	static {
		wypelnijTrojkatPascala();
	}
}
