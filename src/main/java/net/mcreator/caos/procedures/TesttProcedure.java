package net.mcreator.caos.procedures;

import net.mcreator.caos.CaosModElements;
import net.mcreator.caos.CaosMod;

import java.util.Map;

@CaosModElements.ModElement.Tag
public class TesttProcedure extends CaosModElements.ModElement {
	public TesttProcedure(CaosModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				CaosMod.LOGGER.warn("Failed to load dependency entity for procedure Testt!");
			return;
		}
				Entity entity = (Entity) dependencies.get("entity");
		double speed = 0;
double Yaw = 0;
if ((entity.isPassenger())) {        speed =(double)0.2;
        Yaw =(double)(entity.rotationYaw);
        speed =(double)(        (speed)
*Math.cos(((        (Yaw)
+90)*(Math.PI/180))));
        speed =(double)(        (speed)
*Math.sin(((        (Yaw)
+90)*(Math.PI/180))));
if () {if ((((entity.rotationPitch)<(-67.5))&&((entity.rotationPitch)>(-90)))) {        speed =(double)1;
}else if ((((entity.rotationPitch)<(-45))&&((entity.rotationPitch)>(-67.5)))) {        speed =(double)0.6;
}else if ((((entity.rotationPitch)<(-22.5))&&((entity.rotationPitch)>(-45)))) {        speed =(double)0.25;
}else if ((((entity.rotationPitch)>(-22.5))&&((entity.rotationPitch)<22.5))) {        speed =(double)0;
}else if ((((entity.rotationPitch)>22.5)&&((entity.rotationPitch)<45))) {        speed =(double)(-0.1);
}else if ((((entity.rotationPitch)>45)&&((entity.rotationPitch)<67.5))) {        speed =(double)(-0.25);
}else if ((((entity.rotationPitch)>67.5)&&((entity.rotationPitch)<90))) {        speed =(double)(-0.5);
}}}else{}if ((entity.isBeingRidden())) {entity.getPersistentData().putDouble("MoveX",         (speed)
);entity.getPersistentData().putDouble("MoveZ",         (speed)
);entity.setMotion((entity.getPersistentData().getDouble("MoveX")),        (speed)
,(entity.getPersistentData().getDouble("MoveZ")));}else{entity.setMotion((entity.getPersistentData().getDouble("MoveX")),(-0.08),(entity.getPersistentData().getDouble("MoveZ")));}
	}
}
