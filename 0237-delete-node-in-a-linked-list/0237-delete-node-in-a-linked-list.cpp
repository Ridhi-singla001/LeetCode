/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* curr) {
    
    ListNode *temp = curr->next;      //store address of curr node's next
    curr->val = temp->val;            //update curr->val with temp->val
    curr->next = temp->next;          //update connections 
    delete temp;                      //delete temp
}

};