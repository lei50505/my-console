package cn.console.wap.pro01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[501][501];
        long[][][] dp = new long[2][501][501];
        int m,n;
        
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n=sc.nextInt();
        for (int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                grid[i][j]=sc.nextInt();
            }
        }
        sc.close();
        
        long sum, ans1,ans2;
        boolean flag;
        
        for(int j=n-1;j>=0;--j){
            for(int i=0;i<m;++i){
                sum=0;
                if(grid[i][j]==-1){
                    dp[0][i][j]=dp[1][i][j]=-1;
                    continue;
                }
                ans1=-1;
                ans2=-1;
                flag=false;
                
                for(int k=i;k>=0;--k){
                    if(grid[k][j]==-1){
                        flag=true;
                        break;
                    }
                    sum+=grid[k][j];
                    
                    if(dp[0][k][j+1]!=-1 && dp[0][k][j+1]+sum>ans1){
                        ans1=dp[0][k][j+1]+sum;
                    }
                    if(dp[1][k][j+1]!=-1 && dp[1][k][j+1]>ans2){
                        ans2=dp[1][k][j+1];
                    }
                }
                
                if(!flag){
                    sum=0;
                    for(int k=m-1;k>i;--k){
                        if(grid[k][j]==-1){
                            flag=true;
                            break;
                        }
                        sum+=grid[k][j];
                        if (dp[0][k][j + 1] != -1 && dp[0][k][j + 1] + sum > ans2){
                            ans2 = dp[0][k][j + 1] + sum;
                        }
                        if (dp[1][k][j + 1] != -1 && dp[1][k][j + 1] > ans2){
                            ans2 = dp[1][k][j + 1];
                        }
                    }
                }
                sum = 0;
                flag = false;
                for (int k = i; k < m; ++k) {
                    if (grid[k][j] == -1) {
                        flag = true;
                        break;
                    }
                    sum += grid[k][j];
                    if (dp[0][k][j + 1] != -1 && dp[0][k][j + 1] + sum > ans1)
                        ans1 = dp[0][k][j + 1] + sum;
                    if (dp[1][k][j + 1] != -1 && dp[1][k][j + 1] > ans2)
                        ans2 = dp[1][k][j + 1];
                }
                if (!flag) {
                    sum = 0;
                    for (int k = 0; k < i; ++k) {
                        if (grid[k][j] == -1) {
                            flag = true;
                            break;
                        }
                        sum += grid[k][j];
                        if (dp[0][k][j + 1] != -1 && dp[0][k][j + 1] + sum > ans2)
                            ans2 = dp[0][k][j + 1] + sum;
                        if (dp[1][k][j + 1] != -1 && dp[1][k][j + 1] > ans2)
                            ans2 = dp[1][k][j + 1];
                    }
                }
                dp[0][i][j] = ans1;
                dp[1][i][j] = ans2;
                
            }
        }
        
        long ans=-1;
        for (int i = 0; i < m; ++i) {
            if (dp[0][i][0] > ans)
                ans = dp[0][i][0];
            if (dp[1][i][0] > ans)
                ans = dp[1][i][0];
        }
        System.out.println(ans);
        
    }
}
