package mod.linguardium.slimechunkrule.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;

import static mod.linguardium.slimechunkrule.Main.ENABLE_SLIME_CHUNKS_KEY;
import static mod.linguardium.slimechunkrule.Main.SLIME_CHUNK_MODIFIER_KEY;

@Mixin(SlimeEntity.class)
public class SlimeEntityMixin extends MobEntity {

    protected SlimeEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }
/*


    modifies the values in this line in SlimeEntity.class:

    boolean bl = ChunkRandom.getSlimeRandom(chunkPos.x, chunkPos.z, ((ServerWorldAccess)world).getSeed(), 987234911L).nextInt(X) == Y;

  */

    // This is X
    @ModifyConstant(method="canSpawn",constant=@Constant(intValue = 10,log=true, ordinal = 0))
    private static int setChance(int i, EntityType<SlimeEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        int chance = world.getLevelProperties().getGameRules().getInt(SLIME_CHUNK_MODIFIER_KEY);
        if (chance > 0)
            return chance;
        return 10;

    }

    // This is Y
    @ModifyVariable(method = "canSpawn", at = @At("STORE"), name = "bl")
    private static boolean setMatchTooHigh(boolean bl, EntityType<SlimeEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        boolean enabled = world.getLevelProperties().getGameRules().getBoolean(ENABLE_SLIME_CHUNKS_KEY);
        if (enabled) {
            return bl;
        }
        return false;
    }
}
