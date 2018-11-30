
package impalingsimulator;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;



public class KeyboardControl extends KeyAdapter{
    
    private Handler handler;
    private boolean[] keyDown= new boolean[8];
    private Game Game;
    //private HUD hud;
    private Random r = new Random();
    
    public KeyboardControl(Handler handler,Game Game){
        this.handler = handler;
        this.Game = Game;
        for(int i=0;i<8;i++)
        {
            keyDown[i]=false;
        }
        
        
        
    }
    
    
    
    
    
 public void keyPressed(KeyEvent e){
     
     int key = e.getKeyCode();
     System.out.println(key);
     //if(key == KeyEvent.VK_SPACE)
     //{handler.addObject(new Player(0,0,ID.Player,Handler handler));}
     
     for(int i=0; i < handler.object.size(); i++){
         GameObject tempObject = handler.object.get(i);
         
         if(tempObject.getId() == ID.Player){
             //Player 1
             
                 
                     //if(key == KeyEvent.VK_SPACE) {tempObject.setVelY(-4);Player.isJumping=true; keyDown[0]=true;}
                     
                     
                     /*
                     //GET DOWN PLAYER
                     if(key == KeyEvent.VK_DOWN) 
                     {if((tempObject.getY()<Game.HEIGHT-170 && tempObject.objectStatus==1) || (tempObject.getY()<Game.HEIGHT-150 && tempObject.objectStatus==2))
                     {tempObject.setVelY(4); keyDown[1]=true;}
                     }
                     */
                     if(Game.gameState==STATE.FreeFall){
                     if(Game.cinematicDone==true || !Game.cinematicEnabled==true){
                     if(key == KeyEvent.VK_LEFT)
                         {
                         if(Game.cannotAdvance[1]==false){
                         tempObject.setVelX(-6);
                         //keyDown[2]=true;
                         }
                         
                     }
                     if(key == KeyEvent.VK_RIGHT)
                     {
                         if(Game.cannotAdvance[0]==false){
                         tempObject.setVelX(6);
                         //keyDown[3]=true;
                         }
                         
                     }
                     
                     
                     }
                     }
                     
                     else if(Game.gameState==STATE.Tutorial){
                      if(key == KeyEvent.VK_LEFT)
                         {
                         
                         tempObject.setVelX(-6);
                          
                         
                         
                     }
                     if(key == KeyEvent.VK_RIGHT)
                     {
                         
                         tempObject.setVelX(6);
                         
                         
                         
                     }   
                     }
                     
                     if(key == KeyEvent.VK_ESCAPE)
                         {
                         if(Game.gameState==STATE.FreeFall || Game.gameState==STATE.Tutorial){
                             Game.SaveGame();
                             PlayerHand.leftHandDamaged=false;
                             PlayerHand.rightHandDamaged=false;
                             PlayerLeg.leftLegDamaged=false;
                             PlayerLeg.rightLegDamaged=false;
                             Game.gameState=STATE.MainMenu;
                             
                         }
                         
                         
                     }
                     
                     if(key == KeyEvent.VK_C)
                         {
                         if(Game.gameState==STATE.FreeFall){
                             Game.SaveGame();
                             Game.gameState=STATE.CheatMenu;
                             
                         }
                         else if(Game.gameState==STATE.CheatMenu){
                             
                             Game.gameState=STATE.FreeFall;
                             
                         }
                         
                         
                     }
                     
                     if(key == KeyEvent.VK_M)
                         {
                         if(Game.gameState==STATE.FreeFall){
                             Game.SaveGame();
                             Game.gameState=STATE.Shop;
                             
                         }
                         else if(Game.gameState==STATE.Shop){
                             Game.SaveGame();
                             Game.gameState=STATE.FreeFall;
                             
                         }
                         
                         
                     }
                     
                     
                 }}}
   
 
 public void keyReleased(KeyEvent e){
     int key = e.getKeyCode();
     System.out.println(key);
     
     for(int i=0; i < handler.object.size(); i++){
         GameObject tempObject = handler.object.get(i);
         
         if(tempObject.getId() == ID.Player){
             //Player 1
             if(key == KeyEvent.VK_SPACE) keyDown[0]=false;//tempObject.setVelY(0);
             if(key == KeyEvent.VK_DOWN) keyDown[1]=false;//tempObject.setVelY(0);
             if(key == KeyEvent.VK_LEFT) keyDown[2]=false;//tempObject.setVelX(0);
             if(key == KeyEvent.VK_RIGHT) keyDown[3]=false;//tempObject.setVelX(0);
             
             
             
             if(key == KeyEvent.VK_SHIFT){
                 if(tempObject.objectStatus==1){
                 tempObject.objectStatus=2;}
                 else if(tempObject.objectStatus==2){
                 tempObject.objectStatus=1;}
             }
             
             if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
             if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
             
             
             
         }
         
     }
     
     
 } 
   

 
    
    
}
