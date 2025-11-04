package net.mcreator.caos.procedures;

import net.mcreator.caos.CaosModElements;
import net.mcreator.caos.CaosMod;

import java.util.Map;

@CaosModElements.ModElement.Tag
public class TestProcedure extends CaosModElements.ModElement {
	public TestProcedure(CaosModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				CaosMod.LOGGER.warn("Failed to load dependency entity for procedure Test!");
			return;
		}
		if(dependencies.get("x") == null) {
			if(!dependencies.containsKey("x"))
				CaosMod.LOGGER.warn("Failed to load dependency x for procedure Test!");
			return;
		}
		if(dependencies.get("y") == null) {
			if(!dependencies.containsKey("y"))
				CaosMod.LOGGER.warn("Failed to load dependency y for procedure Test!");
			return;
		}
		if(dependencies.get("z") == null) {
			if(!dependencies.containsKey("z"))
				CaosMod.LOGGER.warn("Failed to load dependency z for procedure Test!");
			return;
		}
		if(dependencies.get("world") == null) {
			if(!dependencies.containsKey("world"))
				CaosMod.LOGGER.warn("Failed to load dependency world for procedure Test!");
			return;
		}
				Entity entity = (Entity) dependencies.get("entity");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				IWorld world = (IWorld) dependencies.get("world");
		double speed = 0;
double Yaw = 0;
if ((((world.getBlockState(new BlockPos((int)x,(int)(y-1),(int)z)).isSolid())&&((entity.getPersistentData().getDouble("INERTIE"))<=60))&&(&&(entity.isBeingRidden())))) {entity.getPersistentData().putDouble("INERTIE", ((entity.getPersistentData().getDouble("INERTIE"))+1));}if ((((entity.getPersistentData().getDouble("INERTIE"))>=60)&&((entity.isBeingRidden())&&))) {        speed =(double)0.2;
        Yaw =(double)(entity.rotationYaw);
        speed =(double)(        (speed)
*Math.cos(((        (Yaw)
+90)*(Math.PI/180))));
        speed =(double)(        (speed)
*Math.sin(((        (Yaw)
+90)*(Math.PI/180))));
entity.getPersistentData().putDouble("MoveX",         (speed)
);entity.getPersistentData().putDouble("MoveZ",         (speed)
);entity.setMotion((entity.getPersistentData().getDouble("MoveX")),        (speed)
,(entity.getPersistentData().getDouble("MoveZ")));        speed =(double)((entity.rotationYaw)+        (speed)
);
entity.rotationYaw = (float) (        (speed)
);
entity.setRenderYawOffset(entity.rotationYaw);
entity.prevRotationYaw = entity.rotationYaw;
if(entity instanceof LivingEntity) {
    ((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
    ((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
    ((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
}
entity.rotationPitch = (float) ((entity.rotationPitch));}else{if (((!(entity.isBeingRidden()))||((!(world.getBlockState(new BlockPos((int)x,(int)(y-1),(int)z)).isSolid()))&&(!)))) {entity.setMotion((entity.getPersistentData().getDouble("MoveX")),(-0.08),(entity.getPersistentData().getDouble("MoveZ")));}if (((world.getBlockState(new BlockPos((int)x,(int)(y-1),(int)z)).isSolid())&&(!))) {if (((entity.getPersistentData().getDouble("INERTIE"))>=0)) {entity.getPersistentData().putDouble("INERTIE", ((entity.getPersistentData().getDouble("INERTIE"))-1));}if (((entity.getPersistentData().getDouble("INERTIE"))<=0)) {entity.setMotion(0,(-0.08),0);}else{entity.setMotion((entity.getPersistentData().getDouble("MoveX")),(-0.08),(entity.getPersistentData().getDouble("MoveZ")));}}}
	}
}
