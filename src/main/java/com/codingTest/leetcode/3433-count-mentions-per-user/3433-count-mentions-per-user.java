class Solution {
    private final Map<String, Integer> parseMap = new HashMap<>();
    // 0: online, [<0] offlinetime and 60 hour after online
    private int[] online;
    private int[] mentions;

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events = events.stream()
                        .sorted((a, b) -> {
                            if(a.get(1).equals(b.get(1))) {
                                return a.get(0).equals("OFFLINE") ? -1 : 1;
                            }
                            return parseInt(a.get(1)) - parseInt(b.get(1));
                        }).collect(Collectors.toList());
        online = new int[numberOfUsers];
        mentions = new int[numberOfUsers];

        String command;
        int time;
        String members;
        for(List<String> event: events) {
            command = event.get(0);
            time = parseInt(event.get(1));
            members = event.get(2);
            if("MESSAGE".equals(command)) {
                sendMessage(time, members);
                continue;
            }

            if("OFFLINE".equals(command)) {
                offline(time, members);
                continue;
            }
        }

        return mentions;
    }

    private void sendMessage(int time, String members) {
        if("ALL".equals(members)) {
            callForAll();
            return;
        }
        if("HERE".equals(members)) {
            callForOnline(time);
            return;
        }
        String[] ids = members.split(" ");
        for(String id: ids) {
            int idx = parseInt(id);
            mentions[idx]++;
        }
    }

    private void offline(int time, String member) {
        int id = parseInt(member);
        online[id] = time;
    }

    private void callForAll() {
        for(int i = 0; i < mentions.length; i++) {
            mentions[i]++;
        }
    }

    private void callForOnline(int time) {
        for(int i = 0; i < mentions.length; i++) {
            if(online[i] == 0 || online[i] + 60 <= time) {
                mentions[i]++;
            }
        }
    }

    private int parseInt(String str) {
        if(parseMap.containsKey(str)) return parseMap.get(str);
        int res = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c < '0' || c > '9') continue;
            res *= 10;
            res += (c - '0');
        }
        parseMap.put(str, res);
        return res;
    }
}