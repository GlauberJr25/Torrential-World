package poggers.torrential.world.systems;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.*;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.procgen.StarSystemGenerator;
import com.fs.starfarer.api.impl.campaign.rulecmd.salvage.special.ShipRecoverySpecial;
import com.fs.starfarer.api.impl.campaign.terrain.AsteroidFieldTerrainPlugin;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.impl.campaign.terrain.DebrisFieldTerrainPlugin;
import com.fs.starfarer.api.impl.campaign.terrain.DebrisFieldTerrainPlugin.DebrisFieldParams;
import com.fs.starfarer.api.impl.campaign.terrain.AsteroidBeltTerrainPlugin;

import java.awt.*;

public class Karma {

    public void generate(SectorAPI sector) {
        StarSystemAPI torrentialSystem = sector.createStarSystem("Karma");
        torrentialSystem.getLocation().set(0,0); //bottom centerish

        torrentialSystem.addTag(Tags.THEME_HIDDEN);
        torrentialSystem.addTag(Tags.THEME_SPECIAL);

        PlanetAPI MoistStar = torrentialSystem.initStar("Moist", // unique id for this star
                "star_red_giant", // id in planets.json
                100f, // radius (in pixels at default zoom)
                650); // corona radius, from star edge
        torrentialSystem.setLightColor(new Color(239, 155, 128)); // light color in entire system, affects all entities

        PlanetAPI Avicii = torrentialSystem.addPlanet("Avici", MoistStar, "Avici", "barren", 0, 273, 4977, 157);
        MarketAPI market = Global.getFactory().createMarket(
                "Avicii_market",
                Avicii.getName(), //market display name, usually the planet's name
                1
        );
        Avicii.setMarket(market);
        market.setPrimaryEntity(Avicii);
        market.setHidden(true);
        market.setInvalidMissionTarget(true);
        market.setSurveyLevel(MarketAPI.SurveyLevel.NONE);
        market.setPlanetConditionMarketOnly(false);
        market.addCondition(Conditions.NO_ATMOSPHERE);
        market.addCondition(Conditions.POOR_LIGHT);
        market.addCondition(Conditions.ORE_ULTRARICH);
        market.addCondition(Conditions.RARE_ORE_ULTRARICH);

        SectorEntityToken AB1 = torrentialSystem.addTerrain(Terrain.ASTEROID_BELT,
                new AsteroidBeltTerrainPlugin.AsteroidBeltParams(
                        10, 1000,100,360,360,1,2,"Asteroid Belt"
                ));

    }
}
