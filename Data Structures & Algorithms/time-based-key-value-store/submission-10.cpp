class TimeMap {
public:
    unordered_map<string,vector<pair<int,string>>> vec_map;
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        this->vec_map[key].push_back({timestamp,value});
    }
    // 1 2 4 5    3
    string get(string key, int timestamp) {
        if(vec_map.find(key)==vec_map.end()){
            return "";
        }
        vector<pair<int,string>> key_vector = this->vec_map[key];
        int left=0,right = key_vector.size()-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(key_vector[mid].first<timestamp){
                left = mid+1;
            }else if(key_vector[mid].first>timestamp){
                right = mid-1;
            }else{
                return key_vector[mid].second;
            }
        }
        cout<<left<<" "<<key_vector[left].first<<" "<<timestamp<<endl;
        if((left==0 && key_vector[left].first>timestamp)){
            return "";
        }else{
            if(left==0){
                return key_vector[left].second;
            }else{
                return key_vector[left-1].second;
            }
        }

    }
};
