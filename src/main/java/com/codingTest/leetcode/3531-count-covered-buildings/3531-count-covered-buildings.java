class Solution {
    // key = y
    Map<Integer, List<Integer>> yMap = new HashMap<>();
    // key = x
    Map<Integer, List<Integer>> xMap = new HashMap<>();

    public int countCoveredBuildings(int n, int[][] buildings) {
        for(int[] building: buildings) {
            int y = building[0];
            int x = building[1];

            List<Integer> ylist = yMap.getOrDefault(y, new ArrayList<>());
            List<Integer> xlist = xMap.getOrDefault(x, new ArrayList<>());
            addForList(ylist, x);
            addForList(xlist, y);
            yMap.put(y, ylist);
            xMap.put(x, xlist);
        }

        int res = 0;
        for(int[] building: buildings) {
            int y = building[0];
            int x = building[1];
            List<Integer> ylist = yMap.get(y);
            List<Integer> xlist = xMap.get(x);
            
            if(ylist.size() < 3 || xlist.size() < 3) continue;
            if(ylist.get(0) == x || ylist.get(ylist.size() - 1) == x) continue;
            if(xlist.get(0) == y || xlist.get(xlist.size() - 1) == y) continue;
            res++;
        }
        return res;
    }

    private void addForList(List<Integer> list, int value) {
        if(list.isEmpty()) {
            list.add(value);
            return;
        }

        if(list.size() == 1) {
            if(list.get(0) < value) {
                list.add(value);
            } else {
                list.add(0, value);
            }
            return;
        }

        // 중간 삽입
        if(list.get(0) < value && list.get(list.size() - 1) > value) {
            list.add(1, value);
            return;
        } 
        
        // 앞이나 뒤에 삽입
        if(list.get(0) > value) {
            list.add(0, value);
        } else {
            list.add(value);
        }
    }
}