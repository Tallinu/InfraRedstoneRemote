package com.kaijin.InfraRedstoneRemote;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.INetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		DataInputStream stream = new DataInputStream(new ByteArrayInputStream(packet.data));

		//Read the first int to determine packet type
		int packetType = -1;
		try
		{
			packetType = stream.readInt();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return;
		}

		int x = 0;
		int y = 0;
		int z = 0;
		World world;
		TileEntity tile;
		try
		{
			x = stream.readInt();
			y = stream.readInt();
			z = stream.readInt();
			world = (player instanceof EntityPlayerMP) ? ((EntityPlayerMP)player).worldObj : FMLClientHandler.instance().getClient().theWorld;
			tile = world.getBlockTileEntity(x, y, z);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return;
		}

		if (tile instanceof TileReceiver)
		{
			if (packetType == 0)
			{
				int info = 0;
				try
				{
					info = stream.readInt();
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
					return;
				}
				((TileReceiver)tile).receiveClientEvent(0, info);
			}
		}
	}
}
