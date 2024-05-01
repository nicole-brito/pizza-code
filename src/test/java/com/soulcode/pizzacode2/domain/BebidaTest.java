import com.soulcode.pizzacode2.domain.Bebida;
import com.soulcode.pizzacode2.domain.BebidaPedida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BebidaTest {

    @Mock
    private BebidaPedida bebidaPedida;

    private Bebida bebida;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        bebida = new Bebida();
        bebida.setIdBebida(1L);
        bebida.setNome("Coca-Cola");
        bebida.setPreco(3.50);
        bebida.setIdBebidaBebidasPedidas(new HashSet<>() {{
            add(bebidaPedida);
        }});
    }

    @Test
    public void shouldReturnCorrectId() {
        assertEquals(1L, bebida.getIdBebida());
    }

    @Test
    public void shouldReturnCorrectName() {
        assertEquals("Coca-Cola", bebida.getNome());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        assertEquals(3.50, bebida.getPreco());
    }

    @Test
    public void shouldReturnCorrectBebidaPedida() {
        assertEquals(1, bebida.getIdBebidaBebidasPedidas().size());
        assertEquals(bebidaPedida, bebida.getIdBebidaBebidasPedidas().iterator().next());
    }
}