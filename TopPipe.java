import greenfoot.*; 

public class TopPipe extends Actor
{
    int PIPE_SPEED = -4;
    public void act() 
    {

        setLocation(getX() + PIPE_SPEED, getY());  

    }    
}

