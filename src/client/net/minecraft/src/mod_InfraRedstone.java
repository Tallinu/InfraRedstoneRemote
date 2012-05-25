package net.minecraft.src;

import net.minecraft.src.forge.*;
import java.io.File;

import com.kaijin.InfraRedstoneRemote.*;

import net.minecraft.client.Minecraft;

public class mod_InfraRedstone extends NetworkMod
{
    public static int IRReceiverBlockID = 248;
    public static int IRRemoteItemID = 32109;

    static Configuration configuration = new Configuration(new File(Minecraft.getMinecraftDir(), "config/InfraRedstone.cfg"));
    static
    {
        loadProperties();
    }

    public static void loadProperties()
    {
        configuration.load();
        IRReceiverBlockID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("IRReceiver", 248).value);
        IRRemoteItemID = Integer.parseInt(configuration.getOrCreateIntProperty("IRRemote", "ItemID", 32109).value); // TODO check proper way to do this
        configuration.save();
    }

    public static final Block IRReceiver = new BlockIRReceiver(IRReceiverBlockID, 0).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setBlockName("IRReceiver");
    public static final Item IRRemote = new ItemIRRemote(IRRemoteItemID);

    @Override
    public String getVersion()
    {
        return "0.1";
    }
    @Override public boolean clientSideRequired()
    {
        return true;
    }
    @Override public boolean serverSideRequired()
    {
        return false;
    }

    public static mod_InfraRedstone instance;
    public mod_InfraRedstone()
    {
        instance = this;
    }

    public void load()
    {
        MinecraftForge.versionDetect("Infra-Redstone Remote Control", 3, 1, 2);
        //MinecraftForge.registerConnectionHandler(new ConnectionHandler());
        MinecraftForgeClient.preloadTexture("/kaijin/InfraRedstoneRemote/terrain.png");
        ModLoader.registerBlock(IRReceiver);
        ModLoader.registerTileEntity(TileReceiver.class, "IRReceiver");
        ModLoader.addName(IRReceiver, "Infra-Redstone Receiver");
        ModLoader.addName(IRRemote, "Infra-Redstone Remote");
        ModLoader.addRecipe(new ItemStack(IRReceiver, 16), new Object[] {"X", "X", 'X', Block.dirt}); // Testing Recipe
        ModLoader.addRecipe(new ItemStack(IRRemote, 16), new Object[] {"XX", 'X', Block.dirt}); // Testing Recipe
        //ModLoader.addRecipe(new ItemStack(InventoryStocker, 1), new Object[] {"IWI", "PRP", "IWI", 'I', Item.ingotIron, 'W', Block.planks, 'P', Block.pistonBase, 'R', Item.redstone});
        //MinecraftForge.setGuiHandler(this.instance, new GuiHandlerInventoryStocker());
    }
}
