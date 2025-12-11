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

    /**
     * 더 나은 방법
     * min값과 max값만을 저장하는 배열들을 통해 구분
     * 즉, 내가 한것처럼 중간 값의 정렬은 관심 없으니
     * 작은 값과 큰값만을 확인하는 방법
     * 어차피 Size가 1 혹은 2라면 min값 혹은 max값에 동일한 값이 있을 테니 어차피 걸러진다.
     *
     * 메모리를 좀더 아껴보려고 Map을 사용했는데 배열 4개 생성하는게 더 값싸게 먹힌다.
     * 좀더 생각해서 메모리 할당할 것
     * public int countCoveredBuildings(int n, int[][] buildings) {
     *         int[] maxRow = new int[n + 1];
     *         int[] minRow = new int[n + 1];
     *         int[] maxCol = new int[n + 1];
     *         int[] minCol = new int[n + 1];
     *
     *         Arrays.fill(minRow, n + 1);
     *         Arrays.fill(minCol, n + 1);
     *
     *         for (int[] p : buildings) {
     *             int x = p[0];
     *             int y = p[1];
     *             maxRow[y] = Math.max(maxRow[y], x);
     *             minRow[y] = Math.min(minRow[y], x);
     *             maxCol[x] = Math.max(maxCol[x], y);
     *             minCol[x] = Math.min(minCol[x], y);
     *         }
     *
     *         int res = 0;
     *         for (int[] p : buildings) {
     *             int x = p[0];
     *             int y = p[1];
     *             if (
     *                 x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]
     *             ) {
     *                 res++;
     *             }
     *         }
     *
     *         return res;
     *     }
     */
}