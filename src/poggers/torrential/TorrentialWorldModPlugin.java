package poggers.torrential;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import exerelin.campaign.SectorManager;
import poggers.torrential.world.TorrentialModGen;

public class TorrentialWorldModPlugin extends BaseModPlugin {

    // call order: onNewGame -> onNewGameAfterProcGen -> onNewGameAfterEconomyLoad -> onEnabled -> onNewGameAfterTimePass -> onGameLoad

    public void onGameLoad(boolean newGame) {
        SectorAPI sector = Global.getSector();
        MemoryAPI sector_mem = Global.getSector().getMemoryWithoutUpdate();

        TorrentialModGen.trySpawnKarma(sector);
    }

    @Override
    public void onNewGame() {
        Global.getLogger(this.getClass()).info("Hooray, Torrential World plugin jar is loaded!");

    }

}
