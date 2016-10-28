package bitcamp.java89.ems;
import java.util.Scanner; // 만약 여기 Scanner가 없으면 java.util 스캐너를 찾아가라 라는 뜻.
public class TeacherController {
  // 아래 인스턴스 변수들은 외부에서 사용할 일이 없기 때문에 접근 제한시킴.
  private Teacher[] teachers = new Teacher[100];
  // teachers <= 이것은 이제 인스턴스 변수로 변함
  private int length = 0;
  private Scanner keyScan;



  public TeacherController(Scanner keyScan) { // 생성자
    this.keyScan = keyScan;
  }

  public void Service() { // loop 사용자로부터
    loop :
     while (true) {
      System.out.print("강사관리> ");
      String command = keyScan.nextLine().toLowerCase();

      switch (command) {
        case "add": this.doAdd(); break; // 컨트롤러 파일 안에 있기 때문에
        case "list": this.doList(); break;
        case "view": this.doview(); break;
        case "delete": this.doDelete(); break;
        case "update": this.doUpdate(); break;
        case "main":
          break loop;
       default:
         System.out.println("지원하지 않는 명령어입니다.");
      }
    }

  }
// 아래의 doxxx() 메서드들은 오직 내부에서만 (Service()) 호출하기 떄문에 private으로 접근제한
  private void doList() {
    for (int i = 0; i < this.length; i++) {
      Teacher teacher = this.teachers[i];
      System.out.printf(" %s,%s,%d,%s,%s,%s,%s,%s\n",
        teacher.name,
        teacher.gender,
        teacher.age,
        teacher.career,
        teacher.skill,
        teacher.major,
        teacher.email,
        teacher.tel);
 }
}
private void doAdd() {

while (length < this.teachers.length) { // this = 티처컨트롤러 객체 3개
 Teacher teacher = new Teacher(); // 반복문이 돌때마다 새로 생성됨.
  System.out.print("이름(예:홍길동)? ");
   teacher.name = this.keyScan.nextLine();

  System.out.print("성별? ");
   teacher.gender = this.keyScan.nextLine();

  System.out.print("나이? ");
   teacher.age = Integer.parseInt(this.keyScan.nextLine());

  System.out.print("경력(예:20년차)? ");
   teacher.career = this.keyScan.nextLine();

  System.out.print("능력? ");
   teacher.skill = this.keyScan.nextLine();

  System.out.print("전공? ");
   teacher.major = this.keyScan.nextLine();

  System.out.print("이메일(예:hong@test.com)? ");
   teacher.email = this.keyScan.nextLine();

  System.out.print("전화번호(예:010-1111-1111)? ");
   teacher.tel = this.keyScan.nextLine();

   this.teachers[length++] = teacher; // length 현재 값을 두는 것. 0은 변하지않음.
    System.out.print("계속 입력하시겠습니까(y/n)?");
     if (!this.keyScan.nextLine().equals("y")) // 키스캔에 입력된 값이 y와 같지않다면 if문 실행
      break;
 }

}
private void doDelete() {
 System.out.print("삭제할 이름은? ");
  String name = this.keyScan.nextLine().toLowerCase();

   for (int i = 0; i < this.length; i++) { // i번째
    if (this.teachers[i].name.toLowerCase().equals(name)) {
      for (int x = i + 1; x < length; x++) {
        this.teachers[i++] = this.teachers[x];
      }
      this.teachers[--length] = null;

      System.out.printf("%s 학생 정보를 삭제하였습니다.\n", name);
      return; //함수 실행을 종료한다. 현재 함수를 나가라
   }
 }
    System.out.printf("%s 학생을 찾을 수 없습니다.", name);
  }
  private void doUpdate() {
   System.out.print("변경할 강사의 이름은? ");
    String name = this.keyScan.nextLine().toLowerCase();
     for (int i = 0; i < this.length; i++) { // i번째
      if (this.teachers[i].name.toLowerCase().equals(name)) {
        Teacher teacher = new Teacher();
        teacher.name = this.teachers[i].name;
        System.out.print("성별? ");
         teacher.gender = this.keyScan.nextLine();

        System.out.print("나이? ");
         teacher.age = Integer.parseInt(this.keyScan.nextLine());

        System.out.print("경력(예:20년차)? ");
         teacher.career = this.keyScan.nextLine();

        System.out.print("능력? ");
         teacher.skill = this.keyScan.nextLine();

        System.out.print("전공? ");
         teacher.major = this.keyScan.nextLine();

        System.out.print("이메일(예:hong@test.com)? ");
         teacher.email = this.keyScan.nextLine();

        System.out.print("전화번호(예:010-1111-1111)? ");
         teacher.tel = this.keyScan.nextLine();

          System.out.print("저장 하시겠습니까(y/n)?");
           if (this.keyScan.nextLine().equals("y")) {
             this.teachers[i] = teacher;
            break;
          }
          System.out.print("정말 취소하십니까(y/n)?");
           if (this.keyScan.nextLine().equals("y")) {
             System.out.println("변경을 취소하였습니다.");
            return;
         }


      }
      System.out.printf("%s 학생을 찾을 수 없습니다.\n", name);
    }
}

private void doview() {
 System.out.println("조회할 강사 이름은? ");
  String name = this.keyScan.nextLine().toLowerCase();
   for (int i = 0; i < this.length; i++) { // i번째
    if (this.teachers[i].name.toLowerCase().equals(name)) {
      System.out.printf("이름: %s\n", this.teachers[i].name);
      System.out.printf("성별: %s\n", this.teachers[i].gender);
      System.out.printf("나이: %d\n", this.teachers[i].age);
      System.out.printf("경력: %s\n", this.teachers[i].career);
      System.out.printf("능력: %s\n", this.teachers[i].skill);
      System.out.printf("전공: %s\n", this.teachers[i].major);
      System.out.printf("이메일: %s\n", this.teachers[i].email);
      System.out.printf("전화번호: %s\n", this.teachers[i].tel);
    break;
  }
  System.out.printf("%s 학생을 찾을 수 없습니다.\n", name);
}

}
}
