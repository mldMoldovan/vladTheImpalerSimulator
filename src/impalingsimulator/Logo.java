
package impalingsimulator;

import java.awt.Color;
import java.awt.Graphics;






public class Logo {
    private Game Game;
    private Handler handler;
    private int logoTimer=100;
    private int gameLogoT=100;
    
    public Logo(Game Game,Handler handler){
        this.handler=handler;
        this.Game = Game;
    }
    
    public void tick(){
        if(logoTimer>0){
            logoTimer--;
        }
        
        if(logoTimer==0){
            if(gameLogoT>0){
                gameLogoT--;
            }
            if(gameLogoT<=0){
            if(Game.firstLaunch==true){
            Game.gameState = STATE.MainMenu;}
            else if(Game.firstLaunch==false){
            Game.gameState = STATE.AgeGate;}
            }
        }
        
    }
    
    public void render(Graphics g){
        /*
        g.setColor(Color.black);
        g.fillRect(0,0,(int)Game.WIDTH,(int)Game.HEIGHT);
        g.setColor(Color.white);
        g.setFont(Game.LogoFont);
        if(Game.WIDTH==640){
            
        g.drawString("MLD Corporation",120,(int)Game.HEIGHT/2-50);
        g.setFont(Game.SmallLogoFont);
        g.drawString("© Copyright 2017",230,(int)Game.HEIGHT-50);
        }
        
        if(Game.WIDTH==960){
        g.drawString("MLD Corporation",250,(int)Game.HEIGHT/2);
        g.setFont(Game.CopyrightFont);
        g.drawString("© Copyright 2017",390,(int)Game.HEIGHT/60*55);}*/
        if(Game.WIDTH==640){
        if(logoTimer>0){
        g.drawImage(Game.logoImage,0,0,Game);}
        else{
        g.drawImage(Game.tepesBackground5,0,0,Game);    
        }
        }
        else if(Game.WIDTH==1280){
        g.drawImage(Game.logoImage1280,0,0,Game);    
        }
        else if(Game.WIDTH==1366){
        g.drawImage(Game.logoImage1366,0,0,Game);    
        }
        else if(Game.WIDTH==1680){
        g.drawImage(Game.logoImage1680,0,0,Game);    
        }
        else if(Game.WIDTH==1920){
        g.drawImage(Game.logoImage1920,0,0,Game);    
        }
        //g.drawImage(Game.tepesBackground4,0,0,Game);
    }
    
}
