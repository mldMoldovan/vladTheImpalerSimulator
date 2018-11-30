
package impalingsimulator;

import java.awt.Color;
import java.awt.Graphics;




public class Tutorial {
    private Handler handler;
    private MainHUD hud;
    private MainSpawn spawn;
    private double theScore=0;
    
    
    public Tutorial(Handler handler, MainHUD hud, MainSpawn spawn){
        this.handler=handler;
        this.hud=hud;
        this.spawn=spawn;
    }
    
    
    
    
    public void addScore(double toAdd){
        theScore+=toAdd;
    }
    
    public void tick(){
        
    }
    
    
    public void render(Graphics g){
        g.setColor(Game.SkyBlue);
        g.fillRect(0,0,(int)Game.WIDTH,(int)Game.HEIGHT);
    
    }
    
}
