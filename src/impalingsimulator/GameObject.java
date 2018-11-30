
package impalingsimulator;

import java.awt.Graphics;
import java.awt.Rectangle;



public abstract class GameObject {
    
    protected double x,y;
    protected double velX,velY;
    protected ID id;
    protected double objectHealth;
    protected int objectStatus;
    
    public GameObject(double x, double y,double objectHealth,int objectStatus ,ID id){
        this.x = x;
        this.y = y;
        this.id = id;
        this.objectHealth=objectHealth;
        this.objectStatus=objectStatus;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public void setX(double x){
        this.x=x;
    }
    
    public void setY(double y){
        this.y=y;
    }
    
    public void setID(ID id){
        this.id=id;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public ID getId(){
        return id;
    }
    
    public void setVelX(double velX){
        this.velX = velX;
    }
    
    public void setVelY(double velY){
        this.velY = velY;
    }
    
    public double getVelX(){
        return velX;
    }
    
    public double getVelY(){
        return velY;
    }
    
    public void setHealth(double objectHealth){
        this.objectHealth=objectHealth;
    }
    
    public void setStatus(int objectStatus){
        this.objectStatus=objectStatus;
    }
    
    public double getHealth(){
        return objectHealth;
    }
    public int getStatus(){
        return objectStatus;
    }
    
    
}
