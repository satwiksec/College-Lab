import java.util.Scanner;

class Student
{
    int roll;
    String name;

    Student next;

    Student(int roll,String name)
    {
        this.roll = roll;
        this.name = name;

        next = null;
    }
}

public class Main
{
    static Student head = null;

    static Scanner sc = new Scanner(System.in);

    static void insert()
    {
        System.out.print("Enter Roll Number : ");
        int roll = sc.nextInt();

        System.out.print("Enter Name : ");
        String name = sc.next();

        Student newNode = new Student(roll,name);

        if(head==null)
        {
            head = newNode;
        }
        else
        {
            Student temp = head;

            while(temp.next!=null)
            {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Student Added Successfully");
    }

    static void delete()
    {
        System.out.print("Enter Roll Number : ");
        int roll = sc.nextInt();

        Student temp = head;
        Student prev = null;

        while(temp!=null && temp.roll!=roll)
        {
            prev = temp;
            temp = temp.next;
        }

        if(temp==null)
        {
            System.out.println("Student Not Found");
            return;
        }

        if(prev==null)
        {
            head = temp.next;
        }
        else
        {
            prev.next = temp.next;
        }

        System.out.println("Record Deleted");
    }

    static void search()
    {
        System.out.print("Enter Roll Number : ");
        int roll = sc.nextInt();

        Student temp = head;

        while(temp!=null)
        {
            if(temp.roll==roll)
            {
                System.out.println("Record Found");
                System.out.println("Roll : " + temp.roll);
                System.out.println("Name : " + temp.name);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student Not Found");
    }

    static void update()
    {
        System.out.print("Enter Roll Number : ");
        int roll = sc.nextInt();

        Student temp = head;

        while(temp!=null)
        {
            if(temp.roll==roll)
            {
                System.out.print("Enter New Name : ");
                temp.name = sc.next();

                System.out.println("Record Updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student Not Found");
    }

    static void display()
    {
        if(head==null)
        {
            System.out.println("No Records Found");
            return;
        }

        Student temp = head;

        System.out.println("\nStudent List");

        while(temp!=null)
        {
            System.out.println("Roll : " + temp.roll);
            System.out.println("Name : " + temp.name);
            System.out.println();

            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        int ch;

        do
        {
            System.out.println("\n1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Search");
            System.out.println("4.Update");
            System.out.println("5.Display");
            System.out.println("6.Exit");

            System.out.print("Enter Choice : ");

            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    insert();
                    break;

                case 2:
                    delete();
                    break;

                case 3:
                    search();
                    break;

                case 4:
                    update();
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(ch!=6);
    }
}
