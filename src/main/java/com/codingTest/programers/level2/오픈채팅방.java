package com.codingTest.programers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
    // Member와 nickname 매칭
    Map<String, String> memberMap = new HashMap<>();
    // Index별 action
    Map<Integer, String> actionMap = new HashMap<>();
    // Index별 action member
    Map<Integer, String> actionMemberMap = new HashMap<>();

    int commandSize;
    boolean[] answerCommand;
    int answerCount = 0;

    public String[] solution(String[] record) {
        commandSize = record.length;
        answerCommand = new boolean[commandSize];

        for(int i = 0; i < commandSize; i++){
            String[] action = record[i].split(" ");
            String command = action[0];
            String userName = action[1];
            this.action(i, action, command, userName);
        }
        return this.getAnswer();
    }

    private void action(int index, String[] action, String command, String userName) {
        String commandTitle = null;
        switch (command) {
            case "Enter":
                this.enter(index, action, userName);
                commandTitle = "들어왔습니다";
                break;
            case "Leave":
                this.leave(index);
                commandTitle = "나갔습니다";
                break;
            case "Change":
                this.change(action, userName);
                break;
        }
        if(commandTitle != null)
            actionMap.put(index, commandTitle);
        actionMemberMap.put(index, userName);
    }

    private void enter(int index, String[] action, String userName) {
        memberMap.put(userName, action[2]);
        answerCommand[index] = true;
        answerCount++;
    }

    private void leave(int index) {
        answerCommand[index] = true;
        answerCount++;
    }

    private void change(String[] action, String userName) {
        memberMap.put(userName, action[2]);
    }

    private String[] getAnswer() {
        String[] res = new String[answerCount];
        int index = 0;
        for(int i = 0; i < commandSize; i++){
            if(!answerCommand[i]) continue;
            res[index] = String.format("%s님이 %s.", memberMap.get(actionMemberMap.get(i)), actionMap.get(i)) ;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        오픈채팅방 res = new 오픈채팅방();
        System.out.println(Arrays.toString(res.solution(record)));
    }
}
