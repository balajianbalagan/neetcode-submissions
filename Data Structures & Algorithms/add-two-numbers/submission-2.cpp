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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carryOver = 0;
        ListNode* newListHead = new ListNode(0);
        ListNode* temp = newListHead;
        //lets replace l1 itself as the sum list
        while(l1!=nullptr || l2!=nullptr){
            int l1_val = l1 != nullptr ? l1->val : 0;
            int l2_val = l2 != nullptr ? l2->val : 0;
            int sum = l1_val + l2_val + carryOver;
            if(sum>9){
                carryOver = 1;
                sum = sum%10;
            }else{
                carryOver = 0;
            }
            ListNode* nextNode = new ListNode(sum);
            temp->next = nextNode;
            temp = temp->next;

            l1 = l1!=nullptr ? l1->next : l1;
            l2 = l2!= nullptr ? l2->next : l2;
        }

        if(carryOver){
            ListNode* nextNode = new ListNode(carryOver);
            temp->next = nextNode;
        }
        

        return newListHead->next;;
    }
};
