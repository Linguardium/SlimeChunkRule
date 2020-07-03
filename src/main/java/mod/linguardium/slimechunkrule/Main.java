package mod.linguardium.slimechunkrule;

import net.fabricmc.api.ModInitializer;

import net.minecraft.world.GameRules;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "slimechunkrule";
    public static final String MOD_NAME = "SlimeChunkRule";

    public static String ENABLE_SLIME_CHUNKS = "enableSlimeChunks";
    public static String SLIME_CHUNK_MODIFIER = "slimeChunkModifier";

    public static GameRules.Key<GameRules.BooleanRule> ENABLE_SLIME_CHUNKS_KEY = new GameRules.Key<>(ENABLE_SLIME_CHUNKS, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> SLIME_CHUNK_MODIFIER_KEY = new GameRules.Key<>(SLIME_CHUNK_MODIFIER, GameRules.Category.MOBS);


    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}