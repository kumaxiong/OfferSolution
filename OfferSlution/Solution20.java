package OfferSlution;

import java.util.Stack;

/**
 * 确保弹出时，栈为空的异常
 */
public class Solution20 {
    Stack<Integer> m_data = new Stack<>();
    Stack<Integer> m_min = new Stack<>();

    public void push(int node) {
        m_data.push(node);
        if (m_min.size() == 0 || node < m_min.peek())
            m_min.push(node);
        else
            m_min.push(m_min.peek());
    }

    public void pop() {
        assert !m_data.isEmpty() && !m_min.isEmpty();
        m_min.pop();
        m_data.pop();
    }

    public int top() {
        assert !m_data.isEmpty() && !m_min.isEmpty();
        return m_data.peek();
    }

    public int min() {
        assert !m_data.isEmpty() && !m_min.isEmpty();
        return m_min.peek();
    }
}
