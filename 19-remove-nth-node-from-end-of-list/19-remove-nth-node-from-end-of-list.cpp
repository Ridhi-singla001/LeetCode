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
   ListNode* removeNthFromEnd(ListNode* head, int n) {
        // attach dummy node at the beginning to simplify the process
        ListNode* newHead = new ListNode(-1);
        newHead->next = head;
        
        ListNode *temp1, *temp2;
        temp1 = temp2 = newHead;
        
        while(n--){
            temp2 = temp2->next;
        }
        
        while(temp2->next){
            temp1 = temp1->next;
            temp2 = temp2->next;
        }
        
        temp1->next = temp1->next->next;
        
        return newHead->next;
    }
};