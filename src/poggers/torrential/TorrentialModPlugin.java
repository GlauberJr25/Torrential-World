package poggers.torrential;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import exerelin.campaign.SectorManager;

import poggers.torrential.world.TorrentialModGen;

public class TorrentialModPlugin extends BaseModPlugin {

//    private static void initMyMod() {
//        new TorrentialModGen().generate(Global.getSector());
//    }

    // call order: onNewGame -> onNewGameAfterProcGen -> onNewGameAfterEconomyLoad -> onEnabled -> onNewGameAfterTimePass -> onGameLoad

    public void onGameLoad(boolean newGame) {
        SectorAPI sector = Global.getSector();
        MemoryAPI sector_mem = Global.getSector().getMemoryWithoutUpdate();

        TorrentialModGen.trySpawnRainy(sector);
    }
    @Override
    public void onNewGame() {
        Global.getLogger(this.getClass()).info("Hooray, Torrential plugin jar is loaded!");
        //initMyMod();

        boolean isNexerelinEnabled = Global.getSettings().getModManager().isModEnabled("nexerelin");

//        if (!isNexerelinEnabled || SectorManager.getManager().isCorvusMode()) {
//            new TorrentialModGen().generate(Global.getSector());
//            // You can add more methods from ModPlugin here. Press Control-O in IntelliJ to see options.
//        }
    }
}

