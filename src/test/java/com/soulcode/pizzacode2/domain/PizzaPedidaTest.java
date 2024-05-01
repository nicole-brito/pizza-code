import com.soulcode.pizzacode2.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PizzaPedidaTest {

    @Mock
    private Tamanho tamanho;

    @Mock
    private Pedido pedido;

    @Mock
    private Pizza pizza;

    @Mock
    private Ingrediente ingrediente;

    private PizzaPedida pizzaPedida;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        pizzaPedida = new PizzaPedida();
        pizzaPedida.setIdPizzaPedida(1L);
        pizzaPedida.setQuantidade(2);
        pizzaPedida.setIdTamanho(tamanho);
        pizzaPedida.setPedidos(pedido);
        pizzaPedida.setPizzas(pizza);
        pizzaPedida.setPizzapedida(new HashSet<>() {{
            add(ingrediente);
        }});
    }

    @Test
    public void shouldReturnCorrectId() {
        assertEquals(1L, pizzaPedida.getIdPizzaPedida());
    }

    @Test
    public void shouldReturnCorrectQuantity() {
        assertEquals(2, pizzaPedida.getQuantidade());
    }

    @Test
    public void shouldReturnCorrectTamanho() {
        assertEquals(tamanho, pizzaPedida.getIdTamanho());
    }

    @Test
    public void shouldReturnCorrectPedido() {
        assertEquals(pedido, pizzaPedida.getPedidos());
    }

    @Test
    public void shouldReturnCorrectPizza() {
        assertEquals(pizza, pizzaPedida.getPizzas());
    }

    @Test
    public void shouldReturnCorrectIngrediente() {
        assertEquals(1, pizzaPedida.getPizzapedida().size());
        assertEquals(ingrediente, pizzaPedida.getPizzapedida().iterator().next());
    }
}