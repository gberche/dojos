package kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * comment       jhhghj
 */
public class KataTest {

    @Test
    public void whenFooIsCalled_thenItReturnsBar() {
        assertThat(new Foo().foo()).isEqualTo("bar");
    }



}
