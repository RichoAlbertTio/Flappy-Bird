import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Game Flappy Bird.
 * 
 *  Nama      : Richo Albert Tio
 *  Nim       : 203030503099
 *  Praktikum : Pemprograman Berorientasi Objek(PBO)
 *  Tugas     : Modul II
 */
public class MyWorld extends World
{   
    // Mendeklarasikan variabel  penambahan pipe, fappy bird, space, score, first pipe, random lokasi, dan counter 
    int pipeCounter= 100;
    int flappyCounter = 0;
    int SPACE_BETWEEN_PIPES = 0;
    int score = 0;
    int FIRST_PIPE = 240;
    int randomLoc;
    int counter =0;

    Score scoreObj = null;

    
   //Constructor for objects of class MyWorld. 
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // Setting ukuran background 
        super(600, 400, 1, false);
        // tambahan win class, LScore.class, Win.class, GameOver.class, Score.class, FlappyBird.class, TopPipe.class
        setPaintOrder(LScore.class, Win.class, GameOver.class, Score.class, FlappyBird.class, TopPipe.class);
        // menambahkan objek pada layar Logo, Flappy Bird, Ground dan Score
        Logo logoObject = new Logo();
        addObject (logoObject, getWidth()/2, getHeight()*1/3);
        // Objek Flappy Bird
        FlappyBird flappy = new FlappyBird();
        addObject(flappy, 100, 200);
        // Objek Ground 
        Ground ground = new Ground();
        addObject(ground, 300, 400);
        // fungsi Score
        scoreObj = new Score();
        scoreObj.setScore(0);
        // Objek Ground 
        addObject(scoreObj,60,50);

        prepare();
    }

    private void createPipes()
    {
        // if(pipeCounter==100)
        BottomPipe bottompipe = new BottomPipe();
        randomLoc = Greenfoot.getRandomNumber(200)-100;

        addObject(bottompipe, getWidth(), getHeight() + SPACE_BETWEEN_PIPES /2 + randomLoc);

        TopPipe toppipe = new TopPipe();
        addObject(toppipe, getWidth(), 0 - SPACE_BETWEEN_PIPES /2 + randomLoc);
        //pipeCounter=0;
        pipeCounter++;
        flappyCounter++;
    }

    public void act()
    {
        //pipeCounter=100;
        pipeCounter++;
        if(pipeCounter % 100 == 0)
        {
            createPipes();
        }
        // PipeCounter
        if(pipeCounter >= FIRST_PIPE)
        {
            if(flappyCounter % 100 == 0)
            {
                // ketika melewati pipe dia akan bertambah 1 score dan terdengar suara
                Greenfoot.playSound("score.mp3");
                score++;
                scoreObj.setScore(score);        
            }
            flappyCounter++;
        }
        // isntruksi menang
        if (score ==2){
            Greenfoot.playSound("you win.mp3");
            removeObjects(getObjects(null));
            Win win = new Win();
            addObject(new Win(), 300, 200);
            LScore score = new LScore();
            addObject(new LScore(), 300, 80);
            addObject(scoreObj, 300,150);
            Greenfoot.stop();
        }
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground = new Ground();
        addObject(ground,311,372);
        ground.setLocation(428,367);
        ground.setLocation(113,369);
        ground.setLocation(361,363);
        ground.setLocation(542,391);
        ground.setLocation(509,377);
        ground.setLocation(103,371);
        removeObject(ground);
    }
}
