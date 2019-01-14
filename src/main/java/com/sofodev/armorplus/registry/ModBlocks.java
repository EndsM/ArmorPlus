/*
 * Copyright (c) Sokratis Fotkatzikis (sokratis12GR) 2015-2019.
 */

package com.sofodev.armorplus.registry;

import com.sofodev.armorplus.blocks.benches.Benches;
import com.sofodev.armorplus.blocks.benches.BlockBench;
import com.sofodev.armorplus.blocks.castle.BrickColor;
import com.sofodev.armorplus.blocks.castle.base.BlockStoneBrick;
import com.sofodev.armorplus.blocks.castle.base.BlockStoneBrickCorner;
import com.sofodev.armorplus.blocks.castle.base.BlockStoneBrickTower;
import com.sofodev.armorplus.blocks.castle.base.BlockStoneBrickWall;
import com.sofodev.armorplus.blocks.dungeon.BlockDungeonEnder;
import com.sofodev.armorplus.blocks.dungeon.EnderType;
import com.sofodev.armorplus.blocks.lava.*;
import com.sofodev.armorplus.blocks.normal.BlockCompressedObsidian;
import com.sofodev.armorplus.blocks.special.BlockTrophy;
import com.sofodev.armorplus.blocks.special.Trophy;
import com.sofodev.armorplus.blocks.v2.BlockMetal;

import static com.sofodev.armorplus.blocks.benches.Benches.*;
import static com.sofodev.armorplus.blocks.castle.BrickColor.*;
import static com.sofodev.armorplus.blocks.dungeon.EnderType.*;
import static com.sofodev.armorplus.blocks.lava.BlockLavaMaterial.LavaMaterial.*;
import static com.sofodev.armorplus.blocks.special.Trophy.*;
import static com.sofodev.armorplus.blocks.v2.Metals.ELECTRICAL;
import static com.sofodev.armorplus.blocks.v2.Metals.STEEL;
import static java.util.Arrays.setAll;

/**
 * @author Sokratis Fotkatzikis
 **/
public class ModBlocks {

    public static BlockCrystalOre blockCrystalOre = new BlockCrystalOre();
    public static BlockCompressedObsidian blockCompressedObsidian = new BlockCompressedObsidian();
    public static BlockLavaCactus blockLavaCactus = new BlockLavaCactus();
    public static BlockMetal steelBlock = new BlockMetal(STEEL);
    public static BlockMetal electricalBlock = new BlockMetal(ELECTRICAL);
    public static BlockLavaNetherBrick blockLavaNetherBrick = new BlockLavaNetherBrick();
    public static Benches[] benchTypes = new Benches[]{WORKBENCH, HIGH_TECH_BENCH, ULTI_TECH_BENCH, CHAMPION_BENCH};
    public static BlockBench[] benches = new BlockBench[4];
    public static BrickColor[] stoneBrickTypes = new BrickColor[]{
        WHITE, RED, BLACK, BLUE, GREEN, YELLOW, PURPLE
    };
    public static BlockStoneBrick[] stoneBricks = new BlockStoneBrick[7];
    public static BlockStoneBrickTower[] stoneBrickTowers = new BlockStoneBrickTower[7];
    public static BlockStoneBrickCorner[] stoneBrickCorners = new BlockStoneBrickCorner[7];
    public static BlockStoneBrickWall[] stonebrickWalls = new BlockStoneBrickWall[7];
    public static BlockLavaInfuser lavaInfuser = new BlockLavaInfuser("lava_infuser", false);
    public static BlockLavaInfuser lavaInfuserInfusing = new BlockLavaInfuser("lava_infuser_infusing", true);
    public static BlockLavaMaterial blockLavaCrystal = new BlockLavaMaterial(LAVA_CRYSTAL);
    public static BlockLavaMaterial blockInfusedLavaCrystal = new BlockLavaMaterial(INFUSED_LAVA_CRYSTAL);
    public static BlockLavaMaterial blockCompressedLavaCrystal = new BlockLavaMaterial(COMPRESSED_LAVA_CRYSTAL);
    public static BlockLavaMaterial blockCompressedInfusedLavaCrystal = new BlockLavaMaterial(COMPRESSED_INFUSED_LAVA_CRYSTAL);
    public static BlockLavaMaterial blockLavaInfusedObsidian = new BlockLavaMaterial(LAVA_INFUSED_OBSIDIAN);
    //  public static BlockRitualAltar ritualAltar = new BlockRitualAltar();
    public static EnderType[] enderTypes = new EnderType[]{
        ENDER_STONE, ENDER_STONE_BRICKS, ENDER_PILLAR, ENDER_GLOWSTONE, ENDER_FLOOR_1, ENDER_FLOOR_2, ENDER_STONE_TRAP
    };
    public static BlockDungeonEnder[] enderBlocks = new BlockDungeonEnder[7];
    public static BlockTrophy[] trophies = new BlockTrophy[8];
    public static Trophy[] types = new Trophy[]{
        ANY, ELDER_GUARDIAN, WITHER_BOSS, ENDER_DRAGON, SKELETAL_KING, GUARDIAN_OVERLORD, DEMONIC_DRAGON, THE_LORD_OF_EVERYTHING
    };
    // public static BlockBTMMoon blockBTMMoon = new BlockBTMMoon();

    public static void registerBlocks() {
        setAll(benches, type -> new BlockBench(benchTypes[type]));
        setAll(stoneBricks, type -> new BlockStoneBrick(stoneBrickTypes[type]));
        setAll(stoneBrickTowers, type -> new BlockStoneBrickTower(stoneBrickTypes[type]));
        setAll(stoneBrickCorners, type -> new BlockStoneBrickCorner(stoneBrickTypes[type], stoneBricks[type].getDefaultState()));
        setAll(stonebrickWalls, type -> new BlockStoneBrickWall(stoneBricks[type]));
        setAll(enderBlocks, type -> new BlockDungeonEnder(enderTypes[type]));
        setAll(trophies, type -> new BlockTrophy(types[type]));
    }
}