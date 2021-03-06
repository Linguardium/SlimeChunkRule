package mod.linguardium.slimechunkrule.mixin;

import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.world.GameRules;

@Mixin(GameRules.class)
class GameRulesMixin{

    @Shadow
    private static <T extends GameRules.Rule<T>> GameRules.Key<T> register(String key, GameRules.Category category, GameRules.Type<T> type) {
        throw new NotImplementedException("GameRules mixin failed");
    }

    static{
        register("enableSlimeChunks",GameRules.Category.MOBS, BooleanRuleAccessor.invokeCreate(true));
        register("slimeChunkModifier",GameRules.Category.MOBS, IntegerRuleAccessor.invokeCreate(0));
    }

}