package poggers.torrential.world;

import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import poggers.torrential.world.systems.Karma;

public class TorrentialModGen {
    public static void trySpawnKarma(SectorAPI sector) {
        MemoryAPI sector_mem = sector.getMemoryWithoutUpdate();
        StarSystemAPI rain = sector.getStarSystem("Karma");
        if (rain == null) {
            (new Karma()).generate(sector);
        }
    }
}
