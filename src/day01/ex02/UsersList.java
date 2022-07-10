package day01.ex02;

interface UsersList {
    void add(User user);
    User getByID(int id);
    User getByIndex(int index);
    int	size();
}
