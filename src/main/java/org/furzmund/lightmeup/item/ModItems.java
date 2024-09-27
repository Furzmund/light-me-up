package org.furzmund.lightmeup.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.furzmund.lightmeup.LightMeUp;


public class ModItems {

    public static final Item TORCH_ARROW = registerItem("torch_arrow", new Item(new FabricItemSettings()));

    private static void addItemsToCombatTab(FabricItemGroupEntries entries) {
        entries.add(TORCH_ARROW);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(LightMeUp.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTab);
    }
}
