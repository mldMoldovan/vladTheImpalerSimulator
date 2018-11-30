
package impalingsimulator;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;





public class Player extends GameObject{
    
    
    Random r = new Random();
    Handler handler;
    Game Game;
    private int jumpTimer=20;
    private int vladTimer = 100;
    private float alpha = 0.4f;
    public static boolean isJumping=false;
    public static boolean onPlatform=false;
    public static double fallen;
    public static int[] xPoints= new int[4];
    public static int[] yPoints=new int[4];
    public static int[] xPoints2= new int[4];
    public static int[] yPoints2=new int[4];
    
    public static int[] xMou1= new int[3];
    public static int[] yMou1=new int[3];
    public static int[] xMou2= new int[3];
    public static int[] yMou2=new int[3];
    public static int[] xHat1= new int[3];
    public static int[] yHat1=new int[3];
    public static int[] xHat2= new int[3];
    public static int[] yHat2=new int[3];
    
    public static int[] xJew1= new int[3];
    public static int[] yJew1=new int[3];
    public static int[] xJew2= new int[3];
    public static int[] yJew2=new int[3];
    
    
    
    
    public Player(double x, double y,double objectHealth,int objectStatus, ID id, Handler handler){
        super(x,y,objectHealth,objectStatus,id);
        this.handler=handler;
        this.objectHealth = 100;
        if(Game.gameState==STATE.FreeFall){
        if(Game.cheatsMatrix[3]==false){
        velY=3;}
        else if(Game.cheatsMatrix[3]==true){
        velY=0;}
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x-10,(int)y+30,40,70);
    }
    
    public Rectangle getTotalBounds(){
        return new Rectangle((int)x-30,(int)y,80,140);
    }
    
    
    private void collision(){
        if(this.getId()==ID.Player){
        for(int i=0;i < handler.object.size(); i++){
            GameObject iaraObject = handler.object.get(i);
            if(iaraObject.getId() == ID.SmallImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                if(Game.phantomMode==false){
                MainHUD.Health-=10;
                Game.impalersHit++;}
            }
            
            
        }
            
            if(iaraObject.getId() == ID.MediumImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                if(Game.phantomMode==false){
                MainHUD.Health-=10;
                Game.impalersHit++;}
            }
            
            
        }
            
            if(iaraObject.getId() == ID.BigImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                if(Game.phantomMode==false){
                MainHUD.Health-=10;
                Game.impalersHit++;}
            }
            
            
        }
            if(iaraObject.getId() == ID.Coin){
            
            if(getTotalBounds().intersects(iaraObject.getBounds()))
            {   
                
                Game.coinsPicked++;
                if(Game.doubleCoins==true){
                Game.savedCoins+=2;    
                }
                else if(Game.doubleCoins==false){
                Game.savedCoins++;}
                
                
                iaraObject.objectStatus=2;
                
            }
            
            
        }
        
        
        
        
        }
        
        
        }
    }
    
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
    
    
    public void tick(){
        x+=velX;
        y+=velY;
        if(Game.outfitInteger==7 && Game.customOutfit==false){
            xJew1[0]=(int)x-5;
            xJew1[1]=(int)x+10;
            xJew1[2]=(int)x+25;
            yJew1[0]=(int)y+50;
            yJew1[1]=(int)y+70;
            yJew1[2]=(int)y+50;
            
            xJew2[0]=(int)x-5;
            xJew2[1]=(int)x+10;
            xJew2[2]=(int)x+25;
            yJew2[0]=(int)y+65;
            yJew2[1]=(int)y+40;
            yJew2[2]=(int)y+65;
        }
        //if(this.getId()==ID.Player){
        if(Game.gameState==STATE.FreeFall || Game.gameState==STATE.Tutorial){
            
        if(this.getId()==ID.Player){
            
        
        
        if(Game.cinematicEnabled==true){
        if(Game.cheatsMatrix[3]==false && Game.cinematicDone==true){
            
        velY=3;}
        else if(Game.cheatsMatrix[3]==true || Game.cinematicDone==false){
        if(Game.halfCinematic==true){    
        velX=1;}
        velY=0;}
        }
        else if(Game.cinematicEnabled==false){
        velY=3;
        }
        
        y = Game.clamp((int)y,5,Game.HEIGHT/2-100);
        x = Game.clamp((int)x,30,Game.WIDTH-55);
        if(this.getVelY()>0){
            Game.fallenScore+=velY;
            Game.fallenTotal+=velY;
            
            
        }  }
        
        if(this.getId()==ID.Vlad){
        xPoints[0]=(int)x-50;
        xPoints[1]=(int)x+70;
        xPoints[2]=(int)x-35;
        xPoints[3]=(int)x+55;
        yPoints[0]=(int)y+70;
        yPoints[1]=(int)y+70;
        yPoints[2]=(int)y+20;
        yPoints[3]=(int)y+20;
        
        xPoints2[0]=(int)x-60;
        xPoints2[1]=(int)x+80;
        xPoints2[2]=(int)x-45;
        xPoints2[3]=(int)x+65;
        yPoints2[0]=(int)y+80;
        yPoints2[1]=(int)y+80;
        yPoints2[2]=(int)y+10;
        yPoints2[3]=(int)y+10;
        
        xMou1[0]=(int)x+2;
        xMou1[1]=(int)x+10;
        xMou1[2]=(int)x+18;
        yMou1[0]=(int)y+15;
        yMou1[1]=(int)y+10;
        yMou1[2]=(int)y+15;
        
        xHat1[0]=(int)x-10;
        xHat1[1]=(int)x+30;
        xHat1[2]=(int)x+10;
        yHat1[0]=(int)y-1;
        yHat1[1]=(int)y-1;
        yHat1[2]=(int)y-15;
        
        
        
        
        
        x = Game.clamp((int)x,30,Game.WIDTH-55);
        
        
        if(Game.cinematicDone==false){
            velX=1;
            velY=0;
        }
        else if(Game.cinematicDone==true){
            velX=0;
            velY=-3;
        }
        
        
        
        if(this.getY()+140<0){
            handler.removeObject(this);
        }
        }
        
        
        if(this.getId()==ID.Soldier){
        
        xMou2[0]=(int)x+2;
        xMou2[1]=(int)x+10;
        xMou2[2]=(int)x+18;
        yMou2[0]=(int)y+15;
        yMou2[1]=(int)y+10;
        yMou2[2]=(int)y+15;
        
        xHat2[0]=(int)x-10;
        xHat2[1]=(int)x+30;
        xHat2[2]=(int)x+10;
        yHat2[0]=(int)y-1;
        yHat2[1]=(int)y-1;
        yHat2[2]=(int)y-15;
        
        
        
        
        
        x = Game.clamp((int)x,30,Game.WIDTH-55);
        if(Game.cinematicDone==false){
            velX=0;
            velY=0;
        }
        else if(Game.cinematicDone==true){
            velX=0;
            velY=-3;
        }
        if(this.getY()+140<0){
            handler.removeObject(this);
        }
        }
        
        
        
        
        }
        if(Game.cheatsMatrix[2]==false){
        collision();
        }
        
    }
    
    
    
    public void render(Graphics g){
        
        if(this.getId()==ID.Player){
        if(Game.cheatsMatrix[0]==true){
        g.setColor(Color.red);
        g.drawString("velX: " + this.getVelX(),(int)x-30,(int)y);
        g.drawString("velY: " + this.getVelY(),(int)x-30,(int)y-10);
        g.drawString("X: " + this.getX(),(int)x-30,(int)y-20);
        g.drawString("Y: " + this.getY(),(int)x-30,(int)y-30);
        g.drawString("S: " + this.objectStatus,(int)x-30,(int)y-40);}
        
        if(this.objectStatus==1){
           
        Graphics2D playerG = (Graphics2D) g;
           
            
        if(Game.phantomMode==true){ 
            playerG.setComposite(makeTransparent(alpha));
        }
        else if(Game.phantomMode==false){ 
            playerG.setComposite(makeTransparent(1));
        }
        if(Game.phantomMode==false){
        //LEG BONE LEFT LEG
        g.setColor(Color.white); 
        g.fillRect((int)x-5,(int)y+100,5,10);
        g.setColor(Color.red); 
        g.fillRect((int)x-5,(int)y+110,5,5);
        
        
        //LEG BONE RIGHT LEG
        g.setColor(Color.white);
        g.fillRect((int)x+20,(int)y+100,5,10);
        
        g.setColor(Color.red);
        g.fillRect((int)x+20,(int)y+110,5,5);
        
        
        //SHOULDER BONE
        g.setColor(Color.white);
        g.fillRect((int)x-30,(int)y+35,80,10);
        
        g.setColor(Color.red);
        g.fillRect((int)x-30,(int)y+35,5,10);
        g.fillRect((int)x+45,(int)y+35,5,10);}
            
        //HEAD
        if(Game.skinInteger==0){
        g.setColor(Color.yellow); 
        }
        else if(Game.skinInteger==1){
        g.setColor(Game.WhiteSkinColor); 
        }
        else if(Game.skinInteger==2){
        g.setColor(Game.ArabSkinColor); 
        }
        else if(Game.skinInteger==3){
        g.setColor(Game.BrownCP); 
        }
        else if(Game.skinInteger==4){
        g.setColor(Game.BlackSkinColor); 
        }
        
        g.fillOval((int)x-2,(int)y-2,24,24);
        
        //NECK
        g.fillRect((int)x+5,(int)y+20,10,10);
        
        //SHOULDERS
        if(Game.customOutfit==false){
         
            
        //TURBAN COAE    
        if(Game.outfitInteger==0){
            g.setColor(Color.white);
            g.fillRoundRect((int)x-10,(int)y-5,40,10,10,10);
            g.fillRoundRect((int)x-5,(int)y-15,30,10,10,10);
            g.fillRoundRect((int)x-2,(int)y-25,24,15,10,10);
            g.fillRect((int)x-5,(int)y-15,30,10);
            g.fillRoundRect((int)x+5,(int)y-32,10,10,10,10);
            
            g.setColor(Game.GreenColor);
            g.fillOval((int)x+2,(int)y-20,20,20);
            g.setColor(Color.white);
            g.fillOval((int)x+7,(int)y-20,20,20);
            g.setColor(Game.GreenColor);
            g.fillOval((int)x+10,(int)y-15,8,8);
            
        }
            
            
            //SHOULDERS
        if(Game.outfitInteger==0){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==1){
        g.setColor(Game.ArmyBlue);}
        else if(Game.outfitInteger==2){
        g.setColor(Game.GreenColor);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==6){
        g.setColor(Game.PurpleColor);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        //g.fillRect((int)x-30,(int)y+30,80,20);
        g.fillRect((int)x-20,(int)y+30,60,20);
        
        
        //BODY
        if(Game.outfitInteger==0){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==1){
        g.setColor(Game.ArmyBlue);}
        else if(Game.outfitInteger==2){
        g.setColor(Game.GreenColor);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==6){
        g.setColor(Game.PurpleColor);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        
        g.fillRect((int)x-10,(int)y+50,40,30);
        
        if(Game.outfitInteger==7){
        g.setColor(Color.white);
        g.fillPolygon(xJew1,yJew1,3);
        g.fillPolygon(xJew2,yJew2,3);}
        
        
        
        
        if(Game.outfitInteger!=7){
        g.setColor(Color.white);
        g.fillRect((int)x-5,(int)y+50,30,2);
        g.fillRect((int)x-5,(int)y+60,30,2);
        g.fillRect((int)x-5,(int)y+70,30,2);
        
        
        g.setColor(Color.orange);
        g.fillOval((int)x-8,(int)y+48,5,5);
        g.fillOval((int)x-8,(int)y+58,5,5);
        g.fillOval((int)x-8,(int)y+68,5,5);
        
        g.fillOval((int)x+23,(int)y+48,5,5);
        g.fillOval((int)x+23,(int)y+58,5,5);
        g.fillOval((int)x+23,(int)y+68,5,5);}
        
        //PELVIS
        if(Game.outfitInteger==0){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==1){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==2){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==6){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x-10,(int)y+80,40,20);
        if(Game.halfCinematic==false){
        //LEFT ARM
        if(Game.outfitInteger==0){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==1){
        g.setColor(Game.ArmyBlue);}
        else if(Game.outfitInteger==2){
        g.setColor(Game.GreenColor);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==6){
        g.setColor(Color.black);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x-30,(int)y+50,15,30);
        
        
        g.setColor(Game.WhiteSkinColor);
        g.fillRect((int)x-25,(int)y+80,5,5);
        
        
        //RIGHT ARM
        if(Game.outfitInteger==0){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==1){
        g.setColor(Game.ArmyBlue);}
        else if(Game.outfitInteger==2){
        g.setColor(Game.GreenColor);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==6){
        g.setColor(Color.black);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x+35,(int)y+50,15,30);
        
        g.setColor(Game.WhiteSkinColor);
        g.fillRect((int)x+40,(int)y+80,5,5);
        
        if(Game.outfitInteger==6 || Game.outfitInteger==2 || Game.outfitInteger==7){
            g.setColor(Color.white);
            
           if(Game.outfitInteger==2 || Game.outfitInteger==7){
           g.setColor(Color.white);}
           else if(Game.outfitInteger==6){
           g.setColor(Game.BloodColor);}
        g.fillRoundRect((int)x-35,(int)y+25,25,10,20,20);
        g.fillRoundRect((int)x+25,(int)y+25,25,10,20,20);
        if(Game.outfitInteger==2 || Game.outfitInteger==6){
           g.fillRect((int)x+7,(int)y+45,6,30);}
        }
        
        }
        
        }
        
        
        
        
        if(Game.customOutfit==true){
        
        //SHOULDER SHIRT
        if(Game.shirtInteger==0){
        g.setColor(Color.red);}
        else if(Game.shirtInteger==1){
        g.setColor(Color.blue);  
        }
        else if(Game.shirtInteger==2){
        g.setColor(Color.green);  
        }
        else if(Game.shirtInteger==3){
        g.setColor(Color.cyan);  
        }
        else if(Game.shirtInteger==4){
        g.setColor(Color.orange);  
        }
        
        g.fillRect((int)x-20,(int)y+30,60,20);
        }
        
        
        
        
        if(Game.gameState==STATE.PlayerMenu || Game.cinematicDone==false){
        if(Game.cinematicEnabled==true){
            
        if(Game.customOutfit==true){    
        //SHOULDERS
        if(Game.shirtInteger==0){
        g.setColor(Color.red);}
        else if(Game.shirtInteger==1){
        g.setColor(Color.blue);  
        }
        else if(Game.shirtInteger==2){
        g.setColor(Color.green);  
        }
        else if(Game.shirtInteger==3){
        g.setColor(Color.cyan);  
        }
        else if(Game.shirtInteger==4){
        g.setColor(Color.orange);  
        }
        g.fillRect((int)x-30,(int)y+30,80,20);
            
          
        
        //LEFT ARM
        if(Game.shirtInteger==0){
        g.setColor(Color.red);}
        else if(Game.shirtInteger==1){
        g.setColor(Color.blue);  
        }
        else if(Game.shirtInteger==2){
        g.setColor(Color.green);  
        }
        else if(Game.shirtInteger==3){
        g.setColor(Color.cyan);  
        }
        else if(Game.shirtInteger==4){
        g.setColor(Color.orange);  
        }
        g.fillRect((int)x-30,(int)y+50,15,30);
        
        
        
            //LEFT HAND
        if(Game.skinInteger==0){
        g.setColor(Color.yellow); 
        }
        else if(Game.skinInteger==1){
        g.setColor(Game.WhiteSkinColor); 
        }
        else if(Game.skinInteger==2){
        g.setColor(Game.ArabSkinColor); 
        }
        else if(Game.skinInteger==3){
        g.setColor(Game.BrownCP); 
        }
        else if(Game.skinInteger==4){
        g.setColor(Game.BlackSkinColor); 
        }
        g.fillRect((int)x-25,(int)y+80,5,5);
        
        //RIGHT ARM
        if(Game.shirtInteger==0){
        g.setColor(Color.red);}
        else if(Game.shirtInteger==1){
        g.setColor(Color.blue);  
        }
        else if(Game.shirtInteger==2){
        g.setColor(Color.green);  
        }
        else if(Game.shirtInteger==3){
        g.setColor(Color.cyan);  
        }
        else if(Game.shirtInteger==4){
        g.setColor(Color.orange);  
        }
        
        g.fillRect((int)x+35,(int)y+50,15,30);
        
        
        
        //LEFT HAND
        if(Game.skinInteger==0){
        g.setColor(Color.yellow); 
        }
        else if(Game.skinInteger==1){
        g.setColor(Game.WhiteSkinColor); 
        }
        else if(Game.skinInteger==2){
        g.setColor(Game.ArabSkinColor); 
        }
        else if(Game.skinInteger==3){
        g.setColor(Game.BrownCP); 
        }
        else if(Game.skinInteger==4){
        g.setColor(Game.BlackSkinColor); 
        }
        g.fillRect((int)x+40,(int)y+80,5,5);
        
        
        
        //LEFT LEG
        if(Game.pantsInteger==0){
        g.setColor(Color.blue);}
        else if(Game.pantsInteger==1){
        g.setColor(Color.green);}
        else if(Game.pantsInteger==2){
        g.setColor(Color.cyan);}
        else if(Game.pantsInteger==3){
        g.setColor(Game.BrownCP);}
        else if(Game.pantsInteger==4){
        g.setColor(Color.red);}
        g.fillRect((int)x-10,(int)y+100,15,30);
        
        //RIGHT LEG
        if(Game.pantsInteger==0){
        g.setColor(Color.blue);}
        else if(Game.pantsInteger==1){
        g.setColor(Color.green);}
        else if(Game.pantsInteger==2){
        g.setColor(Color.cyan);}
        else if(Game.pantsInteger==3){
        g.setColor(Game.BrownCP);}
        else if(Game.pantsInteger==4){
        g.setColor(Color.red);}
        g.fillRect((int)x+15,(int)y+100,15,30);
        
        //LEFT BOOT
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int)x-10,(int)y+130,15,10);
        
        //RIGHT BOOT
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int)x+15,(int)y+130,15,10);
        }
        else if(Game.customOutfit==false){
           
            //SHOULDERS
        if(Game.outfitInteger==0){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==1){
        g.setColor(Game.ArmyBlue);}
        else if(Game.outfitInteger==2){
        g.setColor(Game.GreenColor);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==5){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==6){
        g.setColor(Game.PurpleColor);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x-30,(int)y+30,80,20);
        
        //BODY
        if(Game.outfitInteger==0){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==1){
        g.setColor(Game.ArmyBlue);}
        else if(Game.outfitInteger==2){
        g.setColor(Game.GreenColor);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==5){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==6){
        g.setColor(Game.PurpleColor);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x-10,(int)y+50,40,30);
        
        if(Game.outfitInteger!=7){
        g.setColor(Color.white);
        g.fillRect((int)x-5,(int)y+50,30,2);
        g.fillRect((int)x-5,(int)y+60,30,2);
        g.fillRect((int)x-5,(int)y+70,30,2);
        
        
        g.setColor(Color.orange);
        g.fillOval((int)x-8,(int)y+48,5,5);
        g.fillOval((int)x-8,(int)y+58,5,5);
        g.fillOval((int)x-8,(int)y+68,5,5);
        
        g.fillOval((int)x+23,(int)y+48,5,5);
        g.fillOval((int)x+23,(int)y+58,5,5);
        g.fillOval((int)x+23,(int)y+68,5,5);}
        
        
        if(Game.outfitInteger==6 || Game.outfitInteger==2){
            g.setColor(Color.white);
           g.fillRect((int)x+7,(int)y+45,6,30);
        }
        
        if(Game.outfitInteger==7){
        g.setColor(Color.white);
        g.fillPolygon(xJew1,yJew1,3);
        g.fillPolygon(xJew2,yJew2,3);}
        
        //PELVIS
        if(Game.outfitInteger==0){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==1){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==2){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==5){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==6){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x-10,(int)y+80,40,20);
        
        //LEFT ARM
        if(Game.outfitInteger==0){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==1){
        g.setColor(Game.ArmyBlue);}
        else if(Game.outfitInteger==2){
        g.setColor(Game.GreenColor);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==5){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==6){
        g.setColor(Color.black);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x-30,(int)y+50,15,30);
        
        
        if(Game.skinInteger==0){
        g.setColor(Color.yellow); 
        }
        else if(Game.skinInteger==1){
        g.setColor(Game.WhiteSkinColor); 
        }
        else if(Game.skinInteger==2){
        g.setColor(Game.ArabSkinColor); 
        }
        else if(Game.skinInteger==3){
        g.setColor(Game.BrownCP); 
        }
        else if(Game.skinInteger==4){
        g.setColor(Game.BlackSkinColor); 
        }
        g.fillRect((int)x-25,(int)y+80,5,5);
        
        
        //RIGHT ARM
        if(Game.outfitInteger==0){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==1){
        g.setColor(Game.ArmyBlue);}
        else if(Game.outfitInteger==2){
        g.setColor(Game.GreenColor);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==5){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==6){
        g.setColor(Color.black);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x+35,(int)y+50,15,30);
        
        if(Game.skinInteger==0){
        g.setColor(Color.yellow); 
        }
        else if(Game.skinInteger==1){
        g.setColor(Game.WhiteSkinColor); 
        }
        else if(Game.skinInteger==2){
        g.setColor(Game.ArabSkinColor); 
        }
        else if(Game.skinInteger==3){
        g.setColor(Game.BrownCP); 
        }
        else if(Game.skinInteger==4){
        g.setColor(Game.BlackSkinColor); 
        }
        g.fillRect((int)x+40,(int)y+80,5,5);
        
        
        if(Game.outfitInteger==6 || Game.outfitInteger==2 || Game.outfitInteger==7){
            
           if(Game.outfitInteger==2 || Game.outfitInteger==7){
           g.setColor(Color.white);}
           else if(Game.outfitInteger==6){
           g.setColor(Game.BloodColor);}
        g.fillRoundRect((int)x-35,(int)y+25,25,10,20,20);
        g.fillRoundRect((int)x+25,(int)y+25,25,10,20,20);
        }
        
        //LEFT LEG
        if(Game.outfitInteger==0){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==1){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==2){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==5){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==6){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x-10,(int)y+100,15,30);
        
        //RIGHT LEG
        if(Game.outfitInteger==0){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==1){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==2){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==3){
        g.setColor(Game.OldColor);}
        else if(Game.outfitInteger==4){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==5){
        g.setColor(Game.BloodColor);}
        else if(Game.outfitInteger==6){
        g.setColor(Color.white);}
        else if(Game.outfitInteger==7){
        g.setColor(Game.RoyalBlue);}
        else if(Game.outfitInteger==8){
        g.setColor(Game.DarkOrange);}
        else if(Game.outfitInteger==9){
        g.setColor(Game.RoyalOrange);}
        g.fillRect((int)x+15,(int)y+100,15,30);
        
        //LEFT BOOT
        if(Game.outfitInteger!=7){
        g.setColor(Color.DARK_GRAY);}
        if(Game.outfitInteger==7){
            g.setColor(Color.black);
        }
        g.fillRect((int)x-10,(int)y+130,15,10);
        
        //RIGHT BOOT
        if(Game.outfitInteger!=7){
        g.setColor(Color.DARK_GRAY);}
        if(Game.outfitInteger==7){
            g.setColor(Color.black);
        }
        g.fillRect((int)x+15,(int)y+130,15,10);
        }
        
        }
        }
        if(Game.customOutfit==true){
        //BODY
        if(Game.shirtInteger==0){
        g.setColor(Color.red);}
        else if(Game.shirtInteger==1){
        g.setColor(Color.blue);  
        }
        else if(Game.shirtInteger==2){
        g.setColor(Color.green);  
        }
        else if(Game.shirtInteger==3){
        g.setColor(Color.cyan);  
        }
        else if(Game.shirtInteger==4){
        g.setColor(Color.orange);  
        }
        g.fillRect((int)x-10,(int)y+50,40,30);
        
        g.setColor(Color.blue);
        
        
        //PELVIS
        if(Game.pantsInteger==0){
        g.setColor(Color.blue);}
        else if(Game.pantsInteger==1){
        g.setColor(Color.green);}
        else if(Game.pantsInteger==2){
        g.setColor(Color.cyan);}
        else if(Game.pantsInteger==3){
        g.setColor(Game.BrownCP);}
        else if(Game.pantsInteger==4){
        g.setColor(Color.red);}
        g.fillRect((int)x-10,(int)y+80,40,20);}
        
       
        
        
        
         playerG.setComposite(makeTransparent(1));
        
        
        
        }
        
        else if(this.objectStatus==5){
            //HEAD
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int)y,20,20);
        
        //NECK
        g.fillRect((int)x+5,(int)y+20,10,10);
        
        //SHOULDERS
        g.setColor(Color.red);
        g.fillRect((int)x-30,(int)y+30,80,20);
        
        //BODY
        g.setColor(Color.red);
        g.fillRect((int)x-10,(int)y+50,40,30);
        
        //PELVIS
        g.setColor(Color.blue);
        g.fillRect((int)x-10,(int)y+80,40,20);
        
        //LEFT ARM
        g.setColor(Color.red);
        g.fillRect((int)x-30,(int)y+50,15,30);
        
        g.setColor(Color.yellow);
        g.fillRect((int)x-25,(int)y+80,5,5);
        
        //RIGHT ARM
        g.setColor(Color.red);
        g.fillRect((int)x+35,(int)y+50,15,30);
        
        g.setColor(Color.yellow);
        g.fillRect((int)x+40,(int)y+80,5,5);
        
        //LEFT LEG
        g.setColor(Color.blue);
        g.fillRect((int)x-10,(int)y+100,15,10);
        
        
        //RIGHT LEG
        g.setColor(Color.blue);
        g.fillRect((int)x+15,(int)y+100,15,10);
        
        //LEFT BOOT
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int)x-10,(int)y+110,15,10);
        
        //RIGHT BOOT
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int)x+15,(int)y+110,15,10);
        }
    }
        
        
        else if(this.getId()==ID.Vlad){
            //HEAD
          // g.setColor(Color.white);
        //g.fillPolygon(xPoints2,yPoints2,4);
        
        g.setColor(Game.WhiteSkinColor);
        g.fillOval((int)x-2,(int)y-2,24,24);
        
        g.setColor(Color.black);
        g.fillPolygon(xMou1,yMou1,3);
        
        
        
        g.setColor(Game.RoyalBlue);
        g.fillPolygon(xPoints,yPoints,4);
        
        //HAT
        g.setColor(Game.DarkRed);
        g.fillRoundRect((int)x-5,(int)y-10,30,10,10,10);
        g.fillRoundRect((int)x,(int)y-15,20,10,10,10);
        g.fillRoundRect((int)x,(int)y-20,20,10,10,10);
        g.fillRoundRect((int)x+3,(int)y-25,14,10,10,10);
        
        g.setColor(Color.white);
        g.fillPolygon(xHat1,yHat1,3);
        
        
        g.setColor(Color.orange);
        g.fillOval((int)x+7,(int)y-10,7,7);
        
        //NECK
        g.setColor(Game.WhiteSkinColor);
        g.fillRect((int)x+5,(int)y+20,10,10);
        
        //SHOULDERS
        g.setColor(Game.BloodColor);
        g.fillRect((int)x-30,(int)y+30,80,20);
        
        //BODY
        g.setColor(Game.BloodColor);
        g.fillRect((int)x-10,(int)y+50,40,30);
        
        g.setColor(Color.white);
        g.fillRect((int)x-5,(int)y+50,30,2);
        g.fillRect((int)x-5,(int)y+60,30,2);
        g.fillRect((int)x-5,(int)y+70,30,2);
        
        
        g.setColor(Color.orange);
        g.fillOval((int)x-8,(int)y+48,5,5);
        g.fillOval((int)x-8,(int)y+58,5,5);
        g.fillOval((int)x-8,(int)y+68,5,5);
        
        g.fillOval((int)x+23,(int)y+48,5,5);
        g.fillOval((int)x+23,(int)y+58,5,5);
        g.fillOval((int)x+23,(int)y+68,5,5);
        
        //PELVIS
        g.setColor(Game.OldColor);
        g.fillRect((int)x-10,(int)y+80,40,20);
        
        //LEFT ARM
        g.setColor(Game.BloodColor);
        g.fillRect((int)x-30,(int)y+50,15,30);
        
        g.setColor(Game.WhiteSkinColor);
        g.fillRect((int)x-25,(int)y+80,5,5);
        
        //RIGHT ARM
        g.setColor(Game.BloodColor);
        g.fillRect((int)x+35,(int)y+30,35,20);
        
        g.setColor(Game.WhiteSkinColor);
        g.fillRect((int)x+70,(int)y+35,5,10);
        
        
        //LEFT LEG
        g.setColor(Game.OldColor);
        g.fillRect((int)x-10,(int)y+100,15,30);
        
        //RIGHT LEG
        g.setColor(Game.OldColor);
        g.fillRect((int)x+15,(int)y+100,15,30);
        
        //LEFT BOOT
        g.setColor(Color.black);
        g.fillRect((int)x-10,(int)y+130,15,10);
        
        //RIGHT BOOT
        g.setColor(Color.black);
        g.fillRect((int)x+15,(int)y+130,15,10);
        }
        
        else if(this.getId()==ID.Soldier){
            //HEAD
          // g.setColor(Color.white);
        //g.fillPolygon(xPoints2,yPoints2,4);
        
        g.setColor(Game.WhiteSkinColor);
        g.fillOval((int)x-2,(int)y-2,24,24);
        
        g.setColor(Color.gray);
        g.fillPolygon(xMou2,yMou2,3);
        
        
        
        
        //HAT
        g.setColor(Color.black);
        g.fillRoundRect((int)x-5,(int)y-10,30,10,10,10);
        g.fillRoundRect((int)x,(int)y-15,20,10,10,10);
        g.fillRoundRect((int)x,(int)y-20,20,10,10,10);
        g.fillRoundRect((int)x+3,(int)y-25,14,10,10,10);
        
        //NECK
        g.setColor(Game.WhiteSkinColor);
        g.fillRect((int)x+5,(int)y+20,10,10);
        
        //SHOULDERS
        g.setColor(Game.ArmyBlue);
        g.fillRect((int)x-30,(int)y+30,80,20);
        
        g.setColor(Color.white);
        g.fillRoundRect((int)x-35,(int)y+25,25,10,20,20);
        g.fillRoundRect((int)x+25,(int)y+25,25,10,20,20);
        
        //BODY
        g.setColor(Game.ArmyBlue);
        g.fillRect((int)x-10,(int)y+50,40,30);
        
        
        
        g.setColor(Color.white);
        //VERTICALLY
        g.fillRect((int)x+7,(int)y+45,6,30);
        
        //HORIZONTALLY
        g.fillRect((int)x-5,(int)y+50,30,2);
        g.fillRect((int)x-5,(int)y+60,30,2);
        g.fillRect((int)x-5,(int)y+70,30,2);
        
        
        g.setColor(Color.orange);
        g.fillOval((int)x-8,(int)y+48,5,5);
        g.fillOval((int)x-8,(int)y+58,5,5);
        g.fillOval((int)x-8,(int)y+68,5,5);
        
        g.fillOval((int)x+23,(int)y+48,5,5);
        g.fillOval((int)x+23,(int)y+58,5,5);
        g.fillOval((int)x+23,(int)y+68,5,5);
        
        //PELVIS
        g.setColor(Color.white);
        g.fillRect((int)x-10,(int)y+80,40,20);
        
        //LEFT ARM
        g.setColor(Game.ArmyBlue);
        g.fillRect((int)x-30,(int)y+50,15,30);
        
        g.setColor(Game.WhiteSkinColor);
        g.fillRect((int)x-25,(int)y+80,5,5);
        
        //RIGHT ARM
        g.setColor(Game.ArmyBlue);
        g.fillRect((int)x+35,(int)y+50,15,30);
        
        
        
        g.setColor(Game.WhiteSkinColor);
        g.fillRect((int)x+40,(int)y+80,5,5);
        
        //LEFT LEG
        g.setColor(Color.white);
        g.fillRect((int)x-10,(int)y+100,15,30);
        
        //RIGHT LEG
        g.setColor(Color.white);
        g.fillRect((int)x+15,(int)y+100,15,30);
        
        //LEFT BOOT
        g.setColor(Color.black);
        g.fillRect((int)x-10,(int)y+130,15,10);
        
        //RIGHT BOOT
        g.setColor(Color.black);
        g.fillRect((int)x+15,(int)y+130,15,10);
        }
        
    }
        
        
    
    
    
    
    
        
    
    
}
