package cs2s03;
public class A2 {
    public int cases(int v, int u, int w) {
    	if (u <= 14){ 
            if (v <= -14){ 
                if (w <= -18){
                    return -9;
                } else {
                    return 8;
                }
            } else { 
                if (w <= -10){
                    return 9;
                } else {
                    return 15;
                }
            }
        } else { 
            if (w <= 0){ 
                if (v <= 20){
                    return -15;
                } else {
                    return 17;
                }
            } else { 
                if (v <= -10){
                    return 11;
                } else {
                    return 16;
                }
            }
        }
    } 
}
