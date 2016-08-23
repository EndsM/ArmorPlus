/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package net.thedragonteam.armorplus.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.thedragonteam.armorplus.ARPConfig;
import net.thedragonteam.armorplus.ArmorPlus;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/13/2016 6:42 PM.
 * - TheDragonTeam
 */
public class GuiArmorPlusInfo extends GuiScreen {

    int guiWidth = 265;
    int guiHeight = 250;

    int guiX = (width - guiWidth) / 2;
    int guiY = (height - guiHeight) / 2;

    GuiButton buttonLink1;

    @Override
    public void drawScreen(int x, int y, float ticks) {
        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;
        GL11.glColor4f(1, 1, 1, 1);
        drawDefaultBackground();
        mc.renderEngine.bindTexture(new ResourceLocation(ArmorPlus.MODID, "textures/gui/GuiArmorPlus.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);

        fontRendererObj.drawString(new TextComponentString("ArmorPlus Info").getFormattedText(), guiX + 10, guiY + 10, 0x000000);
        fontRendererObj.drawString(new TextComponentString("ArmorPlus Crafting Recipes are Expert Mode").getFormattedText(), guiX + 10, guiY + 30, 0x000000);
        fontRendererObj.drawString(new TextComponentString("`I:Recipe:1` by default.").getFormattedText(), guiX + 10, guiY + 40, 0x000000);
        fontRendererObj.drawString(new TextComponentString("If you want to change to Easy Mode you will").getFormattedText(), guiX + 10, guiY + 50, 0x000000);
        fontRendererObj.drawString(new TextComponentString("need to change the config").getFormattedText(), guiX + 10, guiY + 60, 0x000000);
        fontRendererObj.drawString(new TextComponentString("From `I:Recipe:1` to `I:Recipe:0`.").getFormattedText(), guiX + 10, guiY + 70, 0x000000);
        fontRendererObj.drawString(new TextComponentString("Current Gamemode `I:Recipe:" + ARPConfig.recipes + "`.").getFormattedText(), guiX + 10, guiY + 90, 0x000000);
        super.drawScreen(x, y, ticks);
    }

    @Override
    protected void keyTyped(char c, int key) throws IOException {
        switch (key) {
            case Keyboard.KEY_E:
                mc.displayGuiScreen(null);
        }
        super.keyTyped(c, key);
    }

    @Override
    protected void setText(String newChatText, boolean shouldOverwrite) {
        super.setText(newChatText, shouldOverwrite);
    }
}