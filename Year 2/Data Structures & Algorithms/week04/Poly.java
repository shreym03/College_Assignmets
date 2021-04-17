
/*
  Write a Java program to create a Polynomial equations using linked list and
  add them together
  
  @author shrey Mathur
 */
import java.io.IOException;
import java.util.Scanner;

class Node_P {
    int coef;
    int exp;
    Node_P next;

    /**
     * Constructor to create a Polynomial node
     * 
     * @param c int: Coefficient of the polynomial
     * @param e int: Exponent of the polynomial
     */
    Node_P(int c, int e) {
        coef = c;
        exp = e;
        next = null;
    }
}

class Poly {
    Scanner sc = new Scanner(System.in);
    private Node_P origin = new Node_P(0, 0);
    private Node_P last;

    /**
     * Constructor to create a blank polynomial when nothing is specified
     */
    Poly() {
        last = origin;
    }

    /**
     * Constructor to create a single value (or part of a) Polynomial function
     * 
     * @param c int: coefficient of the polynomial
     * @param e int: exponent of the polynomial
     */
    Poly(int c, int e) {
        origin.next = new Node_P(c, e);
        last = origin.next;
    }

    /**
     * Method to add two different polynoomials together
     * 
     * @param b Poly:
     * @return Poly: returns the sum of the Polynomials
     */
    Poly plus(Poly b) {
        Poly result = new Poly();
        Node_P x = this.origin.next;
        Node_P y = b.origin.next;
        while (x != null || y != null) {
            Node_P temp = null;

            // When reached the end of first Polynomial,
            // just add the remaining of second polynomial
            if (x == null) {
                temp = new Node_P(y.coef, y.exp);
                y = y.next;
            }
            // When reached the end of second Polynomial,
            // just add the remaining of first polynomial
            else if (y == null) {
                temp = new Node_P(x.coef, x.exp);
                x = x.next;

            }
            // if first polynomial is bigger than second,
            // initialise them first until coefficient matches
            else if (x.exp > y.exp) {
                temp = new Node_P(x.coef, x.exp);
                x = x.next;
            } else if (x.exp < y.exp) {
                temp = new Node_P(y.coef, y.exp);
                y = y.next;
            } else {
                int sumCoef = x.coef + y.coef;
                x = x.next;
                y = y.next;
                if (sumCoef == 0)
                    continue;
                temp = new Node_P(sumCoef, x.exp);
            }

            if (temp.coef != 0) {
                result.last.next = temp;
                result.last = result.last.next;
            }
        }
        return result;
    }

    /**
     * This method gives the verbal notation of the polynomial
     * 
     * @return string: The polynomial notation sentence
     */
    public String literate() {
        String s = "";
        for (Node_P x = origin.next; x != null; x = x.next) {
            if (x.coef > 0)
                s = s + "+" + x.coef + "x^" + x.exp + " ";
            else if (x.coef < 0)
                s = s + "-" + (-x.coef) + "x^" + x.exp + " ";
        }
        return s;
    }

    /**
     * Method to create a Polynomial Expression by taking user input continuously
     * until user ends it
     * 
     * @return Poly: This returns the entire Polynomial expression
     * @exception IOException on Input error
     */
    Poly createPoly() throws IOException {
        boolean done = false;
        int c;
        int e;
        Poly p = new Poly();
        do {
            System.out.println("To end Input, Enter 0 twice");
            System.out.println("coefficient: ");
            c = sc.nextInt();
            System.out.println("exponent: ");
            e = sc.nextInt();
            done = (c == 0 && e == 0);
            if (!done) {
                Poly temp = new Poly(c, e);
                p.plus(temp);
            }
        } while (!done);
        System.out.println(p.literate() + "is created");
        return p;
    }

    public static void main(String[] args) {
        // Poly zero = new Poly(0, 0);

        Poly p1 = new Poly(4, 3);
        Poly p2 = new Poly(3, 2);
        Poly p3 = new Poly(-1, 0);
        Poly p4 = new Poly(2, 1);
        Poly p = p1.plus(p2).plus(p3).plus(p4); // 4x^3 + 3x^2 +2x^1 - 1

        Poly q1 = new Poly(3, 2);
        Poly q2 = new Poly(5, 0);
        Poly q = q1.plus(q2); // 3x^2 + 5

        Poly r = p.plus(q1);

        System.out.println("p(x) = " + p.literate());
        System.out.println("q(x) = " + q.literate());
        System.out.println("p(x) + q(x) = " + r.literate());
    }
}
