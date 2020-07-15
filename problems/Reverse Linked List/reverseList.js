/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    if (!head || ! head.next) {
        return head;
    }
    
    const newTail = head.next;
    const newHead = reverseList(newTail);
    
    newTail.next = head;
    head.next = null;
    
    return newHead;
};
