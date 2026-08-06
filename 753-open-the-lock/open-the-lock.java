class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> set= new HashSet<>();
        set.addAll(Arrays.asList(deadends)); //works as a visited set too.
        if(set.contains("0000")) return -1;

        Queue<String> queue= new ArrayDeque<>();

        queue.offer("0000");
        set.add("0000");
        int level=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder(queue.poll());
                if(target.equals(sb.toString())) return level;
                //combinations.
                for(int  j=0;j<4;j++){
                    //-1
                    if(sb.charAt(j) =='0'){
                        sb.setCharAt(j,'9');
                        String next=sb.toString();
                        if(!set.contains(next)){
                            queue.offer(next);
                            set.add(next);
                        }
                            
                        sb.setCharAt(j,'0');
                    }else{
                        sb.setCharAt(j,(char)(sb.charAt(j)-1));
                        String next=sb.toString();
                        if(!set.contains(next)){
                            queue.offer(next);
                            set.add(next);
                        }
                        sb.setCharAt(j,(char)(sb.charAt(j)+1));
                    }

                    //+1
                    if(sb.charAt(j) =='9'){
                        sb.setCharAt(j,'0');
                        String next=sb.toString();
                        if(!set.contains(next)){
                            queue.offer(next);
                            set.add(next);
                        }
                        sb.setCharAt(j,'9');
                    }else{
                        sb.setCharAt(j,(char)(sb.charAt(j)+1));
                        String next=sb.toString();
                        if(!set.contains(next)){
                            queue.offer(next);
                            set.add(next);
                        }
                        sb.setCharAt(j,(char)(sb.charAt(j)-1));
                    }
                }
            }
            level++;
        }

        return -1;
    }
}