package sernoo.lust.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class LibidoComponent implements IntComponent, AutoSyncedComponent, ServerTickingComponent {
    private static final String KEY = "libido";
    private static final int MAX_LIBIDO = 20;
    private static final int INCREMENT = 1;

    private int libido = MAX_LIBIDO;
    private final PlayerEntity provider;

    public LibidoComponent(PlayerEntity provider) {
        this.provider = provider;
    }

    @Override
    public boolean shouldSyncWith(ServerPlayerEntity player) {
        return player == this.provider; // only sync with the provider itself
    }

    @Override
    public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity player) {
        buf.writeVarInt(libido); // only synchronize the necessary information
        player.sendMessage(Text.of("Did write sync for libido " + libido));
    }

    @Override
    public void applySyncPacket(PacketByteBuf buf) {
        libido = buf.readVarInt(); // do not call setValue and cause repetitive sync
    }

    @Override
    public int getValue() {
        return libido;
    }

    public void setValue(int value) {
        libido = value;
        LustComponents.LIBIDO.sync(this.provider);
    }

    @Override
    public void increment() {
        setValue(MathHelper.clamp(libido + INCREMENT, 0, MAX_LIBIDO));
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        libido = tag.getInt(KEY);
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt(KEY, libido);
    }

    @Override
    public void serverTick() {
        increment();
    }
}
