package net.mcreator.caos.procedures;

import net.mcreator.caos.item.EmpoweredRiftBladeItem;
import net.mcreator.caos.enchantment.RealitySplitterEnchantment;
import net.mcreator.caos.CaosModElements;
import net.mcreator.caos.CaosMod;

import java.util.Map;
import java.util.HashMap;

@CaosModElements.ModElement.Tag
public class RealityRendererRiftProcedure extends CaosModElements.ModElement {
	public RealityRendererRiftProcedure(CaosModElements instance) {
		super(instance, 8);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CaosMod.LOGGER.warn("Failed to load dependency entity for procedure RealityRendererRift!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				CaosMod.LOGGER.warn("Failed to load dependency sourceentity for procedure RealityRendererRift!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("caos:empowered_rift_blade").toLowerCase(java.util.Locale.ENGLISH))).contains(
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))) {
			if (((EnchantmentHelper.getEnchantmentLevel(RealitySplitterEnchantment.enchantment,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) != 0)) {
				(new ItemStack(EmpoweredRiftBladeItem.block, (int) (1)))
						.setDamage((int) (((new ItemStack(EmpoweredRiftBladeItem.block, (int) (1))).getDamage())
								+ (1.75 * ((EnchantmentHelper.getEnchantmentLevel(RealitySplitterEnchantment.enchantment,
										new ItemStack(EmpoweredRiftBladeItem.block, (int) (1)))) + 1.5))));
			}
		}
		entity.attackEntityFrom(DamageSource.GENERIC,
				(float) (((new ItemStack(EmpoweredRiftBladeItem.block, (int) (1))).getDamage())
						+ (1.75 * ((EnchantmentHelper.getEnchantmentLevel(RealitySplitterEnchantment.enchantment,
								new ItemStack(EmpoweredRiftBladeItem.block, (int) (1)))) + 1.5))));
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
