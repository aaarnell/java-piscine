package day01.ex02;

interface UsersList {
    void add(User user);
    User getByID(int id) throws UserNotFoundException;
    User getByIndex(int index) throws UserNotFoundException;
    int	size();
}