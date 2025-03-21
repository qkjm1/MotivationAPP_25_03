package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cmd cmd = new cmd();
        Scanner sc = new Scanner(System.in);

        //main에서 실행 명령어 치기위해서 생성자를 통해 클래스에 집접 sc를 연결
        System.out.println("===========실행===========");

        cmd.add(sc);

        cmd.list();
    }
}
class cmd {
    int 마지막_번호 = 0;
    void add(Scanner sc){

       List<저장목록> list = new ArrayList<>();

        int 번호 = 마지막_번호 + 1;
        System.out.print("motivation :");
        String motivation = sc.nextLine();

        System.out.print("source :");
        String source = sc.nextLine();

        System.out.printf("%d번 motivation이 등록되었습니다",번호);
        마지막_번호++;

        저장목록 저장 = new 저장목록(마지막_번호,motivation,source);
    }

    void list(){
        System.out.println(저장.se);
    }


}
class 저장목록 {
    String motivation;
    String source;
    int 호출_번호;

        저장목록(int 번호, String motivation, String source) {
            this.motivation = motivation;
            this.source = source;
            this.호출_번호 = 번호;
        }

    public int get호출_번호() {
        return 호출_번호;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getSource() {
        return source;
    }

    public void set호출_번호(int 호출_번호) {
        this.호출_번호 = 호출_번호;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public void setSource(String source) {
            this.source = source;
    }
}