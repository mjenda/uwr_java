package com.pracownia2;

public class TrojkatPascala {
	public static long czytaj(int p_numerWiersza, int p_numerKolumny) throws IllegalArgumentException
	{
		walidujArgumenty(p_numerWiersza, p_numerKolumny);
		return czyPodstawaRekursji(p_numerWiersza, p_numerKolumny) ? 
				1 : zwrocPascala(p_numerWiersza, p_numerKolumny);
	}
	
	private static void walidujArgumenty(int p_numerWiersza, int p_numerKolumny)  throws IllegalArgumentException
	{
		if (kolumnaJestWiekszaOdWiersza(p_numerWiersza, p_numerKolumny) || wartosciWychodzaPozaZakres(p_numerWiersza, p_numerKolumny))
		{
			throw new IllegalArgumentException("n powinno być większe od k!");
		}
	}

	private static long zwrocPascala(int p_numerWiersza, int p_numerKolumny)
	{
		return tablica[p_numerWiersza][p_numerKolumny];
	}
	
	private static void wypelnijTrojkatPascala()
	{
		for (int l_numerWiersza = 0; l_numerWiersza < c_max; ++l_numerWiersza)
		{
		    stworzNowyWiersz(l_numerWiersza);
			wypelnijNowyWiersz(l_numerWiersza);
		}
	}

	private static void wypelnijNowyWiersz(int p_numerWiersza) 
	{
		for (int p_numerKolumny = 0; p_numerKolumny < p_numerWiersza+1; ++p_numerKolumny)
		{
			wpiszNowaWartoscWKolumne(p_numerWiersza, p_numerKolumny);
		}
	}

	private static void wpiszNowaWartoscWKolumne(int p_numerWiersza, int p_numerKolumny) 
	{
		if (czyPodstawaRekursji(p_numerWiersza, p_numerKolumny))
		{
			tablica[p_numerWiersza][p_numerKolumny] = 1;
		}
		else
		{
			tablica[p_numerWiersza][p_numerKolumny] = 
					tablica[p_numerWiersza-1][p_numerKolumny-1] +
					tablica[p_numerWiersza-1][p_numerKolumny  ];
		}
	}
	
	private static void stworzNowyWiersz(int p_numerWiersza)
	{
		tablica[p_numerWiersza] = new long[p_numerWiersza+1];
	}
	
	private static Boolean czyPodstawaRekursji(int p_numerWiersza, int p_numerKolumny)
	{
		return p_numerKolumny == 0 || p_numerKolumny == p_numerWiersza;
	}
	
	private static boolean kolumnaJestWiekszaOdWiersza(int p_numerWiersza, int p_numerKolumny) 
	{
		return p_numerKolumny > p_numerWiersza;
	}
	
	private static boolean wartosciWychodzaPozaZakres(int p_numerWiersza, int p_numerKolumny)
	{
		return     p_numerKolumny >= c_max 
				|| p_numerWiersza  >= c_max 
				|| p_numerKolumny < 0 
				|| p_numerWiersza  < 0;
	}
	
	public final static int c_max   = 31;
	private static long[][]  tablica = new long[c_max][];
	
	static {
		wypelnijTrojkatPascala();
	}
}
