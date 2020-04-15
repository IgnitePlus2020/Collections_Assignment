package com.tgt.ignite;

import java.net.SocketOption;
import java.util.*;

public class CollectionsAssignment {
    static HashSet<String> Department = new HashSet<>();
   static Scanner in = new Scanner(System.in);
   static List<IgniteMembers> igniteMembers = new ArrayList<>();


   //Display all the departments
    static void displayDepartments(){
        System.out.println("The departments are:");
        for(String i : Department)
            System.out.println(i);
    }

//function 2
    static void createDept(){
       System.out.println("Enter the name of the new department:");
       String newdept = in.next();
       Department.add(newdept);
        System.out.println("The list of departments are:");
        for (String i : Department){
            System.out.println(i);
        }

   }

   //function
   static void searchSkill(){
       System.out.println("Enter the Skill to be searched for:");
       String checkskill = in.next();
       for(IgniteMembers j : igniteMembers) {
           if (j.getSkillSet().contains(checkskill)) {
               System.out.println(j.getName() + "     " + j.getSkillSet()+ "   "+j.getDepartment());
           }

       }
   }

    static void removeDept(){
        System.out.println("Enter the name of the department to be removed:");
        String removedept = in.next();
        Department.remove(removedept);
        System.out.println("The list of departments are:");
        for (String i : Department){
            System.out.println(i);
        }

    }

   // to display according to departments
    static void display() {
            for (IgniteMembers j : igniteMembers) {

                System.out.println(j.getDepartment() + "   " + j.getName());
            }
        }


        //Add a skill
    static void addskill(){
        System.out.println("Enter the department");
        String checkdept = in.next();
        System.out.println("Enter the skill to be added:");
        String skill = in.next();
        if (Department.contains(checkdept)){
        for(IgniteMembers i : igniteMembers) {
            if (i.getDepartment().equals(checkdept))
                i.skillSet.add(skill);
        }

        }
    System.out.println("The skillset has been updated");
    }

//to swap
    static void swapMember() {
        String dept1="";
         String dept2= "";
        System.out.println("Enter the first member to be swapped");
        String swap1 = in.next();
        System.out.println("Enter the second member to be swapped");
        String swap2 = in.next();
        for (IgniteMembers i : igniteMembers) {
            if (i.getName().equals(swap1)) {
               // System.out.println(i.getDepartment());
                dept1 = i.getDepartment();
                //System.out.println(dept1);
            }
        }
        for (IgniteMembers j : igniteMembers) {
            if (j.getName().equals(swap2)) {
                dept2 = j.getDepartment();
               // System.out.println(dept2);
            }
        }
           igniteMembers.remove(new IgniteMembers(swap1,dept1));
           igniteMembers.remove(new IgniteMembers(swap2,dept2));

           igniteMembers.add(new IgniteMembers(swap1,dept2));
        igniteMembers.remove(new IgniteMembers(swap1,dept1));

        igniteMembers.add(new IgniteMembers(swap2,dept1));
        igniteMembers.remove(new IgniteMembers(swap2,dept2));
        display();
        }




    //Create a new member
    static void newMember(){
        System.out.println("Enter the name of the new member:");
        Set<String> newskillSet = new HashSet<>();
        String temp = "";
        String newname = in.next();
        for(IgniteMembers i : igniteMembers ) {
            if (i.getName().equals(newname)) {
                System.out.println("The member already exists");
                return;
            }
       }
        System.out.println("Enter their age");
        int newage = in.nextInt();
        System.out.println("Enter their College name");
        String newcollege = in.next();
        System.out.println("Enter the skillset");
        for(int n=0; n<3;n++){
            temp= in.nextLine();
            newskillSet.add(temp);
            temp = "";
        }
        displayDepartments();
        System.out.println("Enter their department");
        String newdept = in.nextLine();
        if(Department.contains(newdept)) {
            igniteMembers.add((new IgniteMembers(newname,newdept,newcollege,newage,newskillSet)));
            System.out.println(newname+" has been successfully added.");
           return;
        }
        System.out.println("Invalid Department ! Return to main menu");
    }




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public static void main(String[] args) {

        Set<String> gauthamSkillSet = new HashSet<>();
        gauthamSkillSet.add("Java");
        gauthamSkillSet.add("SQL");
        gauthamSkillSet.add("DS");

        Set<String> divyaSkillSet = new HashSet<>();
        divyaSkillSet.add("Java");
        divyaSkillSet.add("NOSQL");
        divyaSkillSet.add("ML");

        Set<String> amitSkillSet = new HashSet<>();
        amitSkillSet.add("Linux");
        amitSkillSet.add("PSQL");
        amitSkillSet.add("Scripting");

        Set<String> naveenSkillSet = new HashSet<>();
        naveenSkillSet.add("Chef");
        naveenSkillSet.add("React");
        naveenSkillSet.add("AI");


        igniteMembers.add(new IgniteMembers("Gautham","Data Science","VTU",28,gauthamSkillSet));
        igniteMembers.add(new IgniteMembers("Divya","Data Science","TGT",25, divyaSkillSet));
            igniteMembers.add((new IgniteMembers("Amit","Infrastructure" ,"TGT", 26, amitSkillSet)));
            igniteMembers.add((new IgniteMembers("Naveen","Infrastructure","TGT", 27, naveenSkillSet)));


       Department.add("Data Science");
       Department.add("InfraStructure");


      // searchSkill();
        //  display();
//createDept();
       // addskill();
        //removeDept();
       // displayDepartments();
       // newMember();
        // swapMember();
        int count =1;
       do{

           System.out.println("Enter 1 to display all the departments");
           System.out.println("Enter 2 to create a new department");
           System.out.println("Enter 3 to delete a department");
           System.out.println("Enter 4 to display the members along with their departments");
           System.out.println("Enter 5 to create a member and add the member to a department");
           System.out.println("Enter 6 to search members having a particular skill");
           System.out.println("Enter 7 to swap to members from their departments");
           System.out.println("Enter 8 to add a new skill to all members of a department");


           int option = in.nextInt();
           switch(option)
           {
               case 1 : displayDepartments();
                         break;
               case 2 : createDept();
                        break;
               case 3 : removeDept();
                        break;
               case 4 : display();
                        break;
               case 5 : newMember();
                         break;
               case 6 : searchSkill();
                         break;
               case 7 : swapMember();
                        break;
               case 8 : addskill();
                         break;
               default : System.out.println("Entered option is invalid");
                        break;
           }

           System.out.println("To return to main menu display enter 1 :");
           count = in.nextInt();
       }while (count == 1);
}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//OUTPUT

/*Enter 1 to display all the departments
        Enter 2 to create a new department
        Enter 3 to delete a department
        Enter 4 to display the members along with their departments
        Enter 5 to create a member and add the member to a department
        Enter 6 to search members having a particular skill
        Enter 7 to swap to members from their departments
        Enter 8 to add a new skill to all members of a department
        1
        The departments are:
        Data Science
        InfraStructure
        To return to main menu display enter 1 :
        1
        Enter 1 to display all the departments
        Enter 2 to create a new department
        Enter 3 to delete a department
        Enter 4 to display the members along with their departments
        Enter 5 to create a member and add the member to a department
        Enter 6 to search members having a particular skill
        Enter 7 to swap to members from their departments
        Enter 8 to add a new skill to all members of a department
        2
        Enter the name of the new department:
        Security
        The list of departments are:
        Data Science
        Security
        InfraStructure
        To return to main menu display enter 1 :
        1
        Enter 1 to display all the departments
        Enter 2 to create a new department
        Enter 3 to delete a department
        Enter 4 to display the members along with their departments
        Enter 5 to create a member and add the member to a department
        Enter 6 to search members having a particular skill
        Enter 7 to swap to members from their departments
        Enter 8 to add a new skill to all members of a department
        3
        Enter the name of the department to be removed:
        Security
        The list of departments are:
        Data Science
        InfraStructure
        To return to main menu display enter 1 :
        1
        Enter 1 to display all the departments
        Enter 2 to create a new department
        Enter 3 to delete a department
        Enter 4 to display the members along with their departments
        Enter 5 to create a member and add the member to a department
        Enter 6 to search members having a particular skill
        Enter 7 to swap to members from their departments
        Enter 8 to add a new skill to all members of a department
        4
        Data Science   Gautham
        Data Science   Divya
        Infrastructure   Amit
        Infrastructure   Naveen
        To return to main menu display enter 1 :
        1
        Enter 1 to display all the departments
        Enter 2 to create a new department
        Enter 3 to delete a department
        Enter 4 to display the members along with their departments
        Enter 5 to create a member and add the member to a department
        Enter 6 to search members having a particular skill
        Enter 7 to swap to members from their departments
        Enter 8 to add a new skill to all members of a department
        5
        Enter the name of the new member:
        Bavitra
        Enter their age
        21
        Enter their College name
        MVIT
        Enter the skillset
        Java

        The departments are:
        Data Science
        InfraStructure
        Enter their department
        Data Science
        Bavitra has been successfully added.
        To return to main menu display enter 1 :
        1
        Enter 1 to display all the departments
        Enter 2 to create a new department
        Enter 3 to delete a department
        Enter 4 to display the members along with their departments
        Enter 5 to create a member and add the member to a department
        Enter 6 to search members having a particular skill
        Enter 7 to swap to members from their departments
        Enter 8 to add a new skill to all members of a department
        6
        Enter the Skill to be searched for:
        Java
        Gautham     [Java, SQL, DS]   Data Science
        Divya     [Java, NOSQL, ML]   Data Science
        Bavitra     [, Java]   Data Science
        To return to main menu display enter 1 :
        1
        Enter 1 to display all the departments
        Enter 2 to create a new department
        Enter 3 to delete a department
        Enter 4 to display the members along with their departments
        Enter 5 to create a member and add the member to a department
        Enter 6 to search members having a particular skill
        Enter 7 to swap to members from their departments
        Enter 8 to add a new skill to all members of a department
        7
        Enter the member to be swapped
        Amit
        Enter the member to be swapped
        Divya
        Data Science   Gautham
        Data Science   Divya
        Infrastructure   Amit
        Infrastructure   Naveen
        Data Science   Bavitra
        Data Science   Amit
        Infrastructure   Divya
        To return to main menu display enter 1 :
1
Enter 1 to display all the departments
Enter 2 to create a new department
Enter 3 to delete a department
Enter 4 to display the members along with their departments
Enter 5 to create a member and add the member to a department
Enter 6 to search members having a particular skill
Enter 7 to swap to members from their departments
Enter 8 to add a new skill to all members of a department
8
Enter the department
Infrastructure
Enter the skill to be added:
Java
The skillset has been updated
To return to main menu display enter 1 :
1
Enter 1 to display all the departments
Enter 2 to create a new department
Enter 3 to delete a department
Enter 4 to display the members along with their departments
Enter 5 to create a member and add the member to a department
Enter 6 to search members having a particular skill
Enter 7 to swap to members from their departments
Enter 8 to add a new skill to all members of a department
9
Entered option is invalid
To return to main menu display enter 1 :
0

Process finished with exit code 0*/