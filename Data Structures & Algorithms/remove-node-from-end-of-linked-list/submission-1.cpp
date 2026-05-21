/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int k) {
        /*
        plan is we dont know what is n
        but we can go to n/2 
        we count n/2 and get n then we will get n-k steps from va_start
        we will remove the ListNode
        
        
        */
        ListNode* slow = head;
        ListNode* fast = head;
        if(head==nullptr)return head;
        int l=1;
        int n=1;
        // if(head->next==nullptr && n==1){
        //     return nullptr;
        // }
        while( fast!=nullptr  ){
            if(fast->next==nullptr)break;
            slow = slow->next;
            fast = fast->next->next;
            l++;
        }
        // NOW IF FAST == NULLPTR = WHICH MEANS WE HAVE EVEN LENGTH ListNode
        // now l stands at slow position
        // slow is in n/2 + 1 position so to find n we subract 1 and multiply two ( 1 2 3 4)
        // now for odd LENGTH case (1 2 3 4 5) we stand at n/2 + 1
        if(fast==nullptr){
            n = (l-1)*2;
        }else{
            n = (l-1)*2 + 1;
        }
        cout<<n<<endl;
        int moves = n-k;
        cout<<moves<<endl;
        ListNode* target = head;
        ListNode* prev = head;
        for(int i=0;i<moves;i++){
            prev = target;
            target = target->next;
        }
        if(target==head){
            head=head->next;
        }
        // delete begin node
        prev->next = target->next;
        
        return head;
    }
};
