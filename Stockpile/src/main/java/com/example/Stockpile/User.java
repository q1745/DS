package com.example.stockpile;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Name:yao
 * @CreateDate: 2021/9/11 9:05
 * @ProjectName: DS
 * @Package: com.example.Stockpile
 * @ClassName: User
 */
@Entity
public class User {
    @Id(autoincrement = true)
    public Long id;
    public String name;
    public String title;
    public int age;
    @Generated(hash = 651379411)
    public User(Long id, String name, String title, int age) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.age = age;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
