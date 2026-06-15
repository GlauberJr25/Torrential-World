package poggers.torrential.world.systems;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.characters.ImportantPeopleAPI;
import com.fs.starfarer.api.impl.campaign.ids.*;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.procgen.StarSystemGenerator;
import com.fs.starfarer.api.impl.campaign.rulecmd.salvage.special.ShipRecoverySpecial;
import com.fs.starfarer.api.impl.campaign.terrain.AsteroidBeltTerrainPlugin;
import com.fs.starfarer.api.impl.campaign.terrain.AsteroidFieldTerrainPlugin;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.impl.campaign.terrain.DebrisFieldTerrainPlugin;
import com.fs.starfarer.api.impl.campaign.terrain.DebrisFieldTerrainPlugin.DebrisFieldParams;

public class Karma {
    public void generate(SectorAPI sector) {
        StarSystemAPI rainySystem = sector.createStarSystem("Karma");
        rainySystem.getLocation().set(0, 0); //middle

        rainySystem.addTag(Tags.THEME_HIDDEN);
        rainySystem.addTag(Tags.THEME_SPECIAL);
        rainySystem.addTag(Tags.NOT_RANDOM_MISSION_TARGET);

        PlanetAPI rainStar = rainySystem.initStar("thunder_star", // unique id for this star
                "star_red_giant", // id in planets.json
                100f, // radius (in pixels at default zoom)
                350); // corona radius, from star edge
        rainySystem.setLightColor(new Color(239, 155, 128)); // light color in entire system, affects all entities

        PlanetAPI Avichi = rainySystem.addPlanet("Avichi", rainStar, "Avichi", "barren", 0, 273, 4977, 157);
        MarketAPI marketA = Global.getFactory().createMarket(
                "Avichi_market",
                Avichi.getName(), //market display name, usually the planet's name
                1
        );
        marketA.isPlanetConditionMarketOnly();
        marketA.addCondition(Conditions.NO_ATMOSPHERE);
        marketA.addCondition(Conditions.POOR_LIGHT);
        marketA.addCondition(Conditions.ORE_ULTRARICH);
        marketA.addCondition(Conditions.RARE_ORE_ULTRARICH);

        SectorEntityToken rainAB2 = rainySystem.addTerrain(Terrain.ASTEROID_BELT,
                new AsteroidBeltTerrainPlugin.AsteroidBeltParams(40, Avichi.getRadius() + 200f, 258, 360, 360,8,16,"Asteroid Belt")); // null for default name
        rainAB2.setCircularOrbit(Avichi, 0, 0, 360);
        rainySystem.addRingBand(Avichi, "misc", "rings_asteroids0", 256.0F, 3, Color.white, 256.0F, Avichi.getRadius() + 200f, 360.0F);


        //Xaphar.addAsteroidBelt(argonianStar, 150, 2500.0F, 515.0F, 351.0F, 400.0F, "asteroid_belt", "Outer Ring");
        //Xaphar.addRingBand(argonianStar, "misc", "rings_asteroids0", 512.0F, 3, Color.white, 512.0F, 2500.0F, 350.0F);

        rainySystem.autogenerateHyperspaceJumpPoints(false, true);
    }
}