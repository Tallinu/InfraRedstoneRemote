package com.kaijin.InfraRedstoneRemote;

import net.minecraft.src.*;

public class BlockIRReceiver extends Block
{
    public BlockIRReceiver(int i, int j)
    {
        super(i, j, Material.ground);
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    @Override
    public TileEntity getTileEntity(int metadata)
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
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player)
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
                    return false;
                }
            }
        }
        return true;
    }
}
