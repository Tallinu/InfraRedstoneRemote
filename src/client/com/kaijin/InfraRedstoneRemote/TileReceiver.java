package com.kaijin.InfraRedstoneRemote;

import com.kaijin.InfraRedstoneRemote.*;

import net.minecraft.src.*;

public class TileReceiver extends TileEntity
{
    private boolean previousPowerState = false;

    @Override
    public boolean canUpdate()
    {
        return true;
    }

    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }

        int itemID = 0;
        // Check what item the player is wielding.
        // Use a large distance test and return true only if a remote is found.
        if (itemID == mod_InfraRedstone.IRRemoteItemID)
            return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 128D;
        else
            return false;
    }

}
