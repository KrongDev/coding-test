class Solution {
    private final long moduler = 1000000007;
    private final Set<Integer> set = new HashSet<>();
    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int res = 0;

        int check = nums[0];
        for(int i = 0; i < n ; i++) {
            List<Integer> queue = map.getOrDefault(nums[i], new ArrayList<>());
            queue.add(i);
            map.put(nums[i], queue);
            set.add(nums[i]);
        }
        
        for(int num: set) {
            if(map.get(num*2) == null) continue;
            res += getCount(nums, map.get(num), map.get(num * 2));
        }
        return res;
    }

    // @params origin: 기준, target: 제곱한 값
    private int getCount(int[] nums, List<Integer> origin, List<Integer> target) {
        if(nums[origin.get(0)] == nums[target.get(0)]) {
            if(nums[origin.get(0)] != 0) return 0;
            if(origin.size() < 3) return 0;
            long n_long = origin.size();
            long answer = ((n_long * (n_long - 1) * (n_long - 2)) / 6)%moduler;
            return (int)answer;
        }

        long res = 0L;
        int l = 0;
        int low = 0;
        while(l < origin.size() && low < target.size()) {
            int o = origin.get(l);
            int t = target.get(low);
            if(o < t) {
                l++;
                res += (long)low * (target.size() - low); 
            } else {
                low++;
            }
        }
        
        return (int)(res%moduler);
    }
}