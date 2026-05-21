class MinStack {
public:
    stack<pair<int,int>> st;
    MinStack() {
    }
    
    void push(int val) {
        if(!this->st.empty()){
            int topv = this->st.top().first;
        int minv = this->st.top().second;
        minv = min(minv,val);
        this->st.push({val,minv});
        }else{
        this->st.push({val,val});

        }
    }
    
    void pop() {
        this->st.pop();
    }
    
    int top() {
        int topv = this->st.top().first;
        return topv;
    }
    
    int getMin() {
        int minv = this->st.top().second;
        return minv;
    }
};
