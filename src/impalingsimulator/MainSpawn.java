
package impalingsimulator;

import java.util.Random;



public class MainSpawn {
    private Handler handler;
    private MainHUD hud;
    private int spawnTimer=0;
    private int tutorialTimer=0;
    private int cinematicTimer=110;
    public static boolean playerSpawned=false;
    private Random r;
    
    
    public MainSpawn(Handler handler,MainHUD hud){
        this.handler=handler;
        this.hud=hud;
        
        
    }
    
    
    public void TimerReset(){
        spawnTimer=0;
        cinematicTimer=110;
        Game.cinematicDone=false;
        Game.halfCinematic=false;
    }
    public void TutorialTimerReset(){
        tutorialTimer=0;
    }
    
    public void tick(){
        if(Game.cinematicEnabled==true){
            if(Game.cinematicDone==true){
            spawnTimer++;
            tutorialTimer++;}
            else if(Game.cinematicDone==false){
                Game.fallenScore=0;
                if(cinematicTimer>0){
                    PlayerHand.leftHandDamaged=false;
                    PlayerHand.rightHandDamaged=false;
                    PlayerLeg.leftLegDamaged=false;
                    PlayerLeg.rightLegDamaged=false;
                    cinematicTimer--;
                }
                else if(cinematicTimer<=0){
                    Game.cinematicDone=true;
                }
                
            }
            
        }
        else if(Game.cinematicEnabled==false){
            spawnTimer++;
        }
            
            
        if(Game.gameState==STATE.FreeFall){
            
            if(Game.partsRebuild==true){
            
            
            handler.addObject(new PlayerHand((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerLeftHand,handler));
            handler.addObject(new PlayerHand((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerRightHand,handler));
            handler.addObject(new PlayerLeg((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerLeftLeg,handler));
            handler.addObject(new PlayerLeg((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerRightLeg,handler));
            Game.partsRebuild=false;
            }
            
            
            if(cinematicTimer==109){
            handler.addObject(new Player((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.Player,handler));
            handler.addObject(new PlayerHand((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerLeftHand,handler));
            handler.addObject(new PlayerHand((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerRightHand,handler));
            handler.addObject(new PlayerLeg((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerLeftLeg,handler));
            handler.addObject(new PlayerLeg((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerRightLeg,handler));
            
            handler.addObject(new Player(100,(int)Game.HEIGHT/3-25,100,1,ID.Vlad,handler));
            handler.addObject(new Player(0,(int)Game.HEIGHT/3-25,100,1,ID.Soldier,handler));
            handler.addObject(new Impalers(10,(int)Game.HEIGHT/3+125,100,1,ID.Platform,handler));
            
            
            
            }
            if(cinematicTimer==45){
                Game.halfCinematic=true;
            }
            
            if(spawnTimer==1){
            Game.fallenScore=0;    
            //handler.addObject(new Player((int)Game.WIDTH/2,(int)Game.HEIGHT/3,100,1,ID.Player,handler));
            
            if(Game.cinematicEnabled==false){
            handler.addObject(new Player((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.Player,handler));
            handler.addObject(new PlayerHand((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerLeftHand,handler));
            handler.addObject(new PlayerHand((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerRightHand,handler));
            handler.addObject(new PlayerLeg((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerLeftLeg,handler));
            handler.addObject(new PlayerLeg((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerRightLeg,handler));    
            }
            
            handler.addObject(new Cloud(180,(int)Game.HEIGHT+200,100,1,ID.Cloud,handler));
            handler.addObject(new Cloud(230,(int)Game.HEIGHT+260,100,1,ID.Cloud,handler));
            handler.addObject(new Cloud(50,(int)Game.HEIGHT+180,100,1,ID.Cloud,handler));
            handler.addObject(new Cloud(90,(int)Game.HEIGHT+130,100,1,ID.Cloud,handler));
            handler.addObject(new Impalers(500,(int)Game.HEIGHT+200,100,1,ID.SmallImpaler,handler));
            handler.addObject(new Impalers(100,(int)Game.HEIGHT+200,100,1,ID.MediumImpaler,handler));
            handler.addObject(new Impalers(20,(int)Game.HEIGHT+450,100,1,ID.BigImpaler,handler));
            // 100 in loc de 20 pe axa X ^
            
            handler.addObject(new Coin(250,(int)Game.HEIGHT+600,100,1,ID.Coin,handler));
            handler.addObject(new Coin(200,(int)Game.HEIGHT+500,100,1,ID.Coin,handler));
            handler.addObject(new Coin(310,(int)Game.HEIGHT+800,100,1,ID.Coin,handler));
            handler.addObject(new Coin(100,(int)Game.HEIGHT+400,100,1,ID.Coin,handler));
            handler.addObject(new Coin(170,(int)Game.HEIGHT+720,100,1,ID.Coin,handler));
            
            
            
            }
            
            
        }
        
        else if(Game.gameState==STATE.Tutorial){
            
            
            if(cinematicTimer==109){
            handler.addObject(new Player((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.Player,handler));
            handler.addObject(new PlayerHand((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerLeftHand,handler));
            handler.addObject(new PlayerHand((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerRightHand,handler));
            handler.addObject(new PlayerLeg((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerLeftLeg,handler));
            handler.addObject(new PlayerLeg((int)Game.WIDTH/2-50,(int)Game.HEIGHT/3,100,1,ID.PlayerRightLeg,handler));
            
            handler.addObject(new Player(100,(int)Game.HEIGHT/3-25,100,1,ID.Vlad,handler));
            handler.addObject(new Impalers(10,(int)Game.HEIGHT/3+125,100,1,ID.Platform,handler));
            
            
            
            }
            if(cinematicTimer==45){
                Game.halfCinematic=true;
            }
            
            if(tutorialTimer==1){
            Game.fallenScore=0;    
            //handler.addObject(new Player((int)Game.WIDTH/2,(int)Game.HEIGHT/3,100,1,ID.Player,handler));
            
            handler.addObject(new Cloud(180,(int)Game.HEIGHT+200,100,1,ID.Cloud,handler));
            handler.addObject(new Cloud(230,(int)Game.HEIGHT+260,100,1,ID.Cloud,handler));
            handler.addObject(new Cloud(50,(int)Game.HEIGHT+180,100,1,ID.Cloud,handler));
            handler.addObject(new Cloud(90,(int)Game.HEIGHT+130,100,1,ID.Cloud,handler));
            handler.addObject(new Impalers(500,(int)Game.HEIGHT+200,100,1,ID.SmallImpaler,handler));
            handler.addObject(new Impalers(100,(int)Game.HEIGHT+200,100,1,ID.MediumImpaler,handler));
            handler.addObject(new Impalers(20,(int)Game.HEIGHT+450,100,1,ID.BigImpaler,handler));
            // 100 in loc de 20 pe axa X ^
            
            handler.addObject(new Coin(250,(int)Game.HEIGHT+600,100,1,ID.Coin,handler));
            handler.addObject(new Coin(200,(int)Game.HEIGHT+500,100,1,ID.Coin,handler));
            handler.addObject(new Coin(310,(int)Game.HEIGHT+800,100,1,ID.Coin,handler));
            handler.addObject(new Coin(100,(int)Game.HEIGHT+400,100,1,ID.Coin,handler));
            handler.addObject(new Coin(170,(int)Game.HEIGHT+720,100,1,ID.Coin,handler));
            
            
            
            }
            
            
        }
        
        
        else if(Game.gameState==STATE.PlayerMenu && playerSpawned!=true){
         handler.addObject(new Player((int)Game.WIDTH/2-10,(int)Game.HEIGHT/2,100,1,ID.Player,handler));
         playerSpawned=true;
        }
    }
    
}
