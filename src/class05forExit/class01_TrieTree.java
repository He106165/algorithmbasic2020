package class05forExit;


import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 * */
public class class01_TrieTree {

    private  static  class Node1{
        public int pass;//记录经过的数量
        public int end;//记录在此节点结束的数量
        public Node1[] nodes; //下层节点的信息

        public Node1(){
            pass=0;
            end=0;
            nodes=new Node1[26]; //26 个英文字母
        }
    }


    public static class TrieTree{
        public Node1 root;//根节点

        public TrieTree(){
            root=new Node1();
        }
        //前缀树添加方法
        public void insert(String value){
            if(value==null) throw  new RuntimeException("");
            char[] chr=value.toCharArray();
            Node1 node=root;
            node.pass++;
            for (char c : chr) {
                int index= c - 'a';
                if(node.nodes[index]==null){
                    node.nodes[index]=new Node1();
                }
                node=node.nodes[index];
                node.pass++;
            }
            node.end++;
        }

        public int search(String value){
            if(value==null) return 0;

            char[] chr=value.toCharArray();

            Node1 node=root;
            //找到未位节点
            for (char c : chr) {
                int index= c - 'a';
                //如果下面节点是空的
                if(node.nodes[index]==null){
                    return 0;
                }
                node=node.nodes[index];
            }
            return node.end;
        }

        public void  delete(String value){
            if(value==null) throw  new RuntimeException("");
            //先判断这条路存在
            if(search(value)!=0){
                char[] chr=value.toCharArray();
                Node1 node=root;
                node.pass--;
                //找到未位节点
                for (char c : chr) {
                    int index= c - 'a';
                    //如果pass值为1，说明命中这条路 只有一种情况
                    if(--node.nodes[index].pass==0){
                        node.nodes[index]=null;//找到这条路的第一个节点置为null,后面会被垃圾回收器回收
                        return;
                    }
                    //定位到下一个node
                    node=node.nodes[index];
                }
                node.end--;
            }
        }
    }

    private  static  class Node2{
        public int pass;//记录经过的数量
        public int end;//记录在此节点结束的数量
        public Map<Integer,Node2> nodes; //下层节点的信息

        public Node2(){
            pass=0;
            end=0;
            nodes=new HashMap<>();
        }
    }
    public static  class  TrieTree2{
        private Node2 root;

        public TrieTree2() {
            root =new Node2();
        }

        //前缀树添加方法
        public void insert(String value){
            if(value==null) throw  new RuntimeException("");
            char[] chr=value.toCharArray();
            Node2 node=root;
            node.pass++;
            for (char c : chr) {
                int index= c - 'a';
                if(!root.nodes.containsKey(index)){
                    //没有就用一个新的node占位
                    root.nodes.put(index,new Node2());
                }
                node=node.nodes.get(index);
                node.pass++;
            }
            node.end++;
        }


    }
    public static class Right {

        private HashMap<String, Integer> box;

        public Right() {
            box = new HashMap<>();
        }

        public void insert(String word) {
            if (!box.containsKey(word)) {
                box.put(word, 1);
            } else {
                box.put(word, box.get(word) + 1);
            }
        }

        public void delete(String word) {
            if (box.containsKey(word)) {
                if (box.get(word) == 1) {
                    box.remove(word);
                } else {
                    box.put(word, box.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            if (!box.containsKey(word)) {
                return 0;
            } else {
                return box.get(word);
            }
        }

        public int prefixNumber(String pre) {
            int count = 0;
            for (String cur : box.keySet()) {
                if (cur.startsWith(pre)) {
                    count++;
                }
            }
            return count;
        }
    }


    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

}
