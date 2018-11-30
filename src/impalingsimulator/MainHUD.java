
package impalingsimulator;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;





public class MainHUD {
    
    private double level=0;
    private double scoreTimer=0;
    
    public static int Health = 100;
    private float alpha = 0.75f;
    
    public MainHUD(){
        
        
    }
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
    
    public void tick(){
        scoreTimer++;
        
    }
    
    
    public void render(Graphics g){
        
        if(Game.cheatsMatrix[1]==true){
        g.setColor(Color.white);
        g.drawString("FPS:"+Game.FPS,10,60);}
        
        
        
        
    
        
        Graphics2D hudG = (Graphics2D) g;
        hudG.setComposite(makeTransparent(alpha));
        
        g.setColor(Color.yellow);
        g.fillOval((int)Game.WIDTH/2-100,-100,200,200);
        
        
        hudG.setComposite(makeTransparent(1));
        
        g.setColor(Color.white);
        g.drawOval((int)Game.WIDTH/2-100,-100,200,200);
        
        
        g.setColor(Color.white);
        g.setFont(Game.ScoreFont);
        if(Game.fallenScore<100 && Game.fallenScore>9){
        g.drawString(" " + (int)Game.fallenScore,(int)Game.WIDTH/2-15,30);}
        if(Game.fallenScore<1000 && Game.fallenScore>99){
        g.drawString(" " + (int)Game.fallenScore,(int)Game.WIDTH/2-25,30);}
        else if(Game.fallenScore<10000 && Game.fallenScore>999){
        g.drawString(" " + (int)Game.fallenScore,(int)Game.WIDTH/2-35,30);}
        else if(Game.fallenScore<100000 && Game.fallenScore>9999){
        g.drawString(" " + (int)Game.fallenScore,(int)Game.WIDTH/2-45,30);}
    
        
        
        g.setColor(Color.green);
        g.setFont(Game.ScoreFont);
        g.drawString((int)Game.savedCoins+" $ ",10,30);
    
    }
    
    
    public void setLevel(double level){
        this.level = level;
    }
    
    public void setScoreTimer(double scoreTimer){
        this.scoreTimer = scoreTimer;
    }
    
    public double getLevel(){
        return level;
    }
    
    public double getscoreTimer(){
        return scoreTimer;
    }
    
}
