package net.creeper39x.firingline;

import net.minecraft.world.gen.feature.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.FlatGenerationSettings;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.FlatGeneratorSettings;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Firingline.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGenEventHandler {
    @SubscribeEvent
    public static void onInitMapGen(InitMapGenEvent event) {
        if (event.getGenerator() instanceof FlatChunkGenerator) {
            FlatChunkGenerator chunkGenerator = (FlatChunkGenerator) event.getGenerator();
            FlatGenerationSettings settings = chunkGenerator.getSettings();
            settings.getStructures().removeIf(structure -> {
                int islandSize = structure.getBoundingBox().getXSize() * structure.getBoundingBox().getZSize();
                return islandSize < 30;
            });
        }
    }
}