import greenfoot.*; 

public class FlappyBird extends Actor
{
    double dy=-5;
    double g=.35;
    double spasi = 1;
    double BOOST_SPEED =-3;
    int score =0;
    // penamabahan
    private double x = 1; 
    private int y = 300;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacross = false;
    private boolean hasaddscore = false; 
    private int imageNumber = 1; //Used for animating the bird's wings

    private GreenfootImage img1; //The initial image that is sequentially displayed for animation effect

    // private int score= 0;
    //Mengembalikan apabila spasi ditekan
    public FlappyBird()
    {
        img1 = new GreenfootImage(getImage()); 
        setImage(img1);
    }
    
    public void act() 
    {
        setLocation(getX(), (int)(getY() + dy) );
        // dibagian ini juga berpengaruh untuk kondisi suara saat menekan space atau arrow up
         if(spacePressed()){
            spasi=-2;//Semakin rendah angkanya, semakin tinggi terbangannya
        }

        // bagian pipa bawah
        if (getOneIntersectingObject(BottomPipe.class) !=null)
        {
            // jika terkena pipa bawah maka game over dan mengeluarkan suara dan game pun stop
            Greenfoot.playSound("peng.mp3");
            Greenfoot.playSound("Mario.mp3");
            GameOver over = new GameOver(); 
            getWorld().addObject(over, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
        // bagian pipa atas
        if(getOneIntersectingObject(TopPipe.class) != null) 
        {
            // jika terkena pipa atas maka game over dan mengeluarkan suara dan game pun stop
            Greenfoot.playSound("peng.mp3");
            Greenfoot.playSound("Mario.mp3");
            GameOver over = new GameOver();
            getWorld().addObject(new GameOver(), 300, 200);
            getWorld().addObject(over, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
        // bagian ground
        if (getOneIntersectingObject(Ground.class) !=null)
        {
            // jika terkena pipa bawah maka game over dan mengeluarkan suara dan game pun stop
            Greenfoot.playSound("peng.mp3");
            Greenfoot.playSound("Mario.mp3");
            GameOver over = new GameOver();
            getWorld().addObject(new GameOver(), 300, 200);
            getWorld().addObject(over, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
        // ketika menekan space 
        if(Greenfoot.isKeyDown("space")== true)
        {
            dy = BOOST_SPEED;
            animate();
        }
        
        // ketika menekan arrow up
        if (Greenfoot.isKeyDown("up") == true) {
            dy = BOOST_SPEED;
            animate();
        }
        dy = dy + g;

    }  

    
    // fungsi untuk animasi pada flappybird
     private void animate()
    {
        if(Greenfoot.getRandomNumber(3) == 0)
        {
            if(imageNumber == 3)
            {
                imageNumber = 1;
            }
            else {
                imageNumber++;
            }
            setImage("flappybird"+imageNumber+".png");
        }
    }   
    
   
    public boolean spacePressed(){
        boolean pressed = false;
        // ketika menekan space atau arrow up maka akan mengerluarkan suara
        if(Greenfoot.isKeyDown("space")|| Greenfoot.isKeyDown("up")){
            if(!haspressed){//Jika belum melepaskan spasi, jangan kembali true
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }

            haspressed = true; //spasi atau arrow up telah ditekan
        }else{
            haspressed = false; // ketika tidak spasi atau arrow up telah ditekan
        }
        return pressed;
    }
}