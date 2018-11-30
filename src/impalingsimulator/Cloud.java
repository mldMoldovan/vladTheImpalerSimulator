
package impalingsimulator;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;





public class Cloud extends GameObject{
    
    
    Random r = new Random();
    Handler handler;
    Game Game;
    private GameObject player;
    private int cloudTimer = 2;
    private float alpha = 0.6f;
    
    public Cloud(double x, double y,double objectHealth,int objectStatus, ID id, Handler handler){
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
        if(this.getId()==ID.Cloud){
        return new Rectangle((int)x,(int)y,50,30);}
        else if(this.getId()==ID.MediumCloud){
        return new Rectangle((int)x,(int)y,150,60);}
        else if(this.getId()==ID.BigCloud){
        return new Rectangle((int)x,(int)y,300,100);}
        else{
        return new Rectangle((int)x+30,(int)y,80,140);  
        }
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
        
        if(this.getId()==ID.Cloud){
            
            
            
        if(this.getY()+30<0){
            
            if(cloudTimer==0){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-70),(int)Game.HEIGHT+200,100,1,ID.Cloud,handler));
            }
            else if(cloudTimer==1){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-200),(int)Game.HEIGHT+200,100,1,ID.MediumCloud,handler));
            }
            else if(cloudTimer==2){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-400),(int)Game.HEIGHT+200,100,1,ID.BigCloud,handler));
            }
            handler.removeObject(this);
        }
        }
        else if(this.getId()==ID.MediumCloud){
        if(this.getY()+60<0){
            
            if(cloudTimer==0){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-70),(int)Game.HEIGHT+200,100,1,ID.Cloud,handler));
            }
            else if(cloudTimer==1){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-200),(int)Game.HEIGHT+200,100,1,ID.MediumCloud,handler));
            }
            else if(cloudTimer==2){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-400),(int)Game.HEIGHT+200,100,1,ID.BigCloud,handler));
            }
            handler.removeObject(this);
        }
        }
        else if(this.getId()==ID.BigCloud){
        if(this.getY()+100<0){
            
            
            if(cloudTimer==0){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-70),(int)Game.HEIGHT+200,100,1,ID.Cloud,handler));
            }
            else if(cloudTimer==1){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-200),(int)Game.HEIGHT+200,100,1,ID.MediumCloud,handler));
            }
            else if(cloudTimer==2){
            handler.addObject(new Cloud((int)Game.clamp(r.nextInt((int)Game.WIDTH),0,Game.WIDTH-400),(int)Game.HEIGHT+200,100,1,ID.BigCloud,handler));
            }
            
            handler.removeObject(this);
        }
        }
        
        
        if(cloudTimer>0){
            cloudTimer--;
            
        }
        else if(cloudTimer<=0){
            cloudTimer=2;
        }
    }
    
    
    
    public void render(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(Color.LIGHT_GRAY);
        if(this.getId()==ID.Cloud){
        g.fillRoundRect((int)x,(int)y,50,30,40,20);}
        else if(this.getId()==ID.MediumCloud){
        g.fillRoundRect((int)x,(int)y,150,60,60,80);}
        else if(this.getId()==ID.BigCloud){
        g.fillRoundRect((int)x,(int)y,300,100,80,120);}
        g2d.setComposite(makeTransparent(1));
        //g.fill3DRect((int)x,(int)y,50,40,false);
        
        
        }
    }
    

