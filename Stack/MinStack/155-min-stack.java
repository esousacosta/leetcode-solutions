import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinStack {
    private int min = Integer.MAX_VALUE;
    private int minIdx = -1;
    private List<int[]> ds;

    public MinStack() {
        ds = new ArrayList<>();
    }
    
    public void push(int val) {
        if (val <= min) {
            min = val;
            // accounting for the new value we're about to add
            minIdx = ds.size();
        }

        // The second value is the minIdx when this current int
        // was added to the stack
        ds.add(new int[]{val, minIdx});
    }
    
    public void pop() {
        ds.remove(ds.size() - 1);

        if (ds.isEmpty()) {
            min = Integer.MAX_VALUE;
            minIdx = -1;
            return;
        }

        minIdx = ds.get(ds.size() - 1)[1];
        min = ds.get(minIdx)[0];
    }
    
    public int top() {
        return ds.get(ds.size() - 1)[0];
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */