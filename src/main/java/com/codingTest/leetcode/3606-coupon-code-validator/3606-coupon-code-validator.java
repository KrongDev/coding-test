class Solution {
    private final String[] okBusiness = {"electronics", "grocery", "pharmacy", "restaurant"};
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> res = new ArrayList<>();
        int N = code.length;

        for(int i = 0; i < N; i++) {
            if(!isActive[i]) continue;
            if(code[i].isEmpty() || !code[i].matches("^\\w+$")) continue;
            if(!isValidBusiness(businessLine[i])) continue;

            res.add(new String[]{businessLine[i], code[i]});
        }

        return res.stream()
                    .sorted((a,b)->{
                        if(a[0].equals(b[0])) {
                            return a[1].compareTo(b[1]);
                        }
                        return a[0].compareTo(b[0]);
                    })
                    .map(a -> a[1])
                    .collect(Collectors.toList());

    }

    private boolean isValidBusiness(String business) {
        boolean res = false;
        for(String check: okBusiness) {
            res = business.equals(check);
            if(res) break;
        }
        return res;
    }
}