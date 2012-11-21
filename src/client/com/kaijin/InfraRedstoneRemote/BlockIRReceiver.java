package com.kaijin.InfraRedstoneRemote;

import net.minecraft.src.*;

public class BlockIRReceiver extends Block
{
    public BlockIRReceiver(int i, int j)
    {
        super(i, j, Material.iron);
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileReceiver();
    }

    @Override
    public boolean canProvidePower()
    {
        return true;
    }

    /**
     * Is this block indirectly powering the block on the specified side
     */
    public boolean isIndirectlyPoweringTo(World blocks, int x, int y, int z, int side)
    {
        // TODO: Make this only power in directions parallel to the surface it's attached to?
        TileEntity tile = blocks.getBlockTileEntity(x, y, z);
        if (tile instanceof TileReceiver)
        {
            return ((TileReceiver)tile).isActive();
        }
        return false;
    }

    /**
     * Is this block powering the block on the specified side
     */
    public boolean isPoweringTo(IBlockAccess blocks, int x, int y, int z, int side)
    {
        // TODO: Make this only return true for the block it's attached to, so it acts like levers/buttons.
        TileEntity tile = blocks.getBlockTileEntity(x, y, z);
        if (tile instanceof TileReceiver)
        {
            return ((TileReceiver)tile).isActive();
        }
        return false;
    }

    public void onBlockPlaced(World world, int x, int y, int z, int side)
    {
        // Do this on client as well as server to avoid client-side display glitching
        TileReceiver tile = (TileReceiver)world.getBlockTileEntity(x, y, z);
        if (tile != null)
        {
            tile.orientation = side;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        TileEntity tile = world.getBlockTileEntity(x, y, z);
        if (tile instanceof TileReceiver)
        {
            // Check if the player is wielding a remote.
            ItemStack item = player.getCurrentEquippedItem();
            if (item != null && item.itemID == mod_InfraRedstone.IRRemoteItemID)
            {
                // Power On!
                ((TileReceiver)tile).activate();
                return false;
            }
            else // No remote
            {
                // Prevent GUI pop-up
                if (player.isSneaking())
                {
                    // TODO: Not sure if it'll have a GUI yet. Perhaps to configure how long it turns on for?
                    return false;
                }
            }
        }
        return true;
    }
}
