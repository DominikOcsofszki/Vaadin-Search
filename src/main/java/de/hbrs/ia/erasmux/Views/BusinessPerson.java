package de.hbrs.ia.erasmux.Views;

//public class BusinessPerson {
//}
public class BusinessPerson {
    String name;
    String title;
    int age;

    public BusinessPerson() {
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }
}