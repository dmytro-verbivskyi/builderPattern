import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuilderTest {

    @Test
    public void rootCanBeCreatedViaBuilder() throws Exception {
        Root root = new Root.Builder().build();
        assertThat(root).isNotNull();
    }

    @Test
    public void builderCanBeReusedSeveralTimes() throws Exception {
        Root.Builder builder = new Root.Builder();
        Root root1 = builder.build();
        Root root2 = builder.build();
        assertThat(root1).isNotEqualTo(root2);
    }

    @Test
    public void youCannotChangePrimitive() throws Exception {
        Root.Builder builder = new Root.Builder();

        Root root = builder.age(213).build();
        assertThat(root.getAge()).isEqualTo(213);
        //root.getAge() = 123;
        //root.setAge() - no setter
    }

    @Test
    public void defensiveOfReferenceTypeFromInputSide() throws Exception {
        Root.Builder builder = new Root.Builder();

        List<Long> inputSide = new ArrayList<Long>();
        inputSide.add(1234L);

        Root root = builder.childrenIds(inputSide).build();
        assertThat(root.getChildrenIds()).containsExactly(1234L);

        inputSide.set(0, -1L);
        assertThat(root.getChildrenIds()).containsExactly(1234L);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void defensiveOfReferenceTypeFromRecipientSide() throws Exception {
        Root.Builder builder = new Root.Builder();

        Root root = builder.childrenIds(Collections.singletonList(1234L)).build();
        assertThat(root.getChildrenIds()).containsExactly(1234L);

        root.getChildrenIds().add(-1L);
    }

    @Test
    public void fullCreateOfRoot() throws Exception {
        Root root = new Root.Builder()
                .age(12)
                .childrenIds(null).build();

        assertThat(root.getAge()).isEqualTo(12);
        assertThat(root.getChildrenIds()).isEmpty();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setNullToListToModifyItLater() throws Exception {
        Root root = new Root.Builder()
                .childrenIds(null).build();

        assertThat(root.getChildrenIds()).isEmpty();

        root.getChildrenIds().add(12L);
    }
}
