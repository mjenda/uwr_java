package Threads;

import Entity.Child;
import Santa.Game;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ChildThread implements Runnable
{
    public ChildThread(Child p_child)
    {
        m_child = p_child;
        Random l_random = new Random();
        
        m_waitTimeInMs = 500 + l_random.nextInt(1500);
        m_bedTimeInMs = 2000 + l_random.nextInt(1000);
    }
    
    @Override
    public void run()
    {
        
        while(m_child.isChildSeekingForPresents())
        {   
            boolean l_bed = false;
            synchronized(m_child.m_board)
            {
                switch(selectBehavior())
                {
                    case 0:
                        m_child.moveUp();
                        break;
                    case 1:
                        m_child.moveRight();
                        break;
                    case 2:
                        m_child.moveDown();
                        break;
                    case 3:
                        m_child.moveLeft();
                        break;
                    case 4:
                        m_child.napTime();
                        l_bed = true;
                }
            }
            if(l_bed)
                waitInMilisec(m_bedTimeInMs);
            if(m_child.isChildSleeping())
            {
                m_child.wakeUp();
            }
            else
            {
                waitInMilisec(m_waitTimeInMs);
            }
        }
    }
    private int selectBehavior()
    {
        
        Random l_random = new Random();
        int l_behavior = l_random.nextInt(50);

        if(m_child.isSantaInRadius() && l_behavior < 40)
        {
            return m_child.moveTowardSanta();
        }
        
        if(l_behavior < 10)
            return 0;
        else if(l_behavior < 20)
            return 1;
        else if(l_behavior < 30)
            return 2;
        else if(l_behavior < 40)
            return 3;
        else
            return 4;
    }
    
    private void waitInMilisec(int p_milisec)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(p_milisec);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Game.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    private Child m_child;
    private final int m_waitTimeInMs;
    private final int m_bedTimeInMs;
}
