package micdoodle8.mods.galacticraft.client;

import micdoodle8.mods.galacticraft.GCEntityProjectileTNT;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
@SideOnly(Side.CLIENT)
public class GCRenderProjectileTNT extends Render
{
    private RenderBlocks renderBlocks = new RenderBlocks();

    public GCRenderProjectileTNT()
    {
        this.shadowSize = 0.5F;
    }

    public void doRenderFallingSand(GCEntityProjectileTNT par1EntityFallingSand, double par2, double par4, double par6, float par8, float par9)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        this.loadTexture("/terrain.png");
        Block var10 = Block.blocksList[Block.tnt.blockID];
        World var11 = par1EntityFallingSand.getWorld();
        GL11.glDisable(GL11.GL_LIGHTING);

        if (var10 == Block.dragonEgg)
        {
            this.renderBlocks.blockAccess = var11;
            Tessellator var12 = Tessellator.instance;
            var12.startDrawingQuads();
            var12.setTranslation((double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posX)) - 0.5F), (double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posY)) - 0.5F), (double)((float)(-MathHelper.floor_double(par1EntityFallingSand.posZ)) - 0.5F));
            this.renderBlocks.renderBlockByRenderType(var10, MathHelper.floor_double(par1EntityFallingSand.posX), MathHelper.floor_double(par1EntityFallingSand.posY), MathHelper.floor_double(par1EntityFallingSand.posZ));
            var12.setTranslation(0.0D, 0.0D, 0.0D);
            var12.draw();
        }
        else if (var10 != null)
        {
            this.renderBlocks.func_78588_a(var10, var11, MathHelper.floor_double(par1EntityFallingSand.posX), MathHelper.floor_double(par1EntityFallingSand.posY), MathHelper.floor_double(par1EntityFallingSand.posZ), 0);
        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderFallingSand((GCEntityProjectileTNT)par1Entity, par2, par4, par6, par8, par9);
    }
}
