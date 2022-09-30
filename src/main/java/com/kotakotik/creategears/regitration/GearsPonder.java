package com.kotakotik.creategears.regitration;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import com.simibubi.create.foundation.ponder.PonderRegistry;
import com.simibubi.create.foundation.ponder.PonderTag;
import com.simibubi.create.foundation.ponder.content.ChainDriveScenes;
import com.simibubi.create.foundation.ponder.content.KineticsScenes;
import net.fabricmc.api.ClientModInitializer;

public class GearsPonder implements ClientModInitializer {
    public void onInitializeClient() {
        PonderRegistrationHelper h = new PonderRegistrationHelper(Create.ID);

        h.forComponents(GearsBlocks.GEAR, GearsBlocks.LARGE_GEAR)
                .addStoryBoard("cog/small", KineticsScenes::cogAsRelay)
                .addStoryBoard("cog/large", KineticsScenes::largeCogAsRelay);
        h.forComponents(GearsBlocks.FULLY_ENCASED_CHAIN_DRIVE)
                .addStoryBoard("chain_drive/relay", ChainDriveScenes::chainDriveAsRelay);

        h.forComponents(GearsBlocks.SIMPLE_GEARSHIFT)
                .addStoryBoard("gearshift", KineticsScenes::gearshift);

        PonderRegistry.TAGS.forTag(PonderTag.KINETIC_RELAYS)
                .add(GearsBlocks.GEAR)
                .add(GearsBlocks.LARGE_GEAR)
                .add(GearsBlocks.FULLY_ENCASED_CHAIN_DRIVE)
                .add(GearsBlocks.SIMPLE_GEARSHIFT);
    }
}
