package techcourse.jcf.mission;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
        //when
        son.add(new Son(3));
        SimpleList.copy(son, parent);
        //then
        assertThat(parent.size()).isEqualTo(1);
        assertThat(parent.contains(new Son(3))).isTrue();
        assertThat(parent.contains(new Son(4))).isFalse();
    }

    @Test
    @DisplayName("복사 원소 두개")
    void copyTest2() {
        //given
        SimpleList<Parent> parent = new JudeArrayList<>();
        SimpleList<Son> son = new JudeArrayList<>();

        son.add(new Son(3));
        son.add(new Son(4));
        //when
        SimpleList.copy(son, parent);
        //then
        assertThat(parent.size()).isEqualTo(2);
        assertThat(parent.contains(new Son(3))).isTrue();
        assertThat(parent.contains(new Son(4))).isTrue();
    }
    
    @Test
    @DisplayName("long")
    void longTest() {

        SimpleList<Long> values = new JudeLinkedList<>();

        values.add(1L);
        values.add(2L);
        System.out.println("values = " + values);
        AssertionsForClassTypes.assertThat(values.indexOf(2L)).isEqualTo(1);
        AssertionsForClassTypes.assertThat(values.add(3L)).isTrue(); // 세 번째 값을 추가한다.
        AssertionsForClassTypes.assertThat(values.contains(3L)).isTrue();
        AssertionsForClassTypes.assertThat(values.indexOf(3L)).isEqualTo(2);
        values.set(0, 5L);
        AssertionsForClassTypes.assertThat(values.contains(5L)).isTrue();
        System.out.println("values = " + values);
        values.set(0, 1L);
        System.out.println("values = " + values);
        AssertionsForClassTypes.assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        AssertionsForClassTypes.assertThat(values.get(0)).isEqualTo(1L); // 첫 번째 값을 찾는다.
        AssertionsForClassTypes.assertThat(values.get(1)).isEqualTo(2L); // 첫 번째 값을 찾는다.
        AssertionsForClassTypes.assertThat(values.get(2)).isEqualTo(3L); // 첫 번째 값을 찾는다.
        assertThatThrownBy(() -> values.get(3)).isInstanceOf(IndexOutOfBoundsException.class);
        AssertionsForClassTypes.assertThat(values.contains(1L)).isTrue(); // 1L 값이 포함되어 있는지를 확인한다.
        AssertionsForClassTypes.assertThat(values.contains(4L)).isFalse(); // 1L 값이 포함되어 있는지를 확인한다.
        AssertionsForClassTypes.assertThat(values.remove(0)).isEqualTo(1L); // 첫 번째 값을 삭제한다.
        AssertionsForClassTypes.assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
        AssertionsForClassTypes.assertThat(values.get(0)).isEqualTo(2L);
        AssertionsForClassTypes.assertThat(values.get(1)).isEqualTo(3L);
        AssertionsForClassTypes.assertThat(values.remove(1)).isEqualTo(3L); // 첫 번째 값을 삭제한다.
        AssertionsForClassTypes.assertThat(values.remove(0)).isEqualTo(2L); // 첫 번째 값을 삭제한다.
        AssertionsForClassTypes.assertThat(values.add(10L)).isTrue();
        System.out.println(values);
        AssertionsForClassTypes.assertThat(values.get(0)).isEqualTo(10L);
        System.out.println(values);
        values.add(0, 12L);
        System.out.println(values);
        AssertionsForClassTypes.assertThat(values.get(0)).isEqualTo(12L);
        AssertionsForClassTypes.assertThat(values.get(1)).isEqualTo(10L);
        AssertionsForClassTypes.assertThat(values.contains(12L)).isTrue();
        AssertionsForClassTypes.assertThat(values.isEmpty()).isFalse();
        AssertionsForClassTypes.assertThat(values.indexOf(12L)).isEqualTo(0);
        AssertionsForClassTypes.assertThat(values.remove(12L)).isTrue();
        AssertionsForClassTypes.assertThat(values.get(0)).isEqualTo(10L);
        System.out.println("values = " + values);
        AssertionsForClassTypes.assertThat(values.set(0, 12L)).isEqualTo(10L);
        System.out.println(values);
        AssertionsForClassTypes.assertThat(values.get(0)).isEqualTo(12L);
        values.clear();
        AssertionsForClassTypes.assertThat(values.size()).isEqualTo(0);
        AssertionsForClassTypes.assertThat(values.add(6L)).isTrue();
        AssertionsForClassTypes.assertThat(values.add(100L)).isTrue();
        values.add(0, 150L);
    }
}
