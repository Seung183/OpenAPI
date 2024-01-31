import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Person person = new Person("1","kim",15);
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
//            oos.writeObject(person);
//            System.out.println("Serialization complete");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 파일에서 객체를 역직렬화
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
//            Person deserializedPerson = (Person) ois.readObject();
//            System.out.println("Deserialization complete");
//            System.out.println("Name: " + deserializedPerson.getName());
//            System.out.println("Age: " + deserializedPerson.getAge());
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            // 직렬화할 객체 생성
            Person person = new Person("101", "쯔위", 25);

            // ByteArrayOutputStream을 사용하여 객체를 직렬화한 후의 바이트 배열 획득
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.close();

            // 바이트 배열을 문자열로 변환하여 출력
            String serializedString = byteArrayOutputStream.toString("ISO-8859-1");
            System.out.println("Serialized Object: " + serializedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}