class Solution {//optimised ->bucket sort(o(n))
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer>en : freq.entrySet()){
            int num = en.getKey();
            int f = en.getValue();
            if(bucket[f]==null){
                bucket[f]= new ArrayList<>();

            }
            bucket[f].add(num);
        }
        int ans[] =new int[k];
        int id=0;
        for(int i=nums.length;i>=0 && id<k;i--){
            if(bucket[i]==null){
                continue;
            }
            for(int num:bucket[i]){
                ans[id++]=num;
                if(id==k){
                    break;
                }
            }
        }
        return ans;
    }
}
