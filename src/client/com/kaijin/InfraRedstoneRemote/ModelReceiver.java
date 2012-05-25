// Date: 5/15/2012 1:20:16 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package com.kaijin.InfraRedstoneRemote;

import net.minecraft.src.*;

public class ModelReceiver extends ModelBase
{
  //fields
    ModelRenderer Baseplate;
    ModelRenderer Main;
    ModelRenderer Front1;
    ModelRenderer Front2;
    ModelRenderer Back1;
    ModelRenderer Back2;
    ModelRenderer Right1;
    ModelRenderer Right2;
    ModelRenderer Left1;
    ModelRenderer Left2;
    ModelRenderer Top1;
    ModelRenderer Top2;
    ModelRenderer Bottom1;
  
  public ModelReceiver()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Baseplate = new ModelRenderer(this, 0, 46);
      Baseplate.addBox(-8F, 0F, -8F, 16, 2, 16);
      Baseplate.setRotationPoint(0F, 22F, 0F);
      Baseplate.setTextureSize(64, 32);
      Baseplate.mirror = true;
      setRotation(Baseplate, 0F, 0F, 0F);
      Main = new ModelRenderer(this, 24, 0);
      Main.addBox(-5F, -5F, -5F, 10, 10, 10);
      Main.setRotationPoint(0F, 16F, 0F);
      Main.setTextureSize(64, 32);
      Main.mirror = true;
      setRotation(Main, 0F, 0F, 0F);
      Front1 = new ModelRenderer(this, 0, 30);
      Front1.addBox(-4F, -4F, -4F, 8, 8, 8);
      Front1.setRotationPoint(0F, 16F, -2F);
      Front1.setTextureSize(64, 32);
      Front1.mirror = true;
      setRotation(Front1, 0F, 0F, 0F);
      Front2 = new ModelRenderer(this, 0, 46);
      Front2.addBox(-2F, -2F, -2F, 4, 4, 4);
      Front2.setRotationPoint(0F, 16F, -5F);
      Front2.setTextureSize(64, 32);
      Front2.mirror = true;
      setRotation(Front2, 0F, 0F, 0F);
      Back1 = new ModelRenderer(this, 0, 30);
      Back1.addBox(-4F, -4F, -4F, 8, 8, 8);
      Back1.setRotationPoint(0F, 16F, 2F);
      Back1.setTextureSize(64, 32);
      Back1.mirror = true;
      setRotation(Back1, 0F, 0F, 0F);
      Back2 = new ModelRenderer(this, 0, 46);
      Back2.addBox(-2F, -2F, -2F, 4, 4, 4);
      Back2.setRotationPoint(0F, 16F, 5F);
      Back2.setTextureSize(64, 32);
      Back2.mirror = true;
      setRotation(Back2, 0F, 0F, 0F);
      Right1 = new ModelRenderer(this, 0, 30);
      Right1.addBox(-4F, -4F, -4F, 8, 8, 8);
      Right1.setRotationPoint(-2F, 16F, 0F);
      Right1.setTextureSize(64, 32);
      Right1.mirror = true;
      setRotation(Right1, 0F, 0F, 0F);
      Right2 = new ModelRenderer(this, 0, 46);
      Right2.addBox(-2F, -2F, -2F, 4, 4, 4);
      Right2.setRotationPoint(-5F, 16F, 0F);
      Right2.setTextureSize(64, 32);
      Right2.mirror = true;
      setRotation(Right2, 0F, 0F, 0F);
      Left1 = new ModelRenderer(this, 0, 30);
      Left1.addBox(-4F, -4F, -4F, 8, 8, 8);
      Left1.setRotationPoint(2F, 16F, 0F);
      Left1.setTextureSize(64, 32);
      Left1.mirror = true;
      setRotation(Left1, 0F, 0F, 0F);
      Left2 = new ModelRenderer(this, 0, 46);
      Left2.addBox(-2F, -2F, -2F, 4, 4, 4);
      Left2.setRotationPoint(5F, 16F, 0F);
      Left2.setTextureSize(64, 32);
      Left2.mirror = true;
      setRotation(Left2, 0F, 0F, 0F);
      Top1 = new ModelRenderer(this, 0, 30);
      Top1.addBox(-4F, -4F, -4F, 8, 8, 8);
      Top1.setRotationPoint(0F, 14F, 0F);
      Top1.setTextureSize(64, 32);
      Top1.mirror = true;
      setRotation(Top1, 0F, 0F, 0F);
      Top2 = new ModelRenderer(this, 0, 46);
      Top2.addBox(-2F, -2F, -2F, 4, 4, 4);
      Top2.setRotationPoint(0F, 11F, 0F);
      Top2.setTextureSize(64, 32);
      Top2.mirror = true;
      setRotation(Top2, 0F, 0F, 0F);
      Bottom1 = new ModelRenderer(this, 0, 30);
      Bottom1.addBox(-4F, -4F, -4F, 8, 8, 8);
      Bottom1.setRotationPoint(0F, 19F, 0F);
      Bottom1.setTextureSize(64, 32);
      Bottom1.mirror = true;
      setRotation(Bottom1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Baseplate.render(f5);
    Main.render(f5);
    Front1.render(f5);
    Front2.render(f5);
    Back1.render(f5);
    Back2.render(f5);
    Right1.render(f5);
    Right2.render(f5);
    Left1.render(f5);
    Left2.render(f5);
    Top1.render(f5);
    Top2.render(f5);
    Bottom1.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
