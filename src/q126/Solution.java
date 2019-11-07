package q126;

import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        if (!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord, endWord, wordList, ans);
        return ans;
    }

    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        //使用队列储存每个路径
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();

        path.add(beginWord);
        queue.offer(path);
        //结束当前层循环的标记
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        //储存遍历过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            //处理当前每一个队列
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int j = 0; j < size; j++) {
                Map<String, ArrayList<String>> neighborMap = new HashMap<>();
                List<String> p = queue.poll();
                //得到当前路径的末尾单词
                String temp = p.get(p.size() - 1);
                // 一次性得到所有的下一个的节点，寻找当前节点的每一条边，生成若干条新的路径（每次均新生成边，可以考虑将其保存到一个map中）
                ArrayList<String> neighbors = null;
                if (!neighborMap.containsKey(temp)) {
                    neighbors = getNeighbors(temp, dict);
                    neighborMap.put(temp, neighbors);
                } else {
                    neighbors = neighborMap.get(temp);
                }
                for (String neighbor : neighbors) {
                    //只考虑之前没有出现过的单词
                    if (!visited.contains(neighbor)) {
                        //到达结束单词
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<String>(p));
                            p.remove(p.size() - 1);
                        }
                        //加入当前单词
                        p.add(neighbor);
                        queue.offer(new ArrayList<String>(p));
                        p.remove(p.size() - 1);
                        subVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        for (String s : dict) {
            if (canTransfer(node, s)) res.add(s);
        }
        return res;
    }

    //通过在dic中遍历，寻找每个节点的边（会超时）
    //可以生成每个节点可能的边，遍历dic看其中是否含有该边（很笨，对于长字符串，短字典不合适）
    private boolean canTransfer(String beginWord, String s) {
        if (beginWord.length() != s.length()) return false;
        boolean flag = true;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != s.charAt(i)) {
                if (flag) flag = false;
                else return false;
            }
        }
        return true && !flag;
    }
/*    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }*/

}