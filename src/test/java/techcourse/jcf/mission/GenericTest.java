package techcourse.jcf.mission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenericTest {

    @Test
    @DisplayName("어레이를 리스트로 바꾸는 테스트")
    void arrayToListTest() {
        //given
        Integer[] a = new Integer[]{1, 2, 3, 4};
        //when
        SimpleList<Integer> integerSimpleList = SimpleList.fromArrayToList(a);
        //then
        boolean contains = integerSimpleList.contains(1);
        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("리스트 총합")
    void sumTest() {
        //given
        Integer[] a = new Integer[]{1, 2, 3, 4};
        //when
        SimpleList<Integer> integerSimpleList = SimpleList.fromArrayToList(a);
        Double sum = SimpleList.sum(integerSimpleList);
        //then
        System.out.println(sum);
        assertThat(sum).isEqualTo(10);
    }

    @Test
    @DisplayName("음수거르기")
    void filterNegative() {
        //given
        Integer[] a = new Integer[]{1, -1, 2, -3, 4};
        //when
        SimpleList<Integer> integerSimpleList = SimpleList.fromArrayToList(a);
        SimpleList<Object> integerSimpleList2 = (SimpleList<Object>) SimpleList.filterNegative(integerSimpleList);
        boolean contains = integerSimpleList2.contains(-1);
        boolean contains1 = integerSimpleList2.contains(-3);
        boolean contains2 = integerSimpleList2.contains(4);
        //then
        assertThat(contains).isFalse();
        assertThat(contains1).isFalse();
        assertThat(contains2).isTrue();
    }

    @Test
    @DisplayName("복사하기")
    void copyTest() {
        //given
        SimpleList<Parent> parent = new JudeArrayList<>();
        SimpleList<Son> son = new JudeArrayList<>();
        System.out.println(parent.size());
        //when
        son.add(new Son(3));
        System.out.println(son.size());
        SimpleList.copy(son, parent);
        System.out.println(parent.size());
        //then
        assertThat(parent.size()).isEqualTo(1);
        assertThat(parent.contains(new Son(3))).isTrue();
        assertThat(parent.contains(new Son(4))).isFalse();
    }
}
