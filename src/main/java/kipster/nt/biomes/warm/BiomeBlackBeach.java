package kipster.nt.biomes.warm;

import java.util.Random;

import kipster.nt.biomes.BiomeInit;
import kipster.nt.blocks.BlockInit;
import kipster.nt.world.gen.WorldGenPatches;
import kipster.nt.world.gen.trees.WorldGenTreeShrubOak;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;



public class BiomeBlackBeach extends Biome 
{
	
	protected static final WorldGenLakes LAVA_LAKE_FEATURE = new WorldGenLakes(Blocks.LAVA);
	public BiomeBlackBeach(BiomeProperties properties)
	{	
		super(properties);
        this.spawnableCreatureList.clear();
        this.topBlock = BlockInit.BLACKSAND.getDefaultState();
        this.fillerBlock = BlockInit.BLACKSAND.getDefaultState();
        this.decorator.treesPerChunk = -999;
        this.decorator.deadBushPerChunk = 0;
        this.decorator.reedsPerChunk = 0;
        this.decorator.cactiPerChunk = 0;
    }
	
	 public void decorate(World worldIn, Random rand, BlockPos pos)
     {
         super.decorate(worldIn, rand, pos);
         
        
	      if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA)) {
	           int boulderChance = rand.nextInt(12);
	           if (boulderChance == 0) {
	            int k6 = rand.nextInt(16) + 8;
	            int l = rand.nextInt(16) + 8;
	             BlockPos blockpos = worldIn.getHeight(pos.add(k6, 0, l));
	             LAVA_LAKE_FEATURE.generate(worldIn, rand, blockpos);
	           }
	      }
     }
}

