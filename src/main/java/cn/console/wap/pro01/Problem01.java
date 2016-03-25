package cn.console.wap.pro01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0, n = 0;
        m = sc.nextInt();
        n = sc.nextInt();
        int val = -1;
        nodes = new Node[n][m];
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < m; ++y) {
                val = sc.nextInt();
                Node nn = new Node(val);
                nodes[x][y]=nn;
                // 上
                if (x - 1 >= 0) {
                    nodes[x - 1][y].down = nn;
                    nn.up = nodes[x - 1][y];
                }
                // 左
                if (y - 1 >= 0) {
                    nodes[x][y - 1].right = nn;
                    nn.left = nodes[x][y - 1];
                }
            }
        }
        sc.close();
        Set<Integer> nums = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
            int v = nodes[i][m - 1].value;
            if (v == -1 && i - 1 >= 0 && nodes[i - 1][m - 1].value > -1) {
                nums.add(i - 1);
            }
            if (v == -1 && i + 1 <= n && nodes[i + 1][m - 1].value > -1) {
                nums.add(i + 1);
            }
            if(i==0&&v>-1){
                nums.add(0);
            }
            if(i==n-1&&v>-1){
                nums.add(n-1);
            }
        }
        int maxScore=-1;
        int tmpScore = -1;
        for(int num:nums){
            tmpScore = count(nodes[num][m-1], null);
            if(tmpScore>maxScore){
                maxScore=tmpScore;
            }
        }
        System.out.println(maxScore);

    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node up;
        public Node down;
        
        public boolean isCheck;

        Node(int value) {
            this.value = value;
        }
    }

    public static int value = 0;
    public static Node[][] nodes;

    public static int count(Node cur, Node from) {
        int lq = -1;
        if (cur.left != null && cur.left.value != -1) {
            lq = count(cur.left, cur);
        }
        int uq = -1;
        if (cur.up != null && cur.up.value != -1 && cur.up != from) {
            uq = count(cur.up, cur);
        }
        int dq = -1;
        if (cur.down != null && cur.down.value != -1 && cur.down != from) {
            dq = count(cur.down, cur);
        }
        int tmp = lq > uq ? lq : uq;
        int max = tmp > dq ? tmp : dq;
        if (max == -1 && cur.left == null) {
            // 正常出去
            return cur.value;
        } else if (max == -1 && cur.left != null) {
            // 需要计算穿墙后能否出去
            int flag = -1;
            int val = cur.value;
            if (cur.up == null) {
                while (cur.down != null) {
                    cur = cur.down;
                }
                if (cur.value != -1) {
                    flag = count(cur, null);
                } else {
                    flag = -1;
                }

            } else if (cur.down == null) {
                while (cur.up != null) {
                    cur = cur.up;
                }
                if (cur.value != -1) {
                    flag = count(cur, null);
                } else {
                    flag = -1;
                }

            }
            if (flag == -1) {
                return -1;
            } else {
                return val;
            }

        } else {

            return cur.value + max;
        }

    }
    public static int toLeft(Node cur) {
        int lq = -1;
        if (cur.left != null && cur.left.value != -1) {
            lq = count(cur.left, cur);
        }
        int uq = -1;
        if (cur.up != null && cur.up.value != -1 && cur.up != from) {
            uq = count(cur.up, cur);
        }
        int dq = -1;
        if (cur.down != null && cur.down.value != -1 && cur.down != from) {
            dq = count(cur.down, cur);
        }
        int tmp = lq > uq ? lq : uq;
        int max = tmp > dq ? tmp : dq;
        if (max == -1 && cur.left == null) {
            // 正常出去
            return cur.value;
        } else if (max == -1 && cur.left != null) {
            // 需要计算穿墙后能否出去
            int flag = -1;
            int val = cur.value;
            if (cur.up == null) {
                while (cur.down != null) {
                    cur = cur.down;
                }
                if (cur.value != -1) {
                    flag = count(cur, null);
                } else {
                    flag = -1;
                }
                
            } else if (cur.down == null) {
                while (cur.up != null) {
                    cur = cur.up;
                }
                if (cur.value != -1) {
                    flag = count(cur, null);
                } else {
                    flag = -1;
                }
                
            }
            if (flag == -1) {
                return -1;
            } else {
                return val;
            }
            
        } else {
            
            return cur.value + max;
        }
        
    }
}
