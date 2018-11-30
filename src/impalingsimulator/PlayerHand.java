
package impalingsimulator;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;





public class PlayerHand extends GameObject{
    
    
    Random r = new Random();
    Handler handler;
    Game Game;
    private GameObject player;
    private float alpha = 0.3f;
    public static boolean leftHandDamaged=false;
    public static boolean rightHandDamaged=false;
    public static int[] xValues= new int[3];
    public static int[] yValues=new int[3];
    
    
    
    public PlayerHand(double x, double y,double objectHealth,int objectStatus, ID id, Handler handler){
        super(x,y,objectHealth,objectStatus,id);
        this.handler=handler;
        this.objectHealth = 100;
        
        for(int i=0;i<handler.object.size();i++){
            if(handler.object.get(i).getId() == ID.Player)
            player = handler.object.get(i);
            
        
        }
    }
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
    
    public Rectangle getBounds(){
        if(this.getId()==ID.PlayerLeftHand){
        return new Rectangle((int)player.getX()-30,(int)player.getY(),15,50);}
        else if(this.getId()==ID.PlayerRightHand){
        return new Rectangle((int)player.getX()+35,(int)player.getY(),15,50);}
        else{
        return new Rectangle((int)player.getX()+35,(int)player.getY(),15,50);}
    }
    
    
    
    public void collision(){
        for(int i=0;i < handler.object.size(); i++){
            GameObject iaraObject = handler.object.get(i);
            if(this.getId()==ID.PlayerLeftHand){
            if(iaraObject.getId() == ID.SmallImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                leftHandDamaged=true;
                
            }
            
            
        }
            if(iaraObject.getId() == ID.MediumImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                leftHandDamaged=true;
                
            }
            
            
        }
            if(iaraObject.getId() == ID.BigImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                leftHandDamaged=true;
                
            }
            
            
        }
            
        }
            
            else if(this.getId()==ID.PlayerRightHand){
            if(iaraObject.getId() == ID.SmallImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                rightHandDamaged=true;
                
            }
            
            
        }
            if(iaraObject.getId() == ID.MediumImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                rightHandDamaged=true;
                
            }
            
            
        }
            if(iaraObject.getId() == ID.BigImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                rightHandDamaged=true;
                
            }
            
            
        }
            
        }
           
            
            
        }
    }
    
    
    public void tick(){
        x+=velX;
        y+=velY;
        
        
        if(this.getId()==ID.PlayerLeftHand){
        if(leftHandDamaged==false){   
        this.setVelY(player.getVelY());
        this.setVelX(player.getVelX());
        }
        else{
        handler.removeObject(this);
        handler.addObject(new BloodDrop((int)player.getX()-30,(int)player.getY(),100,1,ID.BloodDrop,handler));
        }
        }
        
        else if(this.getId()==ID.PlayerRightHand){
        if(rightHandDamaged==false){   
        this.setVelY(player.getVelY());
        this.setVelX(player.getVelX());
        }
        else{
        handler.removeObject(this);
        handler.addObject(new BloodDrop((int)player.getX()+35,(int)player.getY(),100,1,ID.BloodDrop,handler));
        }
        }
            
        if(this.getY()<0){
            handler.removeObject(this);
        }
        
        
        
        if(Game.phantomMode!=true){
        collision();}
    }
    
    
    
    
    
    public void render(Graphics g){
        
        Graphics2D phandG = (Graphics2D) g;
           
            
        if(Game.phantomMode==true){ 
        phandG.setComposite(makeTransparent(alpha));}
        else if(Game.phantomMode==false){
        phandG.setComposite(makeTransparent(1));    
        }
        
        
        if(Game.cinematicDone==true || !Game.cinematicEnabled==true){
        
        if(this.getId()==ID.PlayerLeftHand){
            
        if(Game.customOutfit==true){
            
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
        if(leftHandDamaged==false){
        g.fillRect((int)player.getX()-30,(int)player.getY(),15,50);}
        else if(leftHandDamaged==true){
        g.fillRect((int)x,(int)y,15,50);    
        }
        
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
        if(leftHandDamaged==false){
        g.fillRect((int)player.getX()-25,(int)player.getY()-5,5,5);}
        else if(leftHandDamaged==true){
        g.fillRect((int)x,(int)y,5,5);}
        }
        
        else if(Game.customOutfit==false){
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
        if(leftHandDamaged==false){
        g.fillRect((int)player.getX()-30,(int)player.getY(),15,50);}
        else if(leftHandDamaged==true){
        g.fillRect((int)x,(int)y,15,50);    
        }
        
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
        if(leftHandDamaged==false){
        g.fillRect((int)player.getX()-25,(int)player.getY()-5,5,5);}
        else if(leftHandDamaged==true){
        g.fillRect((int)x,(int)y,5,5);  
        }
        
        }}
        
        
            
        
        
        
        
        
        else if(this.getId()==ID.PlayerRightHand){
            
        if(Game.customOutfit==true){    
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
        if(rightHandDamaged==false){
        g.fillRect((int)player.getX()+35,(int)player.getY(),15,50);}
        else if(rightHandDamaged==true){
        g.fillRect((int)x,(int)y,15,50);}
        
        
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
        if(rightHandDamaged==false){
        g.fillRect((int)player.getX()+40,(int)player.getY()-5,5,5);}
        else if(rightHandDamaged==true){
        g.fillRect((int)x,(int)y,5,5);}
        
        }
        else if(Game.customOutfit==false){
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
        if(rightHandDamaged==false){
        g.fillRect((int)player.getX()+35,(int)player.getY(),15,50);}
        else if(rightHandDamaged==true){
        g.fillRect((int)x,(int)y,15,50);}
        
        
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
        
        if(rightHandDamaged==false){
        g.fillRect((int)player.getX()+40,(int)player.getY()-5,5,5);}
        else if(rightHandDamaged==true){
        g.fillRect((int)x,(int)y,5,5);}
          
        }
        
        }
        
        
        
    }
        
        }
    }
    


