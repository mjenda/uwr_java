package narzedzia;

public class Para implements Cloneable, Comparable<Para> 
{
	public Para(String p_klucz, double p_wartosc) throws IllegalArgumentException
	{
		if(!argumentyKonstrukcjiSaPoprawne(p_klucz, p_wartosc))
		{
			throw new IllegalArgumentException("Błędne argumenty konstruktora!");
		}
		
		m_klucz   = p_klucz;
		m_wartosc = p_wartosc;
	}
	
	public double getWartosc() {
		return m_wartosc;
	}

	public void setWartosc(double p_wartosc) {
		m_wartosc = p_wartosc;
	}
	
	@Override
	public String toString()
	{
		final char   c_inversedExclamationMark = '\u00A1';
		final char   c_inversedQuestionMark    = '\u00BF';
		final String c_separator               = ": ";
		return  c_inversedExclamationMark 
				+ m_klucz 
				+ c_separator 
				+ String.valueOf(getWartosc()) 
				+ c_inversedQuestionMark;
	}
	
	@Override
	public boolean equals(Object p_para)
	{
		if (p_para == null)            return false;
		if (p_para == this)            return true;
		if (!(p_para instanceof Para)) return false;
		
		return this.m_klucz == ((Para)p_para).m_klucz;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return (Para) super.clone();
	}
	
	@Override
	public int compareTo(Para p_para)
	{
		if (p_para == this) return 0;
		
		return m_klucz.compareTo(p_para.m_klucz);
	}
	
	private boolean argumentyKonstrukcjiSaPoprawne(String p_klucz, double p_wartosc)
	{

		if (p_wartosc <= 0 || !Character.isJavaIdentifierStart(p_klucz.charAt(0)))
		{
			return false;
		}
		return true;
	}
	
	public final String m_klucz;
	private double      m_wartosc;


}
