
package impalingsimulator;

import java.awt.Graphics;
import java.util.LinkedList;




public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick(){
        for(int i=0;i<object.size();i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    
    public void render(Graphics g){
        
        for(int i=0;i<object.size();i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
        
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void wipePlayer() {
        
        for(int j=0;j<object.size();j++){
            
            GameObject tempObject = object.get(j);
            
             
             if(tempObject.getId()==ID.Player)
         {    object.clear();}
            }
    }
    
    
    
    public void wipeMediumObjects() {
        
        for(int j=0;j<object.size();j++){
            
            GameObject tempObject = object.get(j);
            
             
             if(tempObject.getId()==ID.MediumImpaler)
         {    object.clear();}
            }
    }
    public void wipeCloud() {
        
        for(int j=0;j<object.size();j++){
            
            GameObject tempObject = object.get(j);
            
             
             if(tempObject.getId()==ID.Cloud)
         {    object.clear();}
            }
    }
    
    public void wipeMediumCloud() {
        
        for(int j=0;j<object.size();j++){
            
            GameObject tempObject = object.get(j);
            
             
             if(tempObject.getId()==ID.MediumCloud)
         {    object.clear();}
            }
    }
    
    public void wipeBigCloud() {
        
        for(int j=0;j<object.size();j++){
            
            GameObject tempObject = object.get(j);
            
             
             if(tempObject.getId()==ID.BigCloud)
         {    object.clear();}
            }
    }
    
    public void wipeBabushka() {
        
        for(int j=0;j<object.size();j++){
            
            GameObject tempObject = object.get(j);
            
             
             if(tempObject.getId()==ID.Impalo_One)
         {    object.clear();}
            }
    }
    
    
    
    
}
