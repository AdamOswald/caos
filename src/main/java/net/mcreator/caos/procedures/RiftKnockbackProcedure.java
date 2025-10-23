package net.mcreator.caos.procedures;

import net.mcreator.caos.CaosModElements;
import net.mcreator.caos.CaosMod;

import java.util.Map;
import java.util.HashMap;

@CaosModElements.ModElement.Tag
public class RiftKnockbackProcedure extends CaosModElements.ModElement {
	public RiftKnockbackProcedure(CaosModElements instance) {
		super(instance, 7);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CaosMod.LOGGER.warn("Failed to load dependency entity for procedure RiftKnockback!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double speed = 0;
		double Yaw = 0;
		if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("caos:empowered_rift_blade").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))) {
			speed = (double) 0.2;
			Yaw = (double) (entity.rotationYaw);
			entity.setMotion(((speed) * Math.cos((((Yaw) + 90) * (Math.PI / 180)))), (entity.getMotion().getY()),
					((speed) * Math.sin((((Yaw) + 90) * (Math.PI / 180)))));
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
