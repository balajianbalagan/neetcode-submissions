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
 // 0 1 2 3 4 5 6
        // find mid of the list
        // 0 1 2 3s 4 5 6f
        // reverse the second half
        // s->f copy s position till f reverse it
        // s sn 
        // b0 -> 1 -> 2 -> 3s <- 4 <- 5 <- 6f
        // have a dummy 
        // h -> 0 -> 6 -> 1 -> 5 -> 2 ->3
        // connect beginning and move pointer
        // move head
        // connect second half beginning and move pointer
        // move head
        

        // 2 4s 6 8 f
        // 2->4->6->8
        // b2->4s<-6<-8e
        // h->2->8->4->6
    void reorderList(ListNode* head) {
        if (!head || !head->next) return;

        // 1) Find middle
        ListNode* slow = head;
        ListNode* fast = head;

        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }

        // 2) Split + reverse second half
        ListNode* second = slow->next;
        slow->next = nullptr;   // IMPORTANT: split the list

        ListNode* prev = nullptr;
        while (second) {
            ListNode* temp = second->next;
            second->next = prev;
            prev = second;
            second = temp;
        }
        // prev is head of reversed second half

        // 3) Merge two halves
        ListNode* first = head;
        ListNode* secondHalf = prev;

        while (secondHalf) {
            ListNode* t1 = first->next;
            ListNode* t2 = secondHalf->next;

            first->next = secondHalf;
            secondHalf->next = t1;

            first = t1;
            secondHalf = t2;
        }
    }
};
