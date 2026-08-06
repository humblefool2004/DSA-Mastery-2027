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
                char[] arr = queue.poll().toCharArray();
                if(target.equals(String.valueOf(arr))) return level;
                for(int  j=0;j<4;j++){
                    if(arr[j] =='0'){
                        arr[j]='9';
                        String next=String.valueOf(arr);
                        if(!set.contains(next)){
                            queue.offer(next);
                            set.add(next);
                        }
                        arr[j]='0';
                    }else{
                        arr[j]= (char)(arr[j]-1);
                        String next=String.valueOf(arr);
                        if(!set.contains(next)){
                            queue.offer(next);
                            set.add(next);
                        }
                        arr[j]= (char)(arr[j]+1);
                    }

                    if(arr[j] =='9'){
                        arr[j]='0';
                        String next=String.valueOf(arr);
                        if(!set.contains(next)){
                            queue.offer(next);
                            set.add(next);
                        }
                        arr[j]='9';
                    }else{
                        arr[j]= (char)(arr[j]+1);
                        String next=String.valueOf(arr);
                        if(!set.contains(next)){
                            queue.offer(next);
                            set.add(next);
                        }
                        arr[j]= (char)(arr[j]-1);
                    }
            
                }
            }
            level++;
        }

        return -1;
    }
}