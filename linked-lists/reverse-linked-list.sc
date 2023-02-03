object Solution {
  def reverseList(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      val newHead = reverseList(head.next)
      head.next.next = head
      head.next = null
      newHead
    }
  }
}
