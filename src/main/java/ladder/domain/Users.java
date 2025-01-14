package ladder.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final int MINIMUM_SIZE = 2;
    private static final String USERS_SIZE_ERROR_MESSAGE = "유저는 " + MINIMUM_SIZE + "명 미만일 수 없습니다.";
    private static final String USERS_DUPLICATED_ERROR_MESSAGE = "중복된 이름을 입력할 수 없습니다.";

    private final List<User> users;

    public Users(List<String> userNames) {
        validate(userNames);
        this.users = userNames.stream().map(User::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> userNames) {
        validateDuplication(userNames);
        validateSize(userNames);
    }

    private void validateSize(List<String> userNames) {
        if (userNames.size() < MINIMUM_SIZE) {
            throw new IllegalArgumentException(USERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplication(List<String> userNames) {
        int inputNamesSize = userNames.size();
        int unDuplicationNamesSize = new HashSet<>(userNames).size();

        if (inputNamesSize != unDuplicationNamesSize) {
            throw new IllegalArgumentException(USERS_DUPLICATED_ERROR_MESSAGE);
        }
    }

    public UserName getUserNameByIndex(int index) {
        return users.get(index).getName();
    }

    public boolean contain(String name) {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList())
                .contains(new UserName(name));
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int getSize() {
        return users.size();
    }
}
