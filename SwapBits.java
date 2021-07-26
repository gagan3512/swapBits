//
Given a number, swap the adjacent bits in the binary representation of the number, and print the new number formed after swapping.

Input Format

First line of input contains T - number of test cases. Each of the next T lines contains a number N.

Constraints

1 <= T <= 100000
0 <= N <= 109

Output Format

For each test case, print the new integer formed after swapping adjacent bits, separated by new line.

Sample Input

4
10
7
43
100

Sample Output

5
11
23
152

Explanation

Test Case 1

Binary Representation of 10: 000...1010
After swapping adjacent bits: 000...0101 (5)

Test Case 2

Binary Representation of 7: 000...0111
After swapping adjacent bits: 000...1011 (11)
//

code :-

import java.io.*;
import java.util.*;

public class Solution {
    static int  swap_bits(int n) {
    int bitval;
    for(int i = 0; i < 32; i+=2) {
        bitval = ((n>>i)&1) | (((n>>(i+1))&1)<<1);
        
        // for only 01 and 10 => bitval == 1, or bitval == 2. We don't care if bits at adjacent placs are 00 or 11.
        if(bitval > 0 && bitval < 3)
            n ^= ((1l<<i) | (1l<<(i+1)));  // xor n's value with 11 at the respective position.
            // same as above: n ^= (3<<i);
    }
    return n;
}
    
     
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            System.out.println(swap_bits(n));
        }
    }
}


