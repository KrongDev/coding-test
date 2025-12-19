class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for(int i = 2; i <= numRows; i++) {
            List<Integer> addList = new ArrayList<>();
            addList.add(1);
            for(int j = 1; j < i - 1; j++) {
                List<Integer> prev = res.get(i - 2);
                addList.add(prev.get(j - 1) + prev.get(j));
            }
            addList.add(1);
            res.add(addList);
        }

        return res;
    }
}