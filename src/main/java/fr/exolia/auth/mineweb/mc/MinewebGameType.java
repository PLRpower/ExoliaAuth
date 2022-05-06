package fr.exolia.auth.mineweb.mc;

import fr.exolia.auth.mineweb.utils.Get;
import fr.theshark34.openlauncherlib.minecraft.*;

import java.util.ArrayList;
import java.util.List;

public abstract class MinewebGameType {
    public static final GameType V1_8_HIGHER = new GameType() {
        public String getName() {
            return "1.8 or higher";
        }

        public String getMainClass(GameInfos infos) {return "net.minecraft.client.main.Main";}

        public List<String> getLaunchArgs(GameInfos infos, GameFolder folder, AuthInfos authInfos) {
            List<String> arguments = new ArrayList();
            arguments.add("--username=" +  Get.getSession.getUsername());
            arguments.add("--accessToken");
            arguments.add(Get.getSession.getAccessToken());
            if (Get.getSession.getClientToken() != null) {
                arguments.add("--clientToken");
                arguments.add(Get.getSession.getClientToken());
            }
            arguments.add("--version");
            arguments.add(infos.getGameVersion().getName());
            arguments.add("--gameDir");
            arguments.add(infos.getGameDir().toString());
            arguments.add("--assetsDir");
            arguments.add(infos.getGameDir().resolve(GameFolder.FLOW_UPDATER.getAssetsFolder()).toString());
            arguments.add("--assetIndex");
            arguments.add(getAssetIndex(this, infos.getGameVersion()));
            arguments.add("--userProperties");
            arguments.add("{}");
            arguments.add("--uuid");
            arguments.add(Get.getSession.getUuid());
            arguments.add("--userType");
            arguments.add("legacy");
            return arguments;
        }
    };

    private static String getAssetIndex(GameType type, GameVersion gameVersion) {
        String version = gameVersion.getName();
        int first = version.indexOf(46);
        int second = version.lastIndexOf(46);
        if (first != second) {
            version = version.substring(0, version.lastIndexOf(46));
        }
        return version;
    }

    public MinewebGameType() {
    }

    public abstract String getName();

    public abstract String getMainClass(GameInfos var1);

    public abstract List<String> getLaunchArgs(GameInfos var1, GameFolder var2, AuthInfos var3);


}


