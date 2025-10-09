
package net.mcreator.caos.enchantment;

import org.omg.CORBA.ObjectHolder;

import net.mcreator.caos.CaosModElements;

@CaosModElements.ModElement.Tag
public class RealitySplitterEnchantment extends CaosModElements.ModElement {
	@ObjectHolder("caos:reality_splitter")
	public static final Enchantment enchantment = null;
	public RealitySplitterEnchantment(CaosModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("reality_splitter"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, slots);
		}

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.registries.ObjectHolder;
import net.mcreator.caos.CaosModElements;
@CaosModElements.ModElement.Tag
public class RealitySplitterEnchantment extends CaosModElements.ModElement {
    @ObjectHolder("caos:reality_splitter")
    public static final Enchantment enchantment = null;
    public RealitySplitterEnchantment(CaosModElements instance) {
        super(instance, 1);
    }
    @Override
    public void initElements() {
        elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("reality_splitter"));
    }
    public static class CustomEnchantment extends Enchantment {
        public CustomEnchantment(EquipmentSlotType... slots) {
            super(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, slots);
        }

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 2;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
