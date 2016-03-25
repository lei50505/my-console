package cn.console.wap.pro02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        n = sc.nextInt();
        m = sc.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; ++i) {
            Node nodei = new Node(i);
            nodes[i] = nodei;
        }
        int a, b;
        // to build a binary tree
        for (int i = 0; i < m - 1; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (nodes[a].lc == null) {
                nodes[a].lc = nodes[b];
                nodes[b].p = nodes[a];
            } else {
                nodes[a].rc = nodes[b];
                nodes[b].p = nodes[a];
            }
        }
        nodes[1].isBlack = true;
        int x, y;
        for (int k = 0; k < n; ++k) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (x == 1) {
                nodes[y].isBlack = true;
            } else {
                int dis = count(nodes[y]);
                System.out.println(dis);
                for (int i = 1; i <= n; ++i) {
                    nodes[i].isCheck = false;
                }
            }
        }
        sc.close();
    }

    public static class Node {
        int num;
        //the left chilf
        Node lc;
        // the right child
        Node rc;
        // the parent
        Node p;
        //black means the city has the party
        boolean isBlack = false;
        // this means finded city, and every search need to reset
        boolean isCheck = false;

        Node(int num) {
            this.num = num;
        }
    }

    //use the dynamic programming based on a binary tree
    public static int count(Node cur) {
        if (cur == null) {
            return -1;
        } else {
            cur.isCheck = true;
        }
        if (cur.isBlack) {
            return 0;
        }
        int lcq = -1;
        int rcq = -1;
        int pq = -1;
        if (cur.lc != null && !cur.lc.isCheck) {
            int nn = count(cur.lc);
            lcq = nn == -1 ? -1 : nn + 1;
        }
        if (cur.rc != null && !cur.rc.isCheck) {
            int nn = count(cur.rc);
            rcq = nn == -1 ? -1 : nn + 1;
        }
        if (cur.p != null && !cur.p.isCheck) {
            int nn = count(cur.p);
            pq = nn == -1 ? -1 : nn + 1;
        }
        return getMin(lcq, rcq, pq);
    }

    //To get the minimum Integer bigger than -1
    public static int getMin(int a, int b, int c) {
        if (a == -1 && b == -1 && c == -1) {
            return -1;
        }
        if (a == -1) {
            a = Integer.MAX_VALUE;
        }
        if (b == -1) {
            b = Integer.MAX_VALUE;
        }
        if (c == -1) {
            c = Integer.MAX_VALUE;
        }
        int d = a < b ? a : b;
        return c < d ? c : d;
    }
}
