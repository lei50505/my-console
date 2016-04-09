package cn.console.num.perfect;

public class PerfectNumber { 

    public static int perfectNumberCheck(int num){
        for (int i = 1; i <= num; ++i) {  
            
            int sum = 0;
  
            for (int n = 1; n < i / 2 + 1; ++n) {  
                if (i % n == 0) {  
                    sum += n; 
                }  
            }  
            if (sum == i) {
                return 1;
            }  
        }  
        return 0;
    }

}