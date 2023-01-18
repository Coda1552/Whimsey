package coda.whimsicalwinds.terrablender;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import terrablender.api.SurfaceRuleManager;

public class WWSurfaceRuleData {

    public static SurfaceRules.RuleSource makeRules() {

        return SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(WWBiomes.REGAL_MEADOW), SurfaceRuleManager.getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD)),
            SurfaceRules.ifTrue(SurfaceRules.isBiome(WWBiomes.STORMY_SEA), SurfaceRuleManager.getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD)),
            SurfaceRules.ifTrue(SurfaceRules.isBiome(WWBiomes.ROLLING_HILLS), SurfaceRuleManager.getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}