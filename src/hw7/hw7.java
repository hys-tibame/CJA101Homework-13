package hw7;

import org.junit.jupiter.api.Test;

import java.io.*;

public class hw7 {
    public static void main(String[] args) {
//        • 請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:
//        Sample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料


        m1();


//        • 請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 (請使用
//        append功能讓每次執行結果都能被保存起來)


//        m2();


//        • 請從無到有試著完成一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個參數所
//        代表的檔案會複製到第二個參數代表的檔案


//        File f1 = new File("src/hw7/zundamon.jpg");
//        File f2 = new File("src/hw7/zundamon_Copy.jpg");
//        m3_copyFile(f1, f2);



//        • 請寫一支程式,利用老師提供的Dog與Cat類別分別產生兩個物件,寫到C:\data\Object.ser裡。注
//        意物件寫入需注意的事項,若C:\內沒有data資料夾,請用程式新增這個資料夾


//        m4();


//        • 承上題,請寫一個程式,能讀取Object.ser這四個物件,並執行speak()方法觀察結果如何 (請利用多
//        型簡化本題的程式設計)


//        m5();


    }

//    @Test
    public static void m1() {
        String filePath = "src/hw7/Sample.txt";
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(filePath);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            int textCount = 0;
            int lineCount = 0;
            while((line = br.readLine()) != null) {
                lineCount++;
                textCount += line.toCharArray().length;
            }
            System.out.println(file.getName() + "檔案共有" + file.length() + "個位元組," + textCount + "個字元," +
                    lineCount + "列資料");

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    @Test
    public static void m2() {
        // • 請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 (請使用
        // append功能讓每次執行結果都能被保存起來)

        String filePath = "src/hw7/Data.txt";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath, true));
            for(int i = 0; i < 10; i++){
                int r = (int)(Math.random() * 1000) + 1;
                bw.write(r + " ");
            }
            System.out.println("寫入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void m3_copyFile(File f1, File f2) {
        //        • 請從無到有試著完成一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個參數所
        //        代表的檔案會複製到第二個參數代表的檔案
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream(f1);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(f2);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] buff = new byte[1024];
            int readLen = 0;
            while((readLen = bufferedInputStream.read(buff)) != -1) {
                bufferedOutputStream.write(buff, 0, readLen);
            }
            System.out.println("複製成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if(bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    @Test
    public static void m4() {
//        • 請寫一支程式,利用老師提供的Dog與Cat類別分別產生兩個物件,寫到C:\data\Object.ser裡。注
//        意物件寫入需注意的事項,若C:\內沒有data資料夾,請用程式新增這個資料夾

        String filePath = "src/hw7/data/Object.ser";
        File file = new File(filePath);
        if(file.getParentFile().mkdirs()) {
            System.out.println("資料夾建立成功...");
        } else {
            System.out.println("資料夾已存在或建立失敗...");
        }

        ObjectOutputStream objectOutputStream = null;
        Dog dog = new Dog("Tom", 3, "Black");
        dog.setBark(true);
        Cat cat = new Cat("Mary", 5, "Orange");
        cat.setMeow(true);

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(dog);
            objectOutputStream.writeObject(cat);
            System.out.println("物件寫入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

//    @Test
    public static void m5() {
        String filePath = "src/hw7/data/Object.ser";
        File file = new File(filePath);
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));

            Animal ani = (Animal) objectInputStream.readObject();
            ani.speak();
            System.out.println("---");
            ani = (Animal) objectInputStream.readObject();
            ani.speak();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

interface Animal extends Serializable {
    void speak();
}

class Dog implements Animal{
    private String name;
    private int age;
    private String color;
    private boolean bark;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBark() {
        return bark;
    }

    public void setBark(boolean bark) {
        this.bark = bark;
    }

    @Override
    public void speak() {
        System.out.println("Woof!");
        System.out.println(toString());

    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", bark=" + bark +
                '}';
    }
}

class Cat implements Animal{
    private String name;
    private int age;
    private String color;
    private boolean meow;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMeow() {
        return meow;
    }

    public void setMeow(boolean meow) {
        this.meow = meow;
    }

    @Override
    public void speak() {
        System.out.println("Meow~");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", meow=" + meow +
                '}';
    }
}
