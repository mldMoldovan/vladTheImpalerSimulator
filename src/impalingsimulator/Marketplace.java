
package impalingsimulator;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







public class Marketplace extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    
    
    public Marketplace(Game Game,Handler handler,MainHUD hud){
        this.Game=Game;
        this.handler=handler;
        this.hud=hud;
    }
    
    
    
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if(Game.gameState==STATE.Shop){
        if(Game.WIDTH==640){
            if(mouseOver(mx,my,(int)Game.WIDTH/2-310,10,200,50)){
             if(Game.savedCoins>1 && Game.phantomMode==false){
             Game.phantomMode=true;
             Game.savedCoins-=1;}
    }
            if(mouseOver(mx,my,(int)Game.WIDTH/2-310,70,200,50)){
            if(Game.savedCoins>1 && Game.doubleCoins==false){
             Game.doubleCoins=true;
             Game.savedCoins-=1;}
    }
            
            if(mouseOver(mx,my,(int)Game.WIDTH/2-310,130,200,50)){
            if(Game.savedCoins>1 && (PlayerHand.leftHandDamaged==true || PlayerHand.rightHandDamaged==true || PlayerLeg.leftLegDamaged==true || PlayerLeg.rightLegDamaged==true)){
             
            PlayerHand.leftHandDamaged=false;
            PlayerHand.rightHandDamaged=false;
            PlayerLeg.leftLegDamaged=false;
            PlayerLeg.rightLegDamaged=false;
            
             Game.partsRebuild=true;
             
             Game.savedCoins-=1;}
            
            
    }
            
        }
        if(Game.WIDTH==960){
        //MAIN MENU
        
           //SLAV STORY
        if(mouseOver(mx,my,(int)Game.WIDTH/2-150,20,300,100)){
        Game.gameState = STATE.FreeFall;
    }
           //QUIT
        if(mouseOver(mx,my,(int)Game.WIDTH/2-150,500,300,100)){
        System.exit(1);
    }
        
        
        
        }
       
        }
    }
    
    
    
    private boolean mouseOver(int mx, int my,int x,int y,int width, int height) {
        if(mx > x && mx < (x + width))
        {
            if(my > y && my < (y + height)){
                return true;
            }else return false;
            
        }else return false;
        
    }
    
    
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        if(Game.gameState==STATE.Shop){
                g.setFont(Game.Roman25);
            
            if(Game.WIDTH==640)
            {
         
                
         //RECT UP LEFT
        if(Game.phantomMode==false){        
        g.setColor(Color.blue);}
        else if(Game.phantomMode==true){        
        g.setColor(Game.SkyBlue);}
        g.fillRoundRect((int)Game.WIDTH/2-310,10,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,10,200,50,40,40);
        g.drawString("Phantom Mode",(int)Game.WIDTH/2-290,40);
        
        //RECT MEDIUM LEFT
        if(Game.doubleCoins==false){        
        g.setColor(Color.blue);}
        else if(Game.doubleCoins==true){        
        g.setColor(Game.SkyBlue);}
        g.fillRoundRect((int)Game.WIDTH/2-310,70,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,70,200,50,40,40);
        g.drawString("Double Coins",(int)Game.WIDTH/2-290,100);
        
        //RECT DOWN LEFT
        if(PlayerHand.leftHandDamaged==false && PlayerHand.rightHandDamaged==false && PlayerLeg.leftLegDamaged==false && PlayerLeg.rightLegDamaged==false)
        {g.setColor(Game.SkyBlue);}
        else if(PlayerHand.leftHandDamaged==true || PlayerHand.rightHandDamaged==true || PlayerLeg.leftLegDamaged==true || PlayerLeg.rightLegDamaged==true){
        g.setColor(Color.blue);
        }
        g.fillRoundRect((int)Game.WIDTH/2-310,130,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,130,200,50,40,40);
        g.drawString("Rebuild Body",(int)Game.WIDTH/2-290,160);
        
        //RECT HELL LEFT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-310,190,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,190,200,50,40,40);
        g.drawString("Item 004",(int)Game.WIDTH/2-290,220);
        
        //RECT HELL DOWN LEFT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-310,250,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,250,200,50,40,40);
        g.drawString("Item 005",(int)Game.WIDTH/2-290,280);       
                
                
        // RECT UP CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,10,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,10,200,50,40,40);
        g.drawString("Item 006",(int)Game.WIDTH/2-80,40);
        
        // RECT MEDIUM CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,70,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,70,200,50,40,40);
        g.drawString("Item 007",(int)Game.WIDTH/2-80,100);
        
        //RECT DOWN CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,130,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,130,200,50,40,40);
        g.drawString("Item 008",(int)Game.WIDTH/2-80,160);
        
        //RECT HELL CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,190,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,190,200,50,40,40);
        g.drawString("Item 009",(int)Game.WIDTH/2-80,220);
        
        //RECT HELL DOWN CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,250,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,250,200,50,40,40);
        g.drawString("Item 010",(int)Game.WIDTH/2-80,280);
        
        
        
        
        
        // RECT UP RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,10,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,10,200,50,40,40);
        g.drawString("Item 011",(int)Game.WIDTH/2+130,40);
        
        //RECT MEDIUM RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,70,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,70,200,50,40,40);
        g.drawString("Item 012",(int)Game.WIDTH/2+130,100);
        
        
        
        //RECT DOWN RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,130,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,130,200,50,40,40);
        g.drawString("Item 013",(int)Game.WIDTH/2+130,160);
        
        
        //RECT HELL RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,190,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,190,200,50,40,40);
        g.drawString("Item 014",(int)Game.WIDTH/2+130,220);
        
        //RECT HELL DOWN RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,250,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,250,200,50,40,40);
        g.drawString("Item 015",(int)Game.WIDTH/2+130,280);
        
        
        
        
        //RECT BACK DOWN LEFT
        g.setColor(Color.red);
        g.fillRoundRect((int)Game.WIDTH/2-310,310,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,310,200,50,40,40);
        g.drawString("Back",(int)Game.WIDTH/2-250,340);
        
        //RECT NEXT DOWN RIGHT
        g.setColor(Color.green);
        g.fillRoundRect((int)Game.WIDTH/2+110,310,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,310,200,50,40,40);
        g.drawString("Next Page",(int)Game.WIDTH/2+140,340);
        
            }
            
            
            if(Game.WIDTH==960)
            {
        g.setColor(Color.white);
        g.drawString("Slav Story",(int)Game.WIDTH/2-80,80);
        g.drawRoundRect((int)Game.WIDTH/2-150,20,300,100,20,20);
        
        
        g.drawRoundRect((int)Game.WIDTH/2-150,140,300,100,20,20);
        
        
        
        g.drawRoundRect((int)Game.WIDTH/2-150,260,300,100,20,20);
        
        
        g.drawString("Settings",(int)Game.WIDTH/2-60,440);
        g.drawRoundRect((int)Game.WIDTH/2-150,380,300,100,20,20);
        
        
        g.drawString("Quit",(int)Game.WIDTH/2-40,560);
        g.drawRoundRect((int)Game.WIDTH/2-150,500,300,100,20,20);
            }
        }
        
    }
    
    
    
}

