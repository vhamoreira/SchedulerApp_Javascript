import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MapperSingletonTest {

    @Test
    void getInstance() {
    }

    @Test
    void getPort() {

        assertEquals("8081", MapperSingleton.getInstance().getPort("UFP"));
        assertEquals("8082", MapperSingleton.getInstance().getPort("UP"));
        assertNull(MapperSingleton.getInstance().getPort("kfjlfdjl"));
    }
}