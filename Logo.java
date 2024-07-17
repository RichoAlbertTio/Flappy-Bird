import greenfoot.*;  


public class Logo extends Actor
{
    public void act()
    {
        // ketika run dengan menekan space atau arrow up maka logo hilang 
        if (Greenfoot.isKeyDown("up")||Greenfoot.mouseClicked(null)||Greenfoot.isKeyDown("space")) {
            Greenfoot.playSound("My Audio.mp3");
            World world;
            world = getWorld();
            world.removeObject(this);
    }
}
}

