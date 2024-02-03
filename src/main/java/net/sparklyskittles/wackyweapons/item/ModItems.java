package net.sparklyskittles.wackyweapons.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sparklyskittles.wackyweapons.WackyWeapons;

public class ModItems {
    public static final Item SLIME_HAMMER = registerItem("slime_hammer",
            new SlimeHammerSword(ModToolMaterial.SLIME, 3, -2f, new FabricItemSettings()));
    private static void addItIT(FabricItemGroupEntries entries) {
        entries.add(SLIME_HAMMER);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WackyWeapons.MOD_ID, name), item);
    }
    public static void registerModItems() {
        WackyWeapons.LOGGER.info("Registering Mod Items for " + WackyWeapons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItIT);
    }
}
