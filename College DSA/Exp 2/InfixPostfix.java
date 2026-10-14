import java.util.Scanner;

class InfixPostfix {
    char stack[];
    int top = -1;

    InfixPostfix(int n) {
        stack = new char[n];
    }

    void push(char c) {
        top++;
        stack[top] = c;
    }

    char pop() {
        char c = stack[top];
        top--;
        return c;
    }

    char peek() {
        return stack[top];
    }

    int priority(char c) {
        if(c == '+' || c == '-')
            return 1;
        if(c == '*' || c == '/')
            return 2;
        if(c == '^')
            return 3;
        return 0;
    }

    String convert(String exp) {
        String post = "";

        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c))
                post = post + c;

            else if(c == '(')
                push(c);

            else if(c == ')') {
                while(peek() != '(')
                    post = post + pop();
                pop();
            }

            else {
                while(top != -1 && priority(peek()) >= priority(c))
                    post = post + pop();

                push(c);
            }
        }

        while(top != -1)
            post = post + pop();

        return post;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Infix to Postfix");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {
                System.out.print("Enter infix expression: ");
                String exp = sc.nextLine();

                InfixPostfix obj = new InfixPostfix(exp.length());

                System.out.println("Postfix expression: " + obj.convert(exp));
            }

            else if(choice == 2)
                System.out.println("Exit");

            else
                System.out.println("Invalid choice");

        } while(choice != 2);
    }
}