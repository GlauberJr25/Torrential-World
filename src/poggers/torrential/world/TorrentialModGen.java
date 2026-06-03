package poggers.torrential.world;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.Script;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.RepLevel;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;

import poggers.torrential.world.systems.Karma;

public class TorrentialModGen {

    public static void trySpawnRainy(SectorAPI sector) {
        MemoryAPI sector_mem = sector.getMemoryWithoutUpdate();
        StarSystemAPI rainy = sector.getStarSystem("Karma");
        if (rainy == null) {
            (new Karma()).generate(sector);
        }
    }

}
