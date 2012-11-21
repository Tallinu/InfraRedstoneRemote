package com.kaijin.InfraRedstoneRemote;

import net.minecraft.src.*;

public class TileReceiver extends TileEntity
{
    private boolean powerOn = false;
    private double interactDistSq = 64D;
    private int powerDuration = 20;
    private int powerTicks = 0;

    public int orientation = 0;

    public TileReceiver()
    {
        super();
        setInteractionDistance(100D);
        
    }

    public void setInteractionDistance(double dist)
    {
        interactDistSq = dist * dist;
    }

    public boolean isUseableByPlayer(EntityPlayer player)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }

        // Check if the player is wielding a remote.
        ItemStack item = player.getCurrentEquippedItem();
        if (item != null && item.itemID == mod_InfraRedstone.IRRemoteItemID)
        {
            // Use a longer than normal distance test.
            return player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= interactDistSq;
        }
        // Use a normal distance test.
        return player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
    }

    @Override
    public boolean canUpdate()
    {
        return true;
    }

    @Override
    public void updateEntity()
    {
        if (powerTicks > 0)
        {
            if (powerOn)
            {
                // Reduce timer
                powerTicks--;
                if (powerTicks == 0)
                {
                    // Turn off power and request block update
                    powerOn = false;
                    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                }
            }
            else
            {
                // Previously inactive; turn on and request a block update
                powerOn = true;
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
    }

    /*
     *  Set or reset the timer (the rest will be handled in updateEntity)
     */
    public void activate()
    {
        powerTicks = powerDuration;
    }

    public boolean isActive()
    {
        return powerOn;
    }

    // Read tile entity from NBT.
    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        powerTicks = nbttagcompound.getInteger("PowerTicks");
        powerDuration = nbttagcompound.getInteger("PowerDuration");
    }

    // Write tile entity to NBT.
    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setInteger("PowerTicks", powerTicks);
        nbttagcompound.setInteger("PowerDuration", powerDuration);
    }
}
