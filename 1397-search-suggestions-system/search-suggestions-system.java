class Solution {
    private class TrieNode{
        TrieNode children[];
        boolean isWord;

        TrieNode(){
            children=new TrieNode[26];
            isWord=false;
        }
    }

    private TrieNode root;

    private void insertAll(String[] products){
        root=new TrieNode();

        for(String prod : products){
            TrieNode node= root;
            for(char c : prod.toCharArray()){
                int index=c-'a';
                if(node.children[index]==null) node.children[index]=new TrieNode();
                node=node.children[index];
            }
            node.isWord=true;
        }
    }

    private List<String> dfsSearch(TrieNode node,String currentWord){
        List<String> list=new ArrayList<>();
        searchHelper(node,currentWord,list);
        return list;
    }

    private void searchHelper(TrieNode node,String currentWord,List<String> list){
        if(list.size()==3) return;
        if(node.isWord){
            list.add(currentWord);
        }
        
        for(int i=0;i<26;i++){
            if(node.children[i]!=null){
                searchHelper(node.children[i],currentWord + (char)('a'+i),list);
            }
        }
    }
    


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        insertAll(products);

        List<List<String>> answer= new ArrayList<>();
        TrieNode node= root;

        for(int j=0;j<searchWord.length();j++){
            char c = searchWord.charAt(j);
            int index= c-'a';

            if(node.children[index]==null){
                for(int i=j;i<searchWord.length();i++){
                    answer.add(new ArrayList<>());
                }
                return answer;
            }
            node= node.children[index];
            answer.add(dfsSearch(node,searchWord.substring(0,j+1)));
        }
        return answer;
    }
}