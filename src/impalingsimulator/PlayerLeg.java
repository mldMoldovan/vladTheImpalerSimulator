
package impalingsimulator;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;





public class PlayerLeg extends GameObject{
    
    
    Random r = new Random();
    Handler handler;
    Game Game;
    private GameObject player;
    private float alpha = 0.3f;
    public static boolean leftLegDamaged=false;
    public static boolean rightLegDamaged=false;
    public static int[] xValues= new int[3];
    public static int[] yValues=new int[3];
    
    
    
    public PlayerLeg(double x, double y,double objectHealth,int objectStatus, ID id, Handler handler){
        super(x,y,objectHealth,objectStatus,id);
        this.handler=handler;
        this.objectHealth = 100;
        
        for(int i=0;i<handler.object.size();i++){
            if(handler.object.get(i).getId() == ID.Player)
            player = handler.object.get(i);
            
        
        }
    }
    
    public Rectangle getBounds(){
        if(this.getId()==ID.PlayerLeftLeg){
        return new Rectangle((int)player.getX()-10,(int)player.getY()+100,15,40);}
        else if(this.getId()==ID.PlayerRightLeg){
        return new Rectangle((int)player.getX()+15,(int)player.getY()+100,15,40);}
        else{
        return new Rectangle((int)player.getX()+35,(int)player.getY(),15,50);}
    }
    
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
    
    
    public void collision(){
        for(int i=0;i < handler.object.size(); i++){
            GameObject iaraObject = handler.object.get(i);
            if(this.getId()==ID.PlayerLeftLeg){
            if(iaraObject.getId() == ID.SmallImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                leftLegDamaged=true;
                
            }
            
            
        }
            if(iaraObject.getId() == ID.MediumImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                leftLegDamaged=true;
                
            }
            
            
        }
            if(iaraObject.getId() == ID.BigImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                leftLegDamaged=true;
                
            }
            
            
        }
            
        }
            
            else if(this.getId()==ID.PlayerRightLeg){
            if(iaraObject.getId() == ID.SmallImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                rightLegDamaged=true;
                
            }
            
            
        }
            if(iaraObject.getId() == ID.MediumImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                rightLegDamaged=true;
                
            }
            
            
        }
            if(iaraObject.getId() == ID.BigImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                rightLegDamaged=true;
                
            }
            
            
        }
            
        }
           
            
            
        }
    }
    
    
    public void tick(){
        x+=velX;
        y+=velY;
        
        if(this.getId()==ID.PlayerLeftLeg){
        if(leftLegDamaged==false){   
        this.setVelY(player.getVelY());
        this.setVelX(player.getVelX());
        }
        else{
        handler.removeObject(this);
        handler.addObject(new BloodDrop((int)player.getX()-10,(int)player.getY()+100,100,1,ID.BloodDrop,handler));
        }
        }
        
        else if(this.getId()==ID.PlayerRightLeg){
        if(rightLegDamaged==false){   
        this.setVelY(player.getVelY());
        this.setVelX(player.getVelX());
        }
        else{
        handler.removeObject(this);
        handler.addObject(new BloodDrop((int)player.getX()+15,(int)player.getY()+100,100,1,ID.BloodDrop,handler));
        }
        }
            
        if(this.getY()<0){
            handler.removeObject(this);
        }
        
        
        
        if(Game.phantomMode!=true){
        collision();}
    }
    
    
    
    
    
    public void render(Graphics g){
        
        Graphics2D plegG = (Graphics2D) g;
           
            
        if(Game.phantomMode==true){ 
        plegG.setComposite(makeTransparent(alpha));}
        else if(Game.phantomMode==false){
        plegG.setComposite(makeTransparent(1));    
        }
        
        
        if(this.getId()==ID.PlayerLeftLeg){
            
            
        
            
        
        if(Game.customOutfit==true){
        if(Game.pantsInteger==0){
        g.setColor(Color.blue);}
        else if(Game.pantsInteger==1){
        g.setColor(Color.green);}
        else if(Game.pantsInteger==2){
        g.setColor(Color.cyan);}
        else if(Game.pantsInteger==3){
        g.setColor(Game.BrownCP);}
        else if(Game.pantsInteger==4){
        g.setColor(Color.red);}}
        else if(Game.customOutfit==false){
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
        }
        
        
        
        if(leftLegDamaged==false){
        g.fillRect((int)player.getX()-10,(int)player.getY()+100,15,30);}
        else if(leftLegDamaged==true){
        g.fillRect((int)x,(int)y,15,30);    
        }
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int)player.getX()-10,(int)player.getY()+130,15,10);
        
        
        
        
        }
        
        else if(this.getId()==ID.PlayerRightLeg){
            
        
            
            
        if(Game.customOutfit==true){
        if(Game.pantsInteger==0){
        g.setColor(Color.blue);}
        else if(Game.pantsInteger==1){
        g.setColor(Color.green);}
        else if(Game.pantsInteger==2){
        g.setColor(Color.cyan);}
        else if(Game.pantsInteger==3){
        g.setColor(Game.BrownCP);}
        else if(Game.pantsInteger==4){
        g.setColor(Color.red);}}
        else if(Game.customOutfit==false){
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
        }
        
        
        
        if(rightLegDamaged==false){
        g.fillRect((int)player.getX()+15,(int)player.getY()+100,15,30);}
        else if(rightLegDamaged==true){  
        g.fillRect((int)x,(int)y,15,30);}
        
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int)player.getX()+15,(int)player.getY()+130,15,10);
        
        }
        
        
        
        
        
        }
    }
    


