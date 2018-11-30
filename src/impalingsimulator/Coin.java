
package impalingsimulator;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;





public class Coin extends GameObject{
    
    
    Random r = new Random();
    Handler handler;
    Game Game;
    private GameObject player;
    
    public Coin(double x, double y,double objectHealth,int objectStatus, ID id, Handler handler){
        super(x,y,objectHealth,objectStatus,id);
        this.handler=handler;
        this.objectHealth = 100;
        this.objectStatus=1;
        for(int i=0;i<handler.object.size();i++){
            if(handler.object.get(i).getId() == ID.Player)
            player = handler.object.get(i);
            
        
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,80,40);
    }
    
    
    
    public void tick(){
        x+=velX;
        y+=velY;
        
        if(player.getVelY()>0){
            this.setVelY(player.getVelY()*(-1));
        }
        else{
            this.setVelY(0);
        }
        
        if(this.getY()+40<0 || this.objectStatus==2){
            handler.addObject(new Coin((int)Game.clamp(r.nextInt((int)Game.WIDTH),50,Game.WIDTH-100),(int)Game.HEIGHT+500,100,1,ID.Coin,handler));
            
            handler.removeObject(this);
        }
        
    }
    
    
    
    public void render(Graphics g){
        g.drawImage(Game.coinImage,(int)x,(int)y,Game);
        
        
        }
    }
    


