class MyCalendarThree {
    multiset<pair<int, int>> mp;
public:
    MyCalendarThree() {
        
    }
    
    int book(int start, int end) {
        // using the sweep line algo, we use the multiset so that we can have a sort list even when new 
        // elements are inserted
        mp.insert({start, 1});
        mp.insert({end, -1});
        int ans = 0, cnt = 0;
        for (auto item: mp){
            cnt += item.second;
            ans = max(ans,  cnt);
        }
        return ans;
    }
};
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(start,end);
 */