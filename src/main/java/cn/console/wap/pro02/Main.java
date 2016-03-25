package cn.console.wap.pro02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    public static Node[] node ;
    public int m,n;
    static class Node{
        boolean flag;
        List<Integer> eds;
        Node(){
            flag=false;
            eds=new ArrayList<Integer>();
        }
    }
    static class State{
        int par;
        int no;
        int dis;
        public State() {
        }
    }
    public static int bfs(int x){
        Queue<State> que = new LinkedList<State>();
        State sta =new State();
        sta.par = 0;
        sta.no = x;
        sta.dis = 0;
        que.add(sta);
        while(!que.isEmpty()){
            State cur = que.poll();
            if(node[cur.no].flag){
                return cur.dis;
            }
            List<Integer> vecs = node[cur.no].eds;
            for(int i=0;i<vecs.size();++i){
                if(vecs.get(i)==cur.par){
                    continue;
                }
                State ns=new State();
                ns.par=cur.no;
                ns.no=vecs.get(i);
                ns.dis=cur.dis+1;
                que.add(ns);
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        node = new Node[100001];
        Scanner sc = new Scanner(System.in);
        int m,n;
        m=sc.nextInt();
        n=sc.nextInt();
        int a,b;
        for(int i=1;i<m;++i){
            a=sc.nextInt();
            b=sc.nextInt();
            Node na = new Node();
            na.eds.add(b);
            Node nb = new Node();
            nb.eds.add(a);
            node[a]=na;
            node[b]=nb;
        }
        node[1].flag=true;
        for (int i=0;i<n;++i){
            a=sc.nextInt();
            b=sc.nextInt();
            if(a==1){
                node[b].flag=true;
            }else{
                int dis =bfs(b);
                System.out.println(dis);
            }
        }
        sc.close();
        
    }
}
