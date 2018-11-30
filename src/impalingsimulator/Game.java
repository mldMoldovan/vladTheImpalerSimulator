



package impalingsimulator;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;






public class Game extends Canvas implements Runnable{
    public static Color WhiteCP = new Color(0,0,0);
    public static Color BrownCP = new Color(102,51,0);
    public static Color GreenColor = new Color(0,153,0);
    public static Color PurpleColor = new Color(102,0,204);
    public static Color BloodColor = new Color(153,0,0);
    public static Color DarkRed = new Color(204,0,0);
    public static Color OldColor = new Color(51,51,0);
    public static Color RoyalBlue = new Color(0,102,204);
    public static Color DarkOrange = new Color(153,76,0);
    public static Color RoyalOrange = new Color(204,102,0);
    public static Color BrownCP_Dark = new Color(81,46,11);
    
    public static Color WallDown = new Color(255,178,102);
    public static Color WallUp = new Color(153,76,0);
    public static Color SkyBlue = new Color(51,153,255);
    public static Color ArmyBlue = new Color(0,76,153);
    
    public static Color WhiteSkinColor = new Color(255,204,153);
    public static Color ArabSkinColor = new Color(145,98,44);
    public static Color BlackSkinColor = new Color(51,25,0);
    
   
    
    
    public static Font LogoFont  = new Font("calibri",1,60);
    
    public static Font Cal50  = new Font("calibri",1,50);
    public static Font Cal45  = new Font("calibri",1,45);
    public static Font Cal40  = new Font("calibri",1,40);
    public static Font Cal35  = new Font("calibri",1,35);
    public static Font Cal30  = new Font("calibri",1,30);
    public static Font Cal25  = new Font("calibri",1,25);
    public static Font Cal20  = new Font("calibri",1,20);
    
    public static Font Roman30 = new Font("roman",1,30);
    public static Font Roman25 = new Font("roman",1,25);
    public static Font Roman20 = new Font("roman",1,20);
    
    public static Font SmallLogoFont  = new Font("calibri",1,20);
    public static Font ScoreFont  = new Font("calibri",1,30);
    public static Font MenuFont = new Font("roman",1,30);
    public static Font CopyrightFont = new Font("calibri",1,20);
    
    
    public static BufferedImage logoImage;
    public static BufferedImage logoImage1280;
    public static BufferedImage logoImage1366;
    public static BufferedImage logoImage1680;
    public static BufferedImage logoImage1920;
    
    public static BufferedImage coinImage;
    public static BufferedImage soundImage;
    
    public static BufferedImage tepesImage;
    public static BufferedImage tepesImage2;
    public static BufferedImage tepesImage3;
    public static BufferedImage tepesImage4;
    public static BufferedImage tepesImage5;
    
    public static BufferedImage tepesBackground;
    public static BufferedImage tepesBackground2;
    public static BufferedImage tepesBackground3;
    public static BufferedImage tepesBackground4;
    public static BufferedImage tepesBackground5;
    
    
    
    public static boolean onSomething = false;
    public static boolean firstLaunch = false;
    public static boolean playerStart = false;
    public static boolean cinematicDone = false;
    public static boolean halfCinematic=false;
    
    
    //SOUND BOOLEANS
    public static boolean masterAudio=false;
    public static boolean masterSFX=false;
    public static boolean masterMusic=false;
    
    public static boolean cinematicEnabled=true;
    
    public static boolean customOutfit = true;
    
    
    //POWER UPS BOOLEANS
    public static boolean doubleCoins=false;
    public static boolean noClouds=false;
    public static boolean phantomMode=false;
    public static boolean partsRebuild=false;
    
    //POWER UPS TIMERS
    private int coinsTimer=1000;
    private int cloudsTimer=1000;
    private int phantomTimer=1000;
    
    
    public static int userAge;
    public static int tutorialFlag=0;
    public static int volumeLevel=50;
    
    
    //PLAYER CLOTHING COLOR INTEGERS
    public static int shirtInteger=0;
    public static int pantsInteger=0;
    public static int skinInteger=0;
    
    public static int hairInteger=0;
    public static int faceInteger=0;
    public static int bootInteger=0;
    
    
    
    public static int outfitInteger=0;
    
    
    
    
    
    
    
    
    
    
    
    public static boolean[] cannotAdvance= new boolean[5];
    public static boolean[] cheatsMatrix=new boolean[100];
    
    
    public static int savedCoins;
    public static double savedScore;
    public static double savedTotalScore;
    public static SaveData saving;
    public static ResourceManager manager;
    
    public static final double WIDTH = 640, HEIGHT=WIDTH/12*9;
    private Thread thread;
    private Handler handler;
    private MainHUD hud;
    private MainSpawn spawn;
    private MainMenu menu;
    private EndMenu endMenu;
    private CheatMenu cheatMenu;
    private AboutMenu aboutMenu;
    private Marketplace shop;
    private PlayerMenu playerMenu;
    private OptionsMenu optionsMenu;
    private HelpMenu helpMenu;
    private AgeGate ageGate;
    private Logo logo;
    private FreeFall freeFall;
    private Tutorial tutorial;
    
    public static int FPS;
    
    private boolean running=false;
    
    public static double fallenScore;
    public static double fallenTotal;
    public static int impalersHit;
    public static int coinsPicked;
    
    //GRAPHICS OPTIONS
    public static int selectedResolution=640;
    public static int graphicSettings=3;
    public static int lightSettings=1;
    
    public static int langInt = 1;
    
    public static STATE gameState = STATE.Logo;
    public static LANGUAGE langState = LANGUAGE.English;
    
    
    
    public Game(){
        
        handler = new Handler();
        hud = new MainHUD();
        spawn = new MainSpawn(handler,hud);
        menu = new MainMenu(this,handler,hud);
        endMenu = new EndMenu(this,handler,hud);
        cheatMenu = new CheatMenu(this,handler,hud);
        aboutMenu = new AboutMenu(this,handler,hud);
        shop = new Marketplace(this,handler,hud);
        playerMenu = new PlayerMenu(this,handler,hud);
        optionsMenu = new OptionsMenu(this,handler,hud);
        helpMenu = new HelpMenu(this,handler,hud);
        ageGate = new AgeGate(this,handler,hud);
        logo = new Logo(this,handler);
        freeFall = new FreeFall(handler,hud,spawn);
        tutorial = new Tutorial(handler,hud,spawn);
        try{
        logoImage = ImageIO.read(new File("src\\res\\Logo.bmp"));
        logoImage1280 = ImageIO.read(new File("src\\res\\logo_1280.bmp"));
        logoImage1366 = ImageIO.read(new File("src\\res\\logo_1366.bmp"));
        logoImage1680 = ImageIO.read(new File("src\\res\\logo_1680.bmp"));
        logoImage1920 = ImageIO.read(new File("src\\res\\logo_1920.bmp"));
        coinImage = ImageIO.read(new File("src\\res\\LeuOne.jpg"));
        soundImage = ImageIO.read(new File("src\\res\\Sound.jpg"));
        tepesImage = ImageIO.read(new File("src\\res\\Tepes_One.jpg"));
        tepesImage2 = ImageIO.read(new File("src\\res\\Tepes_Two.jpg"));
        tepesBackground = ImageIO.read(new File("src\\res\\Tepes_Big.jpg"));
        tepesBackground2 = ImageIO.read(new File("src\\res\\Tepes_Big2.jpg"));
        tepesBackground3 = ImageIO.read(new File("src\\res\\Tepes_Big3.jpg"));
        tepesBackground4 = ImageIO.read(new File("src\\res\\Tepes_Big4.jpg"));
        tepesBackground5 = ImageIO.read(new File("src\\res\\Tepes_Big5.jpg"));}
        catch(IOException ex){
            System.out.println("Muie: " + ex);
        }
        
        
        this.addMouseListener(menu);
        this.addMouseListener(optionsMenu);
        this.addMouseWheelListener(optionsMenu);
        this.addMouseWheelListener(aboutMenu);
        this.addMouseListener(endMenu);
        this.addMouseListener(cheatMenu);
        this.addMouseListener(shop);
        this.addMouseListener(aboutMenu);
        this.addMouseListener(playerMenu);
        this.addMouseWheelListener(playerMenu);
        this.addMouseListener(ageGate);
        this.addMouseWheelListener(ageGate);
        //this.addMouseListener(tutorial);
        
        this.addMouseListener(helpMenu);
        this.addKeyListener(new KeyboardControl(handler,this));
        
        LoadGame();
        new Window((int)WIDTH,(int)HEIGHT,"Impaling Simulator",this);
        
    }
    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;
    }
    
    public synchronized void stop(){
        try{
            thread.join();
            running=false;
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta=0;
        long timer = System.currentTimeMillis();
        int frames=0;
        while(running){
            long now = System.nanoTime();
            delta+=(now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " +  frames);
                FPS=frames;
                frames = 0;
            }
                
            
        }
        stop();
    }
    
    private void tick(){
        //handler.tick();
        if(gameState==STATE.Logo){
            logo.tick();
            //hud.tick();
        }
        
        
        
        if(gameState==STATE.MainMenu){
            firstLaunch=true;
            //logo.tick();
            hud.tick();
            menu.tick();
            hud.Health=100;
            handler.wipeMediumObjects();
            //handler.wipeCloud();
            //handler.wipeMediumCloud();
            //handler.wipeBigCloud();
            handler.wipePlayer();
            spawn.TimerReset();
            
            
            spawn.playerSpawned=false;
            if(fallenScore>savedScore){
                savedScore=fallenScore;
                fallenScore=0;
            }
            else if(fallenScore<=savedScore){
            fallenScore=0;}
        }
        
        if(gameState==STATE.EndMenu || gameState==STATE.EndTutorial){
            //logo.tick();
            hud.tick();
            endMenu.tick();
            
            
            
        }
        
        if(gameState==STATE.CheatMenu){
            //logo.tick();
            hud.tick();
            cheatMenu.tick();
            
        }
        
        if(gameState==STATE.Shop){
            //logo.tick();
            hud.tick();
            shop.tick();
            
        }
        
        if(gameState==STATE.AboutMenu){
            //logo.tick();
            hud.tick();
            aboutMenu.tick();
            
        }
        
        if(gameState==STATE.PlayerMenu){
            //logo.tick();
            handler.tick();
            spawn.tick();
            playerMenu.tick();
            //handler.tick();
            //hud.tick();
            //spawn.tick();
            
            
        }
        if(gameState==STATE.OptionsMenu || gameState==STATE.SoundMenu || gameState==STATE.GraphicsMenu || gameState==STATE.OtherMenu || gameState==STATE.ResolutionMenu || gameState==STATE.LightMenu || gameState==STATE.QualityMenu || gameState==STATE.LanguageMenu){
            //logo.tick();
            optionsMenu.tick();
            //handler.tick();
            //hud.tick();
            //spawn.tick();
            
            
        }
        
        if(gameState==STATE.HelpMenu || gameState==STATE.GameHelp || gameState==STATE.DonationHelp || gameState==STATE.CustomerSupport){
            //logo.tick();
            helpMenu.tick();
            //handler.tick();
            //hud.tick();
            //spawn.tick();
            
            
        }
        
        if(gameState==STATE.AgeGate){
            //logo.tick();
            ageGate.tick();
            //handler.tick();
            //hud.tick();
            //spawn.tick();
            
            
        }
        
        
        if(gameState==STATE.Tutorial){
            //logo.tick();
            handler.tick();
            hud.tick();
            spawn.tick();
            freeFall.tick();
            if(hud.Health<=0){
            Game.gameState=STATE.EndTutorial;
            hud.Health=100;
            //Game.fallenScore=0;
            handler.wipeMediumObjects();
            spawn.TutorialTimerReset();
        }
        }
        
        if(gameState==STATE.FreeFall){
            //logo.tick();
            handler.tick();
            hud.tick();
            spawn.tick();
            freeFall.tick();
            if(hud.Health<=0){
            Game.gameState=STATE.EndMenu;
            hud.Health=100;
            //Game.fallenScore=0;
            handler.wipeMediumObjects();
            spawn.TimerReset();
        }
            if(doubleCoins==true){
                if(coinsTimer>0){
                    coinsTimer--;
                }
                else if(coinsTimer<=0){
                    doubleCoins=false;
                    coinsTimer=1000;
                }
            }
            if(phantomMode==true){
                if(phantomTimer>0){
                    phantomTimer--;
                }
                else if(phantomTimer<=0){
                    phantomMode=false;
                    phantomTimer=1000;
                }
            }
            
            
            
        }
        
        if(gameState==STATE.Game){
            //logo.tick();
            handler.tick();
            hud.tick();
            spawn.tick();
            
            
        }
        
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        
        
        if(gameState == STATE.Logo){
            
            //hud.render(g);
            logo.render(g);
        }
        
        if(gameState == STATE.MainMenu){
          g.setColor(Color.black);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            //hud.render(g);
            menu.render(g);
        }
        
        
        if(gameState == STATE.EndMenu || gameState==STATE.EndTutorial){
            
          
          g.setColor(Color.black);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            endMenu.render(g);
        }
        
        if(gameState == STATE.CheatMenu){
          g.setColor(Color.black);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            //hud.render(g);
            cheatMenu.render(g);
        }
        
        if(gameState == STATE.Shop){
          g.setColor(Color.black);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            //hud.render(g);
            shop.render(g);
        }
        
        if(gameState == STATE.AboutMenu){
          g.setColor(Color.black);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            //hud.render(g);
            aboutMenu.render(g);
        }
        
        if(gameState == STATE.PlayerMenu){
          g.setColor(Color.black);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            //hud.render(g);
            
            playerMenu.render(g);
            handler.render(g);
            
        }
        if(gameState == STATE.OptionsMenu || gameState==STATE.SoundMenu || gameState==STATE.GraphicsMenu || gameState==STATE.OtherMenu || gameState==STATE.ResolutionMenu || gameState==STATE.LightMenu || gameState==STATE.QualityMenu || gameState==STATE.LanguageMenu){
          g.setColor(Color.black);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            //hud.render(g);
            optionsMenu.render(g);
        }
        
        if(gameState == STATE.AgeGate){
          g.setColor(Color.blue);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            //hud.render(g);
            ageGate.render(g);
        }
        
        
        if(gameState == STATE.HelpMenu || gameState==STATE.GameHelp || gameState==STATE.DonationHelp || gameState==STATE.CustomerSupport){
          g.setColor(Color.black);
          g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);
            //hud.render(g);
            
            helpMenu.render(g);
        }
        
        if(gameState == STATE.FreeFall){
            
            //hud.render(g);
            
            freeFall.render(g);
            handler.render(g);
            hud.render(g);
            
            
            
        }
        
        if(gameState == STATE.Tutorial){
            
            //hud.render(g);
            
            tutorial.render(g);
            handler.render(g);
            hud.render(g);
            
            
            
        }
        
        if(gameState == STATE.Game){
            
            //hud.render(g);
            
            handler.render(g);
            hud.render(g);
            
            
        }
        
         
        g.dispose();
        bs.show();
        
        
    }

    
    
    
    
    
    
    
    public static double clamp(double var, double min, double max){
       if(var >= max)
           return var = max;
       else if(var <= min)
           return var = min;
       else
           return var;
       
   }
    
    
    
    public static void SaveGame(){
       saving = new SaveData(savedCoins,savedScore,fallenTotal,impalersHit,coinsPicked,skinInteger,shirtInteger,pantsInteger,userAge,firstLaunch);
       try{
           ResourceManager.save(saving,"1.save");
       }
       catch(Exception e){
           System.out.println("Error" + e.getMessage());
       }
       
       
       
       
       
       
       
       
   }
   
   
   public static void LoadGame(){
       
       saving = new SaveData(savedCoins,savedScore,fallenTotal,impalersHit,coinsPicked,skinInteger,shirtInteger,pantsInteger,userAge,firstLaunch);
       try{
           SaveData saving = (SaveData) ResourceManager.load("1.save");
           savedCoins=(saving.Data_Coins);
           savedScore=(saving.Data_MaxScore);
           fallenTotal=(saving.Data_fallenTotal);
           impalersHit=(saving.Data_impalersHit);
           coinsPicked=(saving.Data_coinsPicked);
           skinInteger=(saving.Data_skinOption);
           shirtInteger=(saving.Data_shirtOption);
           pantsInteger=(saving.Data_pantsOption);
           userAge=(saving.Data_userAge);
           firstLaunch=(saving.Data_firstLaunch);
           
           
           
       }
       catch(Exception e){
           System.out.println("Error" + e.getMessage());
       }
   }
   
   public static void ResetProfile(){
           savedCoins=0;
           savedScore=0;
           fallenTotal=0;
           impalersHit=0;
           coinsPicked=0;
           skinInteger=0;
           shirtInteger=0;
           pantsInteger=0;
           userAge=0;
           firstLaunch=false;
           SaveGame();
           gameState=STATE.AgeGate;
   }
   
   public static void ResetScore(){
       savedScore=0;
       SaveGame();
   }
    
    
    public static void main(String[] args) {
        new Game();
    }
    
    
    
    
}
