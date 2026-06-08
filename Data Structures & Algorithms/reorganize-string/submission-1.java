class Node {
    int availAt;
    char ch;
    int freq;

    Node(int a, char c, int f) {
        availAt = a;
        ch = c;
        freq = f;
    }
}

class Solution {
    public String reorganizeString(String s) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[1] - a[1]);

        Queue<Node> cooldown = new LinkedList<>();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[] { i, freq[i] });
            }
        }

        StringBuilder ans = new StringBuilder();

        int time = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {

            // Release all chars whose cooldown expired
            while (!cooldown.isEmpty()
                    && cooldown.peek().availAt <= time) {

                Node node = cooldown.poll();

                pq.offer(new int[] {
                    node.ch - 'a',
                    node.freq
                });
            }

            // No available character but still waiting ones
            if (pq.isEmpty()) {
                return "";
            }

            int[] curr = pq.poll();

            char ch = (char) ('a' + curr[0]);

            ans.append(ch);

            if (curr[1] - 1 > 0) {
                cooldown.offer(
                    new Node(time + 2,
                             ch,
                             curr[1] - 1)
                );
            }

            time++;
        }

        return ans.toString();
    }
}