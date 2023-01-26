package coda.whimsey.common.terrablender;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import terrablender.api.SurfaceRuleManager;

public class WSurfaceRuleData {

    public static SurfaceRules.RuleSource makeRules() {

        return SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(WBiomes.REGAL_MEADOW), SurfaceRuleManager.getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD)),
            SurfaceRules.ifTrue(SurfaceRules.isBiome(WBiomes.STORMY_SEA), SurfaceRuleManager.getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD)),
            SurfaceRules.ifTrue(SurfaceRules.isBiome(WBiomes.ROLLING_HILLS), SurfaceRuleManager.getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}