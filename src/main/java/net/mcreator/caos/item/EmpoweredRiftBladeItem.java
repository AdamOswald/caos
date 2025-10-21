
package net.mcreator.caos.item;

import org.omg.CORBA.ObjectHolder;

import net.mcreator.caos.CaosModElements;

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
				return 4f;
			}

			public float getAttackDamage() {
				return 10f;
			}

			public int getHarvestLevel() {
				return 12;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.5f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("empowered_rift_blade"));
	}
}
