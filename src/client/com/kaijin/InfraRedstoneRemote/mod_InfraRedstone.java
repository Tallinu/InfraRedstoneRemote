package com.kaijin.InfraRedstoneRemote;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

import java.io.File;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "InfraRedstoneRemote", name = "InfraRedstoneRemote", version = "a.1", dependencies = "")
@NetworkMod(clientSideRequired = true, channels = {"IRRemote"}, packetHandler = PacketHandler.class)
public class mod_InfraRedstone implements IGuiHandler
{
	@SidedProxy(clientSide = "com.kaijin.InfraRedstoneRemote.ClientProxy", serverSide = "com.kaijin.InfraRedstoneRemote.CommonProxy")
	public static CommonProxy proxy;

	@Instance("InfraRedstoneRemote")
	public static mod_InfraRedstone instance;

	public static int IRReceiverBlockID = 248;
	public static int IRRemoteItemID = 32109;

	public static final Block IRReceiver = new BlockIRReceiver(IRReceiverBlockID, 0).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setBlockName("IRReceiver");
	public static final Item IRRemote = new ItemIRRemote(IRRemoteItemID);

	@PreInit
	public static void preInit(FMLPreInitializationEvent event)
	{
		try
		{
			Configuration configuration = new Configuration(event.getSuggestedConfigurationFile());
			configuration.load();
			IRReceiverBlockID = configuration.getBlock("IRReceiver", IRReceiverBlockID).getInt();
			IRRemoteItemID = configuration.getItem(configuration.CATEGORY_ITEM, "IRRemote", IRRemoteItemID).getInt();
			configuration.save();
		}
		catch (Exception e)
		{
			FMLLog.getLogger().info("[InfraRedstoneRemote] Error while trying to access configuration!");
			throw new RuntimeException(e);
		}
	}

	@Init
	public void load(FMLInitializationEvent event)
	{
		GameRegistry.registerBlock(IRReceiver);

		GameRegistry.registerTileEntity(TileReceiver.class, "kaijin.IRReceiver");

		NetworkRegistry.instance().registerGuiHandler(instance, instance);

		LanguageRegistry.instance().addName(IRReceiver, "Infra-Redstone Receiver");
		LanguageRegistry.instance().addName(IRRemote, "Infra-Redstone Remote");
	}

	@PostInit
	public void modsLoaded(FMLPostInitializationEvent event)
	{
		GameRegistry.addRecipe(new ItemStack(IRReceiver, 16), new Object[] {"X", "X", 'X', Block.dirt}); // Testing Recipe
		GameRegistry.addRecipe(new ItemStack(IRRemote, 16), new Object[] {"XX", 'X', Block.dirt}); // Testing Recipe
	}

	/*
	 * IGuiHandler
	 */

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (!world.blockExists(x, y, z)) return null;

		TileEntity tile = world.getBlockTileEntity(x, y, z);

/*		if (ID == 1 && tile instanceof TEChargingBench)
		{
			return new ContainerChargingBench(player.inventory, (TEChargingBench)tile);
		}
		else if (ID == 2 && tile instanceof TEAdvEmitter)
		{
			return new ContainerAdvEmitter((TEAdvEmitter)tile);
		}
*/
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (!world.blockExists(x, y, z)) return null;

		TileEntity tile = world.getBlockTileEntity(x, y, z);

/*		if (ID == 1 && tile instanceof TEChargingBench)
		{
			return new GuiChargingBench(player.inventory, (TEChargingBench)tile);
		}
		else if (ID == 2 && tile instanceof TEAdvEmitter)
		{
			return new GuiAdvEmitter((TEAdvEmitter)tile);
		}
*/
		return null;
	}
}
