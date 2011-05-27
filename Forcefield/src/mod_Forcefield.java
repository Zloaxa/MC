package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;



public class mod_Forcefield extends BaseMod
{

    public mod_Forcefield()
    {
    	ModLoader.SetInGameHook(this, true, true);
    	frame = 0;
        canpress = false;
       
    }

    public String Version()
    {
        return "1.0 (1.5_01)";
    }

    public void OnTickInGame(Minecraft minecraft)
    {
        entityplayer = null;
        currentplayer = null;
    	World world = ModLoader.getMinecraftInstance().theWorld;
    	player = ModLoader.getMinecraftInstance().thePlayer;
        
    	
    		
        	Object aobj[] = world.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(player.posX - (double)4, player.posY - (double)4, player.posZ - (double)4, player.posX + (double)4, player.posY + (double)4, player.posZ + (double)4)).toArray();
            Object aobj1[] = aobj;
            int l = aobj1.length;
			
			for(int j1 = 0; j1 < l; j1++)
            {
                Object obj = aobj1[j1];
        	
                if(obj instanceof EntityLiving)
                {
				
				 currentplayer = (EntityLiving)obj;
				 
				 
				// double diffx = currentplayer.posX - player.posX;
				// double diffz = currentplayer.posZ - player.posZ;
				 
				// currentplayerdistance = Math.sqrt((diffx * diffx) + (diffz * diffz));
			                
			    // if(currentplayerdistance < entityplayerdistance)
			    // {
			    	 
			         entityplayer = currentplayer;
			     //    entityplayerdistance = currentplayerdistance;
			         
			     }
                }
                
                
        	
        //}
			if(entityplayer != null)
			{
			
        
		
    	
    	
        	
                   // if((obj instanceof EntityItem)
                   // {
					//EntityItem entityitem = (EntityItem)obj;
                        //if(entityitem.item.itemID == 20)
                        //{  
						
						//}
                       // continue;
                   // }
                    
					 
					 double delx = entityplayer.posX - player.posX;
					 double delz = entityplayer.posZ - player.posZ;
					 double dely = entityplayer.posY - player.posY + entityplayer.getEyeHeight();
					 
					 
					 
					
					 
					 if(delz > 0 && delx > 0)
					 {
						 theta = Math.toDegrees(-Math.atan(delx / delz));
					 }
					 else if(delz > 0 && delx < 0)
					 {
						 theta = Math.toDegrees(-Math.atan(delx / delz));
					 }
					 else if(delz < 0 && delx > 0)
					 {
						 theta = -90 + Math.toDegrees(Math.atan(delz / delx));
					 }
					 else if(delz < 0 && delx < 0)
					 {
						 theta = 90 + Math.toDegrees(Math.atan(delz / delx));
					 }
					 
					//player.rotationYaw = (float) theta;
					 	//player.addChatMessage("theta = " + theta);
					 	
					 	double distance = Math.sqrt((delz * delz) + (delx * delx));
					 	
					 	double phi = -Math.toDegrees(Math.atan((dely ) / distance));
					 	
					 	
					 	
					// player.rotationPitch = (float) phi;
					 	
					 	//player.addChatMessage("phi = " + phi);
					 	
					 	
					 //if(player.canEntityBeSeen(entityplayer))
					//{
						// ModLoader.getMinecraftInstance().playerController.func_6472_b(player, entityplayer);
					// }
					// }
					 	//if(minecraft.objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY)
				       // {
				          
				              ModLoader.getMinecraftInstance().playerController.func_6472_b(player, entityplayer);
				              player.isSwinging = true;
					
				      //  }
					
					 
					//if(sfinder.get("fswitch").booleanValue() && (obj instanceof EntityLiving))
                  //  {
                   //     AddMobWpt(obj);
                    }
                }

    			
        
    
	
	//private void AddMobWpt(Object obj)
  //  {
  //      int i = sfindermode.get("finder").intValue();
  //      Iterator iterator = MobData.mobList.iterator();
 //       do
    //    {
   //         if(!iterator.hasNext())
   //         {
   //             break;
   //         }
    //        MobData mobdata = (MobData)iterator.next();
    //        if(mobdata.hasNum(i).booleanValue() && mobdata.mobClass.isInstance(obj))
     //       {
    //            EntityLiving entityliving = (EntityLiving)obj;
     //           Waypoint waypoint = new Waypoint((new StringBuilder()).append("ENT_").append(Integer.toString(entityliving.entityId)).toString(), (int)entityliving.posX, (int)entityliving.posZ, true);
     //           waypoint.imgpath = mobdata.mobIcon;
     //           getPts().add(waypoint);
     //       }
     //   } while(true);
   // }

    
    
    EntityPlayerSP player;
    EntityLiving entityplayer;
    EntityLiving currentplayer;
    double entityplayerdistance = 999999999;
    double currentplayerdistance;
    double theta;
    boolean target = false;
    int frame;
    boolean canpress;

}
