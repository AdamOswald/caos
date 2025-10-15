package net.mcreator.caos.procedures;

import net.mcreator.caos.enchantment.RealitySplitterEnchantment;
import net.mcreator.caos.CaosModElements;
import net.mcreator.caos.CaosMod;

import java.util.Map;
import java.util.HashMap;

@CaosModElements.ModElement.Tag
public class RealityRendererProcedure extends CaosModElements.ModElement {
	public RealityRendererProcedure(CaosModElements instance) {
		super(instance, 2);
		MinecraftForge.EVENT_BUS.register(this);
	}
  // Tracks whether we're currently inside executeProcedure to prevent re-entrant damage loops
  private static final ThreadLocal<Boolean> IN_RENDERER = ThreadLocal.withInitial(() -> false);

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CaosMod.LOGGER.warn("Failed to load dependency entity for procedure RealityRenderer!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				CaosMod.LOGGER.warn("Failed to load dependency sourceentity for procedure RealityRenderer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("minecraft:swords").toLowerCase(java.util.Locale.ENGLISH))).contains(
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))) {
			if (EnchantmentHelper.getEnchantmentLevel(RealitySplitterEnchantment.enchantment,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)) == 1+) {
				(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
						.addEnchantment(RealitySplitterEnchantment.enchantment, 1);
				(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
						(int) (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
								)
								+ (6.75 * ((EnchantmentHelper.getEnchantmentLevel(RealitySplitterEnchantment.enchantment,
										((sourceentity instanceof LivingEntity)
												? ((LivingEntity) sourceentity).getHeldItemMainhand()
												: ItemStack.EMPTY)))
										+ 0.5))));
			}
		}
      try {
        IN_RENDERER.set(true);
        entity.attackEntityFrom(event.getSource(),
            (float)((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
              + (6.75 * (EnchantmentHelper.getEnchantmentLevel(RealitySplitterEnchantment.enchantment,
                  ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)) + 0.5))));
      } finally {
        IN_RENDERER.set(false);
      }
}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
          if (IN_RENDERER.get()) {
            return; // avoid re-entrant damage loop
        }
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
