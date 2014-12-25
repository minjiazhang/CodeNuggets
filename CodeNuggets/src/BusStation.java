public class BusStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if (gas == null || cost == null) {
            return -1;
        }
        
        if (gas.length != cost.length) {
            return -1;
        }
        
        if (gas.length == 1) {
            return 0;
        }
        
        int len = gas.length;
        
        for (int i = 0; i < len; i++) {

            int gasTank = gas[i];
        
            int numGasStation = i;
        
            int stop = 0;
            while (gasTank >= cost[numGasStation % len] && stop < len) {
                gasTank = gasTank - cost[numGasStation % len] + gas[(numGasStation + 1) % len];
                numGasStation++; 
                stop++;
                if (numGasStation % len == i) {
                       return i;
                 } 
            }
        }
        
        return -1;
    }
}