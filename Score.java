import greenfoot.*;  
//import java.awt.Color; 
 import greenfoot.Color;
 //import java.awt.Font;
 import greenfoot.Font;

public class Score extends Actor
{
    public Score()
    {
        GreenfootImage newImage = new GreenfootImage(100, 50);
        setImage(newImage);
    }

    public void setScore(int score)
    {
        GreenfootImage newImage =getImage();
        newImage.clear();
        
        Font f = new Font("Comic sans MS", 32);
        newImage.setFont(f);
        
        Color c = new Color(0,0,0,0);
        newImage.setColor(c);
        newImage.fill();
        newImage.setColor(Color.WHITE);
        newImage.drawString("" + score, 40, 35);
        setImage(newImage);
            
    }
    
     public void act() 
    {
        
    }    
}
