package me.formercanuck.formersfarming.event_handlers;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

public class BlockRightClickedHandler {

    public void register() {
        UseBlockCallback.EVENT.register(((player, world, hand, hitResult) -> {
            if (hand == Hand.MAIN_HAND) { // Check if it's the main hand
                BlockPos pos = hitResult.getBlockPos();
                BlockState blockState = world.getBlockState(pos);
                if (blockState.getBlock() instanceof CropBlock cropBlock) { // Check if it's a crop block
                    if (cropBlock.isMature(blockState)) {
                        // If the crop is mature (fully grown) then break it and replant it.
                        world.breakBlock(pos, true, player);

                        world.setBlockState(pos, cropBlock.withAge(0));
                        return ActionResult.SUCCESS; // Return SUCCESS to indicate the interaction was handled
                    }
                }
            }
            return ActionResult.PASS; // Return PASS to allow other mods or vanilla behaviors to execute
        }));
    }
}
