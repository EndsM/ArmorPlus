/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.armorplus.api.crafting.lavainfuser;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thedragonteam.armorplus.compat.minetweaker.lavainfuser.LavaInfuserRecipe;
import net.thedragonteam.thedragonlib.util.LogHelper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LavaInfuserManager {
    private static final LavaInfuserManager INSTANCE = new LavaInfuserManager();
    private final List<LavaInfuserRecipe> recipes = Lists.newArrayList();
    private final Map<ItemStack, ItemStack> infusingList = Maps.newHashMap();
    private final Map<ItemStack, Double> experienceList = Maps.newHashMap();

    private LavaInfuserManager() {
    }

    /**
     * Returns an instance of LavaInfuserCraftingManager.
     */
    public static LavaInfuserManager getInstance() {
        return INSTANCE;
    }

    /**
     * Adds a infusing recipe, where the input item is an instance of Block.
     */
    public void addInfusingRecipe(Block input, ItemStack stack, double experience) {
        this.addInfusingRecipe(Item.getItemFromBlock(input), stack, experience);
    }

    /**
     * Adds a infusing recipe using an Item as the input item.
     */
    public void addInfusingRecipe(Item input, ItemStack stack, double experience) {
        this.addInfusingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addInfusingRecipe(ItemStack input, ItemStack stack) {
        this.addInfusingRecipe(input, stack, 0.0D);
    }

    public void addInfusing(Item input, ItemStack stack, double experience) {
        this.addInfusing(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addInfusing(ItemStack input, ItemStack stack) {
        this.addInfusing(input, stack, 0.0D);
    }

    public void addInfusing(LavaInfuserRecipe recipe) {
        this.recipes.add(recipe);
    }

    /**
     * Adds a infusing recipe using an ItemStack as the input for the recipe.
     */
    public void addInfusingRecipe(ItemStack input, ItemStack stack, double experience) {
        if (!getInfusingResult(input).isEmpty()) {
            LogHelper.INSTANCE.info("Ignored infusing recipe with conflicting input: " + input + " = " + stack);
            return;
        }
        this.infusingList.put(input, stack);
        this.experienceList.put(stack, experience);
    }

    public void addInfusing(ItemStack input, ItemStack stack, double experience) {
        if (!getInfusingResult(input).isEmpty()) {
            LogHelper.INSTANCE.info("Ignored infusing recipe with conflicting input: " + input + " = " + stack);
            return;
        }
        this.recipes.add(new LavaInfuserRecipe(input, stack, experience));
    }

    /**
     * Removes an IRecipe to the list of crafting recipes.
     */
    public void removeFromRecipe(ItemStack recipe) {
        this.infusingList.remove(recipe);
    }

    /**
     * Removes an IRecipe to the list of crafting recipes.
     */
    public void removeFromRecipe(LavaInfuserRecipe recipe) {
        this.infusingList.remove(recipe.output);
    }

    /**
     * Removes an IRecipe to the list of crafting recipes.
     */
    public void removeRecipe(LavaInfuserRecipe recipe) {
        this.recipes.remove(recipe);
    }

    /**
     * Returns the infusing result of an item.
     */
    public ItemStack getInfusingResult(ItemStack stack) {
        for (Map.Entry<ItemStack, ItemStack> entry : this.infusingList.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return Optional.of(entry).map(Map.Entry::getValue).orElse(ItemStack.EMPTY);
            }
        }
        return Optional.<Map.Entry<ItemStack, ItemStack>>empty().map(Map.Entry::getValue).orElse(ItemStack.EMPTY);
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getInfusingList() {
        return this.infusingList;
    }

    public List<LavaInfuserRecipe> getRecipeList() {
        return this.recipes;
    }

    public double getInfusingExperience(ItemStack stack) {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Map.Entry<ItemStack, Double> entry : this.experienceList.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return Optional.of(entry).map(Map.Entry::getValue).orElse(0.0D);
            }
        }
        return Optional.<Map.Entry<ItemStack, Double>>empty().map(Map.Entry::getValue).orElse(0.0D);
    }
}