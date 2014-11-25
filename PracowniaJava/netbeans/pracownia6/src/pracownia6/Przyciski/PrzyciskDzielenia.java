package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskDzielenia implements IPrzyciskDzialaniaBinarnego
{
    public PrzyciskDzielenia(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument)
    {
        return p_lewyArgument.divide(p_prawyArgument);
    }

    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoDzialanieBinarne(this);
    }
    
    @Override
    public String toString()
    {
        return "/";
    }
    
    private Processor m_processor = null;
}