package fr.exolia.auth.mineweb.mc;

import fr.theshark34.openlauncherlib.minecraft.GameInfos;
import fr.theshark34.openlauncherlib.minecraft.GameTweak;

public abstract class MinewebGameTweak {
    public static final String LAUNCHWRAPPER_MAIN_CLASS = "net.minecraft.launchwrapper.Launch";
    public static final GameTweak FORGE = new GameTweak() {
        public String getName() {
            return "FML Tweaker";
        }

        public String getTweakClass(GameInfos infos) {
            return "net.minecraftforge.fml.common.launcher.FMLTweaker";
        }
    };

    public MinewebGameTweak() {
    }

    public abstract String getName();

    public abstract String getTweakClass(GameInfos var1);
}
