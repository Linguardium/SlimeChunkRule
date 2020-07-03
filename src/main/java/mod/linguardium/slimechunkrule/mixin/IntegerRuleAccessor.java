package mod.linguardium.slimechunkrule.mixin;

import net.minecraft.world.GameRules;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.IntRule.class)
public interface IntegerRuleAccessor {

    @Invoker
    public static GameRules.Type<GameRules.IntRule> invokeCreate(int defaultValue) {
        throw new NotImplementedException("Mixin failed");
     }

}