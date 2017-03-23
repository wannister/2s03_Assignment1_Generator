package cs2s03;
public class A1 {
	public int cases(int v, int u, int w) {	
    	if (v <= 15){ 
            if (u <= 0){ 
                if (w <= 5){
                    return 19;
                } else {
                    return 2;
                }
            } else { 
                if (w <= -5){
                    return -11;
                } else {
                    return -15;
                }
            }
        } else { 
            if (w <= 13){ 
                if (u <= -20){
                    return 15;
                } else {
                    return 12;
                }
            } else { 
                if (u <= 13){
                    return 10;
                } else {
                    return 14;
                }
                }
            }
    	}
	}
            
