package day01.ex02;

interface UsersList {
    void add(User user);
    User getByID(int id) throws IndexOutOfBoundsException;;
    User getByIndex(int index) throws IndexOutOfBoundsException;
    int	size();
}