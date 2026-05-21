        /*
        // Definition for a Node.
        class Node {
        public:
            int val;
            Node* next;
            Node* random;
            
            Node(int _val) {
                val = _val;
                next = NULL;
                random = NULL;
            }
        };
        */
        
        class Solution {
        public:
            Node* copyRandomList(Node* head) {
                
                if(head==nullptr)return head;
                Node* curr = head;
                while(curr!=nullptr){
                    Node* newNode = new Node(curr->val);
                    newNode->next = curr->next;
                    curr->next = newNode;
                    curr = curr->next->next;
                }
                
                
                // added new nodes in between old nodes, now we can do random ptr assignment
                
                Node *originalNode  = head;
                
                while(originalNode!=nullptr){
                    Node* copiedNode = originalNode->next;
                    
                    copiedNode->random = originalNode->random != nullptr ? originalNode->random->next : nullptr;
                    
                    originalNode = originalNode->next->next;
                }
                
                
                 // 3. Separate the lists (This is where the fix is!)
        Node* deepCopyHead = head->next;
        Node* currOld = head;        // Pointer for original list
        Node* currNew = deepCopyHead; // Pointer for copied list

        while (currOld != nullptr) {
            currOld->next = currOld->next->next; // Restore original list
            if (currNew->next != nullptr) {
                currNew->next = currNew->next->next; // Link copied list
            }
            
            currOld = currOld->next;
            currNew = currNew->next;
        }

        return deepCopyHead;
            }
        };
