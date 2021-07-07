package net.blay09.mods.craftingtweaks.api;

import net.minecraft.core.Direction;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Predicate;

public interface SimpleTweakProvider<T extends AbstractContainerMenu> extends TweakProvider<T> {

    /**
     * Sets the settings for the rotation tweak.
     *
     * @param enabled if false, this tweak will not be executed and the button will not show up
     * @param buttonX the x position of the tweak button, relative to the top left corner of the GUI
     * @param buttonY the y position of the tweak button, relative to the top left corner of the GUI
     */
    void setTweakRotate(boolean enabled, boolean showButton, int buttonX, int buttonY);

    /**
     * Sets the settings for the balance tweak.
     *
     * @param enabled if false, this tweak will not be executed and the button will not show up
     * @param buttonX the x position of the tweak button, relative to the top left corner of the GUI
     * @param buttonY the y position of the tweak button, relative to the top left corner of the GUI
     */
    void setTweakBalance(boolean enabled, boolean showButton, int buttonX, int buttonY);

    /**
     * Sets the settings for the clear tweak.
     *
     * @param enabled if false, this tweak will not be executed and the button will not show up
     * @param buttonX the x position of the tweak button, relative to the top left corner of the GUI
     * @param buttonY the y position of the tweak button, relative to the top left corner of the GUI
     */
    void setTweakClear(boolean enabled, boolean showButton, int buttonX, int buttonY);

    /**
     * Sets the crafting grid index within the inventorySlots list in the container.
     *
     * @param slotNumber the index of the first crafting matrix slot within the inventorySlots list (NOT within the inventory)
     * @param size       the size of the crafting grid
     */
    void setGrid(int slotNumber, int size);

    /**
     * @param hideButtons true if tweak buttons should not be added to the GUI
     */
    void setHideButtons(boolean hideButtons);

    /**
     * @param phantomItems true if the crafting grid contains phantom items
     */
    void setPhantomItems(boolean phantomItems);

    /**
     * Setting this will make the buttons always align to the grid and ignore their offset settings.
     *
     * @param alignToGrid the direction the buttons should be aligned towards
     */
    void setAlignToGrid(@Nullable Direction alignToGrid);

    /**
     * Allows specifying a predicate that determines whether a container contains a valid crafting grid.
     *
     * @param predicate should return true for valid crafting containers
     */
    void setContainerValidPredicate(Predicate<AbstractContainerMenu> predicate);

    /**
     * Allows specifying a function that determines the starting slot of a crafting grid. Overrides the slotNumber given in {@link SimpleTweakProvider#setGrid(int, int)}.
     *
     * @param function the slot number of the first crafting grid slot
     */
    void setGetGridStartFunction(Function<AbstractContainerMenu, Integer> function);
}
