package sernoo.lust.component;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import net.minecraft.util.Identifier;
import sernoo.lust.Lust;

public class LustComponents implements EntityComponentInitializer {
    public static final ComponentKey<IntComponent> LIBIDO =
            ComponentRegistry.getOrCreate(new Identifier(Lust.MOD_ID, "libido"), IntComponent.class);

    // Included as an entrypoint in fabric.mod.json
    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(LIBIDO, LibidoComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}
