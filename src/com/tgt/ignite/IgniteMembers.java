package com.tgt.ignite;

import java.util.HashSet;
import java.util.Set;

public class IgniteMembers {

    public String name;
    public String department;
    public String college;
    public int age;
    public Set<String> skillSet;

    public IgniteMembers(){}

    public IgniteMembers(String name, String department, String college, int age, Set<String> skillSet) {
        this.name = name;
        this.department = department;
        this.college = college;
        this.age = age;
        this.skillSet = skillSet;
    }
    public IgniteMembers(String name, String department){
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<String> skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ",department='"+ department + '\''+
                        ", college='" + college + '\'' +
                        ", age=" + age +
                        ", skillSet='" + skillSet + '\'' ;
    }
}
