
package net.mcreator.caos.item;

import org.omg.CORBA.ObjectHolder;

import net.mcreator.caos.procedures.RiftKnockbackProcedure;
import net.mcreator.caos.CaosModElements;

import java.util.Map;
import java.util.HashMap;

@CaosModElements.ModElement.Tag
public class EmpoweredRiftBladeItem extends CaosModElements.ModElement {
	@ObjectHolder("caos:empowered_rift_blade")
	public static final Item block = null;
	public EmpoweredRiftBladeItem(CaosModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 10f;
			}

			public int getHarvestLevel() {
				return 12;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.5f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					RiftKnockbackProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("empowered_rift_blade"));
	}
}
